package gamz.projects.pharmacyfair.model.response;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorValidationResponse {
    final private String status = "error";
    private HashMap<String, String> errors;
}