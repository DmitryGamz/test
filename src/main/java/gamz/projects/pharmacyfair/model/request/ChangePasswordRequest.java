package gamz.projects.pharmacyfair.model.request;

import gamz.projects.pharmacyfair.model.annotation.PasswordsNotEqual;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@PasswordsNotEqual
public class ChangePasswordRequest {
    @NotBlank
    @Size(min = 6, max = 20)
    private String newPassword;

    @NotBlank
    @Size(min = 6, max = 20)
    private String newPasswordRepeat;
}
