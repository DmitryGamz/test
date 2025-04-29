package gamz.projects.pharmacyfair.model.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class ApiException extends Exception {
	private final int statusCode;
	private final String message;
}
