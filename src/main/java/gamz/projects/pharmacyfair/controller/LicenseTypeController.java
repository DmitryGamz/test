package gamz.projects.pharmacyfair.controller;

import gamz.projects.pharmacyfair.model.dto.LicenseTypeDTO;
import gamz.projects.pharmacyfair.model.request.LicenseTypeRequest;
import gamz.projects.pharmacyfair.service.LicenseTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/license-type")
@RequiredArgsConstructor
@Tag(name = "License Types", description = "Api для работы с типами лицензий")
public class LicenseTypeController {
    private final LicenseTypeService licenseTypeService;

    @GetMapping
    @Operation(summary = "Получить все типы лицензий")
    public ResponseEntity<List<LicenseTypeDTO>> getAllLicenseTypes() {
        return ResponseEntity.ok(licenseTypeService.getAllLicenseTypes());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить тип лицензий по ID")
    public ResponseEntity<LicenseTypeDTO> getLicenseTypeById(
            @Parameter(description = "ID лицензии") @PathVariable Long id
    ) {
        return ResponseEntity.ok(licenseTypeService.getLicenseById(id));
    }

    @PostMapping
    @Operation(summary = "Создать новый тип лицензий")
    public ResponseEntity<LicenseTypeDTO> createLicenseType(
            @Parameter(description = "Данные типа лицензий") @RequestBody LicenseTypeRequest request
    ) {
        return new ResponseEntity<>(licenseTypeService.createLicense(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Редактировать тип лицензий по ID")
    public ResponseEntity<LicenseTypeDTO> editLicenseType(
            @Parameter(description = "ID лицензии") @PathVariable Long id,
            @Parameter(description = "Данные типа лицензий") @RequestBody LicenseTypeRequest request
    ) {
        return ResponseEntity.ok(licenseTypeService.editLicenseById(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "удалить тип лицензий по ID")
    public ResponseEntity<Void> deleteLicenseType(
            @Parameter(description = "ID лицензии") @PathVariable Long id
    ) {
        licenseTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
