package gamz.projects.pharmacyfair.controller;

import gamz.projects.pharmacyfair.model.request.AuthenticationRequest;
import gamz.projects.pharmacyfair.model.request.RegisterRequest;
import gamz.projects.pharmacyfair.model.response.AuthenticationResponse;
import gamz.projects.pharmacyfair.model.response.RegistrationResponse;
import gamz.projects.pharmacyfair.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication Controller", description = "API для работы с авторизацией/регистрацией пользователя")
public class AuthenticationController {
	
	private final AuthenticationService service;
	
	@PostMapping("/register")
	@Operation(summary = "Зарегистрировать пользователя")
	public ResponseEntity<RegistrationResponse> register(
			@Parameter(description = "Данные для регистрации") @RequestBody RegisterRequest request
	) {
		return ResponseEntity.ok(service.register(request));
	}
	
	@PostMapping("/authenticate")
	@Operation(summary = "Аутентифицировать пользователя")
	public ResponseEntity<AuthenticationResponse> authenticate(
			@Parameter(description = "Данные для аутентификации (email, пароль)") @RequestBody AuthenticationRequest request
	) {
		return ResponseEntity.ok(service.authenticate(request));
	}
	
	@GetMapping("/clear")
	@Operation(summary = "Сбросить аутентификацию")
	public ResponseEntity<String> clearAuthentication() {
		service.clearAuthentication();
		return ResponseEntity.ok("Вы успешно вышли из системы.");
	}

	@GetMapping("/verify")
	@Operation(summary = "Верифицировать аккаунт")
	public ResponseEntity<String> verifyAccount(
			@Parameter(description = "Токен для верификации") @RequestParam String token) {
		service.verify(token);
		return ResponseEntity.ok("Аккаунт верифицирован. Вы успешно подтвердили email.");
	}
}
