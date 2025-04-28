package gamz.projects.pharmacyfair.model.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackCreateRequest {

    @Valid
    @NotEmpty(message = "Поле имя должно быть заполнено")
    @Size(max = 255, message = "Поле Имя не должно быть больше 255 символов")
    private String name;

    @Valid
    @NotEmpty(message = "Поле Email должно быть заполнено")
    @Size(max = 255, message = "Поле Email не должно быть больше 255 символов")
    private String email;

    @Valid
    @NotEmpty(message = "Поле Сообщение должно быть заполнено")
    @Size(max = 255, message = "Поле Сообщение не должно быть больше 255 символов")
    private String message;
}
