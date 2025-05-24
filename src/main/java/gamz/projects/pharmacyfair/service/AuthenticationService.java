package gamz.projects.pharmacyfair.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import gamz.projects.pharmacyfair.configuration.jwt.JwtService;
import gamz.projects.pharmacyfair.model.entity.User;
import gamz.projects.pharmacyfair.model.entity.VerificationStatus;
import gamz.projects.pharmacyfair.model.entity.VerificationToken;
import gamz.projects.pharmacyfair.model.exception.UserAlreadyExistException;
import gamz.projects.pharmacyfair.model.exception.UserNotFoundException;
import gamz.projects.pharmacyfair.model.mapper.UserMapper;
import gamz.projects.pharmacyfair.model.request.AuthenticationRequest;
import gamz.projects.pharmacyfair.model.request.RegisterRequest;
import gamz.projects.pharmacyfair.model.response.AuthenticationResponse;
import gamz.projects.pharmacyfair.model.response.RegistrationResponse;
import gamz.projects.pharmacyfair.repository.RoleRepository;
import gamz.projects.pharmacyfair.repository.UserRepository;
import gamz.projects.pharmacyfair.repository.VerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	private final UserMapper userMapper;
	private final VerificationTokenRepository verificationTokenRepository;
	private final EmailService emailService;

	public RegistrationResponse register(RegisterRequest request) {
		request.setPassword(passwordEncoder.encode(request.getPassword()));
		User user = userMapper.toUserFromRegisterRequest(request);

		if (userRepository.findByEmail(user.getEmail()).isPresent()) {
			throw new UserAlreadyExistException("Email уже используется");
		}

		user.setRoles(
				List.of(roleRepository.findByName("USER")
						.orElseThrow(() -> new RuntimeException("Role USER not found"))));
		user.setVerificationStatus(VerificationStatus.UNVERIFIED);

		userRepository.save(user);
		this.createVerificationToken(user);

		return new RegistrationResponse(
				"Регистрация прошла успешно. Проверьте email для подтверждения аккаунта.",
				user.getEmail()
		);
	}
	
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getEmail(),
						request.getPassword()
				)
		);
		var user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new UserNotFoundException("Пользователь с таким именем не существует"));
		if (user.getVerificationStatus().equals(VerificationStatus.UNVERIFIED)) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Учетная запись не подтверждена");
		}
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}
	
	public void clearAuthentication() {
		SecurityContextHolder.clearContext();
	}

	public void verify(String token) {
		VerificationToken verificationToken = verificationTokenRepository.findByToken(token)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Токен поврежден"));

		if (verificationToken.isExpired()) {
			verificationTokenRepository.delete(verificationToken);
			VerificationToken newToken = createVerificationToken(verificationToken.getUser());
			emailService.sendVerificationLink(newToken.getUser().getEmail(), newToken.getToken());
			throw new ResponseStatusException(HttpStatus.GONE, "Вышел срок действия токена. На почту указанную при регистрации была выслана новая ссылка.");
		}

		User user = verificationToken.getUser();
		user.setVerificationStatus(VerificationStatus.VERIFIED);
		userRepository.save(user);
		verificationTokenRepository.delete(verificationToken);
	}

	public VerificationToken createVerificationToken(User user) {
		String token = UUID.randomUUID().toString();
		LocalDateTime expiryDate = LocalDateTime.now().plusHours(24);
		VerificationToken verificationToken = VerificationToken.builder()
				.token(token)
				.user(user)
				.expiryDate(expiryDate)
				.build();
		return verificationTokenRepository.save(verificationToken);
	}
}
