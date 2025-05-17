package gamz.projects.pharmacyfair.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gamz.projects.pharmacyfair.model.dto.FeedbackDTO;
import gamz.projects.pharmacyfair.model.request.FeedbackRequest;
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
    public ResponseEntity<List<FeedbackDTO>> getAllFeedback(
        @Parameter(description = "Фильтрация по isProcessed") @RequestParam(required = false) Optional<Boolean> isProcessed
    ) {
        return ResponseEntity.ok(feedbackService.getAllFeedback(isProcessed));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить обратную связь по id")
    public ResponseEntity<FeedbackDTO> getFeedbackById(
        @Parameter(description = "ID обратной связи") @PathVariable Long id
    ) {
        return ResponseEntity.ok(feedbackService.getFeedbackById(id));
    }

    @PostMapping
    @Operation(summary = "Создать обратную связь")
    public ResponseEntity<FeedbackDTO> createFeedback(
        @Parameter(description = "Данные обратной связи") @RequestBody @Valid FeedbackRequest request
    ) {
        return ResponseEntity.status(201).body(feedbackService.createFeedback(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить обратную связь")
    public ResponseEntity<FeedbackDTO> editFeedback(
        @Parameter(description = "ID обратной связи") @PathVariable Long id,
        @Parameter(description = "Обновленные данные обратной связи") @RequestBody FeedbackRequest request
    ) {
        return ResponseEntity.ok(feedbackService.editFeedback(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить обратную связь")
    public ResponseEntity<FeedbackDTO> deleteFeedback(
        @Parameter(description = "ID обратной связи") @PathVariable Long id
    ) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }
}
