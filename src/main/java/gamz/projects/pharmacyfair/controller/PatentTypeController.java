package gamz.projects.pharmacyfair.controller;

import gamz.projects.pharmacyfair.model.dto.PatentTypeDTO;
import gamz.projects.pharmacyfair.model.request.PatentTypeRequest;
import gamz.projects.pharmacyfair.service.PatentTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patent-types")
@RequiredArgsConstructor
@Tag(name = "Patent Types", description = "API для работы с типами патентов")
public class PatentTypeController {

    private final PatentTypeService patentTypeService;

    @GetMapping
    @Operation(summary = "Получить все типы патентов")
    public ResponseEntity<List<PatentTypeDTO>> getAllPatentTypes() {
        return ResponseEntity.ok(patentTypeService.getAllPatentTypes());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить тип патента по ID")
    public ResponseEntity<PatentTypeDTO> getPatentTypeById(
            @Parameter(description = "ID типа патента") @PathVariable Long id) {
        return ResponseEntity.ok(patentTypeService.getPatentTypeById(id));
    }

    @GetMapping("/code/{typeCode}")
    @Operation(summary = "Получить тип патента по коду")
    public ResponseEntity<PatentTypeDTO> getPatentTypeByCode(
            @Parameter(description = "Код типа патента") @PathVariable String typeCode) {
        return ResponseEntity.ok(patentTypeService.getPatentTypeByTypeCode(typeCode));
    }

    @GetMapping("/name/{typeName}")
    @Operation(summary = "Получить тип патента по названию")
    public ResponseEntity<PatentTypeDTO> getPatentTypeByName(
            @Parameter(description = "Название типа патента") @PathVariable String typeName) {
        return ResponseEntity.ok(patentTypeService.getPatentTypeByTypeName(typeName));
    }

    @PostMapping
    @Operation(summary = "Создать новый тип патента")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PatentTypeDTO> createPatentType(
            @Parameter(description = "Данные типа патента") @RequestBody PatentTypeRequest request) {
        return new ResponseEntity<>(patentTypeService.createPatentType(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить тип патента")
    public ResponseEntity<PatentTypeDTO> updatePatentType(
            @Parameter(description = "ID типа патента") @PathVariable Long id,
            @Parameter(description = "Обновленные данные типа патента") @RequestBody PatentTypeRequest request) {
        return ResponseEntity.ok(patentTypeService.updatePatentType(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить тип патента")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletePatentType(
            @Parameter(description = "ID типа патента") @PathVariable Long id) {
        patentTypeService.deletePatentType(id);
        return ResponseEntity.noContent().build();
    }
} 