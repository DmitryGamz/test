package gamz.projects.pharmacyfair.service;

import gamz.projects.pharmacyfair.configuration.jwt.JwtService;
import gamz.projects.pharmacyfair.model.entity.Role;
import gamz.projects.pharmacyfair.model.entity.User;
import gamz.projects.pharmacyfair.model.exception.UserAlreadyExistException;
import gamz.projects.pharmacyfair.model.exception.UserNotFoundException;
import gamz.projects.pharmacyfair.model.mapper.UserMapper;
import gamz.projects.pharmacyfair.model.request.AuthenticationRequest;
import gamz.projects.pharmacyfair.model.request.RegisterRequest;
import gamz.projects.pharmacyfair.model.response.AuthenticationResponse;
import gamz.projects.pharmacyfair.repository.RoleRepository;
import gamz.projects.pharmacyfair.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private RoleRepository roleRepository;
	
	@Mock
	private PasswordEncoder passwordEncoder;
	
	@Mock
	private JwtService jwtService;
	
	@Mock
	private AuthenticationManager authenticationManager;
	
	@Mock
	private UserMapper userMapper;
	
	@InjectMocks
	private AuthenticationService authenticationService;
	
	private RegisterRequest registerRequest;
	private AuthenticationRequest authRequest;
	private User user;
	private Role role;
	
	@BeforeEach
	void setUp() {
		// Set up test data
		registerRequest = new RegisterRequest();
		registerRequest.setEmail("test@example.com");
		registerRequest.setPassword("password");
		registerRequest.setFirstName("Test");
		registerRequest.setLastName("User");
		
		authRequest = new AuthenticationRequest();
		authRequest.setEmail("test@example.com");
		authRequest.setPassword("password");
		
		role = new Role();
		role.setId(1);
		role.setName("USER");
		
		user = User.builder()
				.id(1)
				.email("test@example.com")
				.password("encodedPassword")
				.firstName("Test")
				.lastName("User")
				.roles(Collections.singletonList(role))
				.build();
	}
	
	@Test
	@DisplayName("Should register new user successfully")
	void register_Success() {
		// Arrange
		when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.empty());
		when(passwordEncoder.encode("password")).thenReturn("encodedPassword");
		when(userMapper.toUserFromRegisterRequest(any(RegisterRequest.class))).thenReturn(user);
		when(roleRepository.findByName("USER")).thenReturn(Optional.of(role));
		when(userRepository.save(any(User.class))).thenReturn(user);
		when(jwtService.generateToken(user)).thenReturn("jwtToken");
		
		// Act
		AuthenticationResponse response = authenticationService.register(registerRequest);
		
		// Assert
		assertNotNull(response);
		assertEquals("jwtToken", response.getToken());
		verify(userRepository, times(1)).findByEmail("test@example.com");
		verify(passwordEncoder, times(1)).encode("password");
		verify(userMapper, times(1)).toUserFromRegisterRequest(any(RegisterRequest.class));
		verify(roleRepository, times(1)).findByName("USER");
		verify(userRepository, times(1)).save(any(User.class));
		verify(jwtService, times(1)).generateToken(user);
	}
	
	@Test
	@DisplayName("Should throw exception when registering with existing email")
	void register_EmailAlreadyExists() {
		// Arrange
		when(userMapper.toUserFromRegisterRequest(any(RegisterRequest.class))).thenReturn(user);
		when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));
		
		// Act & Assert
		assertThrows(UserAlreadyExistException.class, () -> authenticationService.register(registerRequest));
		verify(userRepository, times(1)).findByEmail("test@example.com");
		verify(roleRepository, never()).findByName(anyString());
		verify(userRepository, never()).save(any(User.class));
		verify(jwtService, never()).generateToken(any(User.class));
	}
	
	@Test
	@DisplayName("Should authenticate user successfully")
	void authenticate_Success() {
		// Arrange
		when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));
		when(jwtService.generateToken(user)).thenReturn("jwtToken");
		
		// Act
		AuthenticationResponse response = authenticationService.authenticate(authRequest);
		
		// Assert
		assertNotNull(response);
		assertEquals("jwtToken", response.getToken());
		verify(authenticationManager, times(1)).authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
		verify(userRepository, times(1)).findByEmail("test@example.com");
		verify(jwtService, times(1)).generateToken(user);
	}
	
	@Test
	@DisplayName("Should throw exception when authenticating with non-existent email")
	void authenticate_UserNotFound() {
		// Arrange
		when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.empty());
		when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(null);
		
		// Act & Assert
		assertThrows(UserNotFoundException.class, () -> authenticationService.authenticate(authRequest));
		verify(authenticationManager, times(1)).authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
		verify(userRepository, times(1)).findByEmail("test@example.com");
		verify(jwtService, never()).generateToken(any(User.class));
	}
}