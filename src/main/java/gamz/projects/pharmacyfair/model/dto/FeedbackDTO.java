package gamz.projects.pharmacyfair.model.dto;

import io.micrometer.common.lang.NonNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
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
    private final String processedAt;
    private final String createdAt;
}
