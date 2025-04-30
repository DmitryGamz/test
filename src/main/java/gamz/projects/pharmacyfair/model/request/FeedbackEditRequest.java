package gamz.projects.pharmacyfair.model.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackEditRequest {

    @Valid
    @Size(max = 255, message = "Поле Имя не должно быть больше 255 символов")
    private String name;

    @Valid
    @Size(max = 255, message = "Поле Email не должно быть больше 255 символов")
    private String email;

    private String message;

    private Long processedBy;

    private Boolean isProcessed;
}
