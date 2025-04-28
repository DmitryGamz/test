package gamz.projects.pharmacyfair.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorNotFoundResponse {
    final static String status = "error";
    private String message;
}
