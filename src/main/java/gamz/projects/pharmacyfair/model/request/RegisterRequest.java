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
public class RegisterRequest {
	@Valid
	@NotEmpty(message = "Вы должны указать имя")
	private String firstName;

	@Valid
	@NotEmpty(message = "Вы должны указать фамилию")
	private String lastName;

	@Valid
	@NotEmpty(message = "Вы должны указать email")
	private String email;

	private String phone;

	@Valid
	@NotEmpty(message = "Вы должны указать пароль")
	private String password;
}
