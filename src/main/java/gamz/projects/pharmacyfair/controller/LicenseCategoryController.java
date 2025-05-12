package gamz.projects.pharmacyfair.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gamz.projects.pharmacyfair.model.dto.LicenseCategoryDTO;
import gamz.projects.pharmacyfair.model.exception.LicenseCategoryNotFoundException;
import gamz.projects.pharmacyfair.model.request.LicenseCategoryRequest;
import gamz.projects.pharmacyfair.model.response.ErrorNotFoundResponse;
import gamz.projects.pharmacyfair.service.LicenseCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/license-categories")
@RequiredArgsConstructor
@Tag(name = "License Categories", description = "Апи для работы с категориями лицензий")
public class LicenseCategoryController {

    private final LicenseCategoryService licenseCategoryService;
    
    @GetMapping
    @Operation(summary = "Получить все категории лицензий")
    public ResponseEntity<List<LicenseCategoryDTO>> getAllCategories() {
        return ResponseEntity.ok(licenseCategoryService.getAllLicenseCategories());
    }

    @GetMapping("/root")
    @Operation(summary = "Получить корневые категории")
    public ResponseEntity<List<LicenseCategoryDTO>> getRelatedCategoriesByParentId() {
        return ResponseEntity.ok(licenseCategoryService.getLicenseCategoriesByParentCategoryIsNull());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить категорию лицензий по ID")
    public ResponseEntity<LicenseCategoryDTO> getCategoryById(
            @Parameter(description = "ID категории") @PathVariable Long id
    ) {
        return ResponseEntity.ok(licenseCategoryService.getLicenseCategoryById(id));
    }

    @GetMapping("/{id}/related")
    @Operation(summary = "Получить связанные подкатегории лицензий по ID")
    public ResponseEntity<List<LicenseCategoryDTO>> getRelatedCategoriesByParentId(
            @Parameter(description = "ID родительской категории") @PathVariable Long id
    ) {
        return ResponseEntity.ok(licenseCategoryService.getLicenseCategoriesByParentCategoryId(id));
    }

    @PostMapping
    @Operation(summary = "Создать категорию лицензий")
    public ResponseEntity<LicenseCategoryDTO> createCategory(
        @Parameter(description = "Данные категорию лицензий") @RequestBody LicenseCategoryRequest request
    ) {
        return new ResponseEntity<>(licenseCategoryService.createLicenseCategory(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Редактировать категорию лицензий")
    ResponseEntity<LicenseCategoryDTO> editCategory(
        @Parameter(description = "ID категории") @PathVariable Long id,
        @Parameter(description = "Данные категорию лицензий") @RequestBody LicenseCategoryRequest request
    ) {
        return ResponseEntity.ok(licenseCategoryService.editLicenseCategory(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить категорию лицензий и все связанные подкатегории")
    ResponseEntity<Void> deleteCategory(
        @Parameter(description = "ID категории") @PathVariable Long id
    ) {
        licenseCategoryService.deleteLicenseCategory(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(LicenseCategoryNotFoundException.class)
    public ResponseEntity<ErrorNotFoundResponse> handleNotFoundExceptions(LicenseCategoryNotFoundException ex) {
        ErrorNotFoundResponse response = ErrorNotFoundResponse.builder().message(ex.getMessage()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
