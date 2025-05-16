package gamz.projects.pharmacyfair.model.dto;

import io.micrometer.common.lang.NonNull;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@Builder
public class FeedbackDTO {
    private final long id;
    @NonNull
    private final String name;
    @NonNull
    private final String email;
    @NonNull
    private final String message;
    private final Boolean isProcessed;
    private final long processedBy;
    private final LocalDate processedAt;
    private final LocalDate createdAt;
}
