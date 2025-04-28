package gamz.projects.pharmacyfair.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackCreateResponse {
    final static String message = "Успешно отправлено";

    // Номер заявки (id) для отслеживания пользователем.
    private long feedbackNumber;
}
