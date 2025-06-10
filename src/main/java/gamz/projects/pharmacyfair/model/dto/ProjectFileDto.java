package gamz.projects.pharmacyfair.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "Возвращает метаданные загруженного файла")
public class ProjectFileDto {

    @NotNull
    private String name;

    @NotNull
    private String path;

    private Long fileType;

    private Long size;

    private String mimeType;

    private LocalDateTime uploadedAt;
}
