package gamz.projects.pharmacyfair.model.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
	@Valid
	@NotEmpty(message = "Вы должны заполнить email")
	private String email;
	@Valid
	@NotEmpty(message = "Вы должны заполнить пароль")
	String password;
}
