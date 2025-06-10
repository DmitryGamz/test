package gamz.projects.pharmacyfair.controller;

import gamz.projects.pharmacyfair.model.dto.FileTypeDto;
import gamz.projects.pharmacyfair.service.interfaces.FileTypeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file-type")
public class FileTypeController {

    private final FileTypeService fileTypeService;

    @PostMapping("/create")
    @Operation(
            summary = "Создание объекта FileType",
            description = "Для создания объекта необходимо в теле запроса передать " +
                    "json с полями code, name, description. В ответе json с полями code, name, description"
    )
    public ResponseEntity<FileTypeDto> createFileType(@Valid @RequestBody FileTypeDto fileTypeDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(fileTypeService.createFileType(fileTypeDto));
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Получить объект FileType",
            description = "Для получения объекта FileType необходимо в запросе указать id объекта. В ответе " +
                    "json с полями code, name, description"
    )
    public ResponseEntity<FileTypeDto> readFileType(@PathVariable Long id){
        return ResponseEntity.ok(fileTypeService.readFileType(id));
    }

    @Operation(
            summary = "Обновление объекта FileType",
            description = "Для обновления объекта необходимо передать id в запрос и в теле запроса передать " +
                    "json с полями code, name, description. В ответе - json с полями code, name, description"
    )
    @PatchMapping("{id}")
    public ResponseEntity<FileTypeDto> updateFileType(@Valid @RequestBody FileTypeDto fileTypeDto,
                                                      @PathVariable Long id){
        return ResponseEntity.ok(fileTypeService.updateFileType(fileTypeDto, id));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Удаление объекта FileType",
            description = "Для удаления объекта FileType необходимо в запросе указать id объекта, ничего не возвращает"
    )
    public void deleteFileType(@PathVariable Long id){
        fileTypeService.deleteFileType(id);
    }
}
