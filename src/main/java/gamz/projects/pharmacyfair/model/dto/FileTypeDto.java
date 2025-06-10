package gamz.projects.pharmacyfair.model.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Schema(description = "DTO для работы с FileType")
public class FileTypeDto {

    @NotNull
    @Schema(description = "Код типа файла", example = "DOCX")
    private String code;

    @NotNull
    @Schema(description = "Название файла", example = "Больничные")
    private String name;

    @Schema(description = "Содержание файла", example = "Содержат информацию о выплатах сотрудникам")
    private String description;
}