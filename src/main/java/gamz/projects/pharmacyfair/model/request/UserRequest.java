package gamz.projects.pharmacyfair.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserRequest {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String middleName;

    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Некорректный формат телефона")
    private String phone;

    private String jobTitle;
}
