package gamz.projects.pharmacyfair.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gamz.projects.pharmacyfair.model.dto.FeedbackDTO;
import gamz.projects.pharmacyfair.model.exception.FeedbackNotFoundException;
import gamz.projects.pharmacyfair.model.request.FeedbackCreateRequest;
import gamz.projects.pharmacyfair.model.response.ErrorNotFoundResponse;
import gamz.projects.pharmacyfair.model.response.ErrorValidationResponse;
import gamz.projects.pharmacyfair.service.FeedbackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/feedback")
@RequiredArgsConstructor
@Tag(name = "Feedback", description = "API для работы с обратной связью от пользователей")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @GetMapping
    @Operation(summary = "Получить всю обратную связь")
    public ResponseEntity<List<FeedbackDTO>> getAllFeedback() {
        return ResponseEntity.ok(feedbackService.getAllFeedback());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить обратную связь по id")
    public ResponseEntity<FeedbackDTO> getFeedbackById(
        @Parameter(description = "ID ") @PathVariable Long id
    ) {
        return ResponseEntity.ok(feedbackService.getFeedbackById(id));
    }

    @PostMapping
    @Operation(summary = "Создать обратную связь")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FeedbackDTO> createFeedback(
        @Parameter(description = "Данные обратной связи") @RequestBody @Valid FeedbackCreateRequest request
    ) {
        return ResponseEntity.ok(feedbackService.createFeedback(request));
    }

    @PostMapping("/process/{id}")
    @Operation(summary = "Обработать заявку от обратной связи")
    public ResponseEntity<FeedbackDTO> processFeedback(
        @Parameter(description = "ID обратной связи") @PathVariable Long id
    ) {
        // ToDo: Доделать обработку заявок
        return ResponseEntity.ok(feedbackService.processFeedback(id, null));
    }

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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(FeedbackNotFoundException.class)
    public ResponseEntity<ErrorNotFoundResponse> handleNotFoundExceptions(FeedbackNotFoundException ex) {
        ErrorNotFoundResponse response = ErrorNotFoundResponse.builder().message(ex.getMessage()).build();
        return ResponseEntity.badRequest().body(response);
    }
}
