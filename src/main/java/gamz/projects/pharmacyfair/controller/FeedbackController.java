package gamz.projects.pharmacyfair.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gamz.projects.pharmacyfair.model.request.FeedbackCreateRequest;
import gamz.projects.pharmacyfair.model.response.ErrorValidationResponse;
import gamz.projects.pharmacyfair.service.FeedbackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/feedback")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService service;

    @PostMapping("/create")
    public ResponseEntity<?> create(
        @RequestBody @Valid FeedbackCreateRequest request
    ) {
        return ResponseEntity.ok(service.create(request));
    }

    // ToDo: add processing of feedback

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorValidationResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        HashMap <String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return ResponseEntity.ok(ErrorValidationResponse.builder().errors(errors).build());
    }
}
