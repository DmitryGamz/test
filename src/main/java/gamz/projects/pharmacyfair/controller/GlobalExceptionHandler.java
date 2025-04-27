package gamz.projects.pharmacyfair.controller;

import gamz.projects.pharmacyfair.model.exception.ApiException;
import gamz.projects.pharmacyfair.model.exception.UserAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ApiException> catchException(UserAlreadyExistException e) {

        log.error(e.getMessage(), e);

        return new ResponseEntity<>(
                new ApiException(
                        HttpStatus.BAD_REQUEST.value(),
                        e.getMessage()
                ), HttpStatus.BAD_REQUEST);
    }
}
