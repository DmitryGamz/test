package gamz.projects.pharmacyfair.controller;

import gamz.projects.pharmacyfair.model.dto.UserDTO;
import gamz.projects.pharmacyfair.model.request.ChangePasswordRequest;
import gamz.projects.pharmacyfair.model.request.UserRequest;
import gamz.projects.pharmacyfair.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Settings", description = "API для работы с пользователем")
public class UserController {
	private final UserService userService;

	@GetMapping
	@Operation(summary = "Получить данные текущего пользователя")
	public ResponseEntity<UserDTO> getProfile() {
		return ResponseEntity.ok(userService.getCurrentUserProfile());
	}

	@PutMapping
	@Operation(summary = "Обновить данные текущего пользователя")
	public ResponseEntity<UserDTO> updateProfile(@Valid @RequestBody UserRequest request) {
		return ResponseEntity.ok(userService.updateCurrentUserProfile(request));
	}

	@PostMapping("/change-password")
	@Operation(summary = "Сменить пароль текущего пользователя")
	public ResponseEntity<Void> changePassword(@Valid @RequestBody ChangePasswordRequest request) {
		userService.changePassword(request);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping
	@Operation(summary = "Удалить аккаунт текущего пользователя")
	public ResponseEntity<Void> deleteAccount() {
		userService.deleteCurrentUser();
		return ResponseEntity.noContent().build();
	}
}
