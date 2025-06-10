package gamz.projects.pharmacyfair.controller;

import gamz.projects.pharmacyfair.model.exception.FileNotAccessibleException;
import gamz.projects.pharmacyfair.model.exception.FileStorageException;
import gamz.projects.pharmacyfair.model.exception.InvalidFileException;
import gamz.projects.pharmacyfair.model.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.naming.ServiceUnavailableException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	/**
	 * Handles all validation-related exceptions
	 * @param ex exception from validator
	 * @param request request
	 * @return response
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationExceptions(
			MethodArgumentNotValidException ex, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		ErrorResponse response = ErrorResponse.builder()
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.BAD_REQUEST.value())
				.error(errors.toString())
				.path(request.getDescription(false).replace("uri=", ""))
				.build();

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handle all exceptions and sorts their by type
	 * @param ex exception
	 * @param request request
	 * @return response
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGlobalExceptions(Exception ex, WebRequest request) {
		log.error("Unhandled exception: {}", ex.getMessage(), ex);

		HttpStatus status;

		ErrorResponse response = ErrorResponse.builder()
				.timestamp(LocalDateTime.now())
				.error(ex.getMessage())
				.path(request.getDescription(false).replace("uri=", ""))
				.build();

		if (isNotFoundException(ex)) {
			status = HttpStatus.NOT_FOUND;
			response.setStatus(status.value());
		} else if (isAlreadyExist(ex)) {
			status = HttpStatus.CONFLICT;
			response.setStatus(status.value());
		} else {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setStatus(status.value());
		}

		return new ResponseEntity<>(response, status);
	}

	/**
	 * Handles all exceptions related to unsuccessful authorization
	 * @param ex exception
	 * @param request request
	 * @return response
	 */
	@ExceptionHandler({
			AuthenticationCredentialsNotFoundException.class,
			BadCredentialsException.class
	})
	public ResponseEntity<ErrorResponse> handleAuthExceptions(Exception ex, WebRequest request) {

		ErrorResponse response = ErrorResponse.builder()
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.UNAUTHORIZED.value())
				.error(ex.getMessage())
				.path(request.getDescription(false).replace("uri=", ""))
				.build();

		return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
	}

	/**
	 * Handles all exceptions related to access denial
	 * @param ex exception
	 * @param request request
	 * @return response
	 */
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorResponse> handleAccessDenied(AccessDeniedException ex, WebRequest request) {
		ErrorResponse response = ErrorResponse.builder()
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.FORBIDDEN.value())
				.error(ex.getMessage())
				.path(request.getDescription(false).replace("uri=", ""))
				.build();

		return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
	}

	/**
	 * Handles all exceptions related to the unavailability of the service
	 * @param ex exception
	 * @param request request
	 * @return response
	 */
	@ExceptionHandler(ServiceUnavailableException.class)
	public ResponseEntity<ErrorResponse> handleServiceUnavailable(ServiceUnavailableException ex, WebRequest request) {
		ErrorResponse response = ErrorResponse.builder()
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.SERVICE_UNAVAILABLE.value())
				.error(ex.getMessage())
				.path(request.getDescription(false).replace("uri=", ""))
				.build();

		return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
	}

	private boolean isNotFoundException(Exception ex) {
		String exceptionName = ex.getClass().getSimpleName();
		return exceptionName.toLowerCase().contains("notfound");
	}

	private boolean isAlreadyExist(Exception ex) {
		String exceptionName = ex.getClass().getSimpleName();
		return exceptionName.toLowerCase().contains("alreadyexist");
	}
//
//	@ExceptionHandler(DataIntegrityViolationException.class)
//	public ResponseEntity<ErrorResponse> handleDataError(DataIntegrityViolationException ex) {
//		String rootMessage = ex.getRootCause() != null ? ex.getRootCause().getMessage() : "Неизвестная причина";
//		String message;
//
//		if (rootMessage.toLowerCase().contains("constraint")) {
//			message = "Невозможно удалить: объект связан с другими сущностями. ";
//		} else {
//			message = "Ошибка при сохранении в БД. ";
//		}
//
//		return ResponseEntity.status(HttpStatus.CONFLICT)
//				.body(new ErrorResponse(409, message + rootMessage, LocalDateTime.now()));
//	}
//
//	@ExceptionHandler(HttpMessageNotReadableException.class)
//	public ResponseEntity<ErrorResponse> handleJsonError(HttpMessageNotReadableException ex) {
//		return ResponseEntity.badRequest()
//				.body(new ErrorResponse(400, "Ошибка чтения запроса. Проверь формат JSON", LocalDateTime.now()));
//	}
//
//	@ExceptionHandler(InvalidFileException.class)
//	public ResponseEntity<ErrorResponse> handleInvalidFile(InvalidFileException ex){
//		return ResponseEntity.badRequest().body(
//				new ErrorResponse(400, ex.getMessage(), LocalDateTime.now()));
//	}
//
//	@ExceptionHandler(FileStorageException.class)
//	public ResponseEntity<ErrorResponse> handleFileStorage(FileStorageException ex){
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
//				new ErrorResponse(500, ex.getMessage(), LocalDateTime.now())
//		);
//	}
//
//	@ExceptionHandler(FileNotAccessibleException.class)
//	public ResponseEntity<ErrorResponse> handleFileNotAccessible(FileNotAccessibleException ex){
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
//				new ErrorResponse(405, ex.getMessage(), LocalDateTime.now())
//		);
//	}
}
