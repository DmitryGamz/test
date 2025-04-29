package gamz.projects.pharmacyfair.controller;

import gamz.projects.pharmacyfair.model.exception.ApiException;
import gamz.projects.pharmacyfair.model.exception.PatentNotFoundException;
import gamz.projects.pharmacyfair.model.exception.PatentTypeNotFoundException;
import gamz.projects.pharmacyfair.model.exception.UserAlreadyExistException;
import gamz.projects.pharmacyfair.model.exception.UserNotFoundException;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@TestConfiguration
public class TestGlobalExceptionHandler {
	
	@Bean
	@Primary
	public TestExceptionHandler testExceptionHandler() {
		return new TestExceptionHandler();
	}
	
	@RestControllerAdvice
	public static class TestExceptionHandler {
		
		@ExceptionHandler(UserAlreadyExistException.class)
		public ResponseEntity<ApiException> handleUserAlreadyExistException(UserAlreadyExistException e) {
			return new ResponseEntity<>(
					new ApiException(HttpStatus.BAD_REQUEST.value(), e.getMessage()),
					HttpStatus.BAD_REQUEST
			);
		}
		
		@ExceptionHandler(UserNotFoundException.class)
		public ResponseEntity<ApiException> handleUserNotFoundException(UserNotFoundException e) {
			return new ResponseEntity<>(
					new ApiException(HttpStatus.NOT_FOUND.value(), e.getMessage()),
					HttpStatus.NOT_FOUND
			);
		}
		
		@ExceptionHandler(PatentTypeNotFoundException.class)
		public ResponseEntity<ApiException> handlePatentTypeNotFoundException(PatentTypeNotFoundException e) {
			return new ResponseEntity<>(
					new ApiException(HttpStatus.NOT_FOUND.value(), e.getMessage()),
					HttpStatus.NOT_FOUND
			);
		}
		
		@ExceptionHandler(PatentNotFoundException.class)
		public ResponseEntity<ApiException> handlePatentNotFoundException(PatentNotFoundException e) {
			return new ResponseEntity<>(
					new ApiException(HttpStatus.NOT_FOUND.value(), e.getMessage()),
					HttpStatus.NOT_FOUND
			);
		}
	}
}