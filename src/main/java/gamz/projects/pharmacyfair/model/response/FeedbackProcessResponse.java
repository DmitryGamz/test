package gamz.projects.pharmacyfair.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FeedbackProcessResponse {
    final static String message = "Заявка успешно одобрена";
}
