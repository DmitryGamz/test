package gamz.projects.pharmacyfair.controller;

import gamz.projects.pharmacyfair.model.dto.PharmaceuticalLicenseDTO;
import gamz.projects.pharmacyfair.model.exception.PharmaceuticalLicenseNotFoundException;
import gamz.projects.pharmacyfair.model.request.PharmaceuticalLicenseRequest;
import gamz.projects.pharmacyfair.model.response.ErrorNotFoundResponse;
import gamz.projects.pharmacyfair.service.PharmaceuticalLicenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pharmaceutical-license")
@RequiredArgsConstructor
@Tag(name = "Pharmaceutical Licenses", description = "Апи для работы с лицензией на производство лекарственных средств")
public class PharmaceuticalLicenseController {

    private final PharmaceuticalLicenseService pharmaceuticalLicenseService;

    @GetMapping
    @Operation(summary = "Получить все лицензии на производство")
    public ResponseEntity<List<PharmaceuticalLicenseDTO>> getAllPharmaceuticalLicenses() {
        return ResponseEntity.ok(pharmaceuticalLicenseService.getAllLicenses());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить лицензию на производство по ID")
    public ResponseEntity<PharmaceuticalLicenseDTO> getById(
            @Parameter(description = "ID лицензии") @PathVariable Long id
    ) {
        return ResponseEntity.ok(pharmaceuticalLicenseService.getLicenseById(id));
    }

    @GetMapping("/type/{typeId}")
    @Operation(summary = "Получить лицензии на производство по ID типа")
    public ResponseEntity<List<PharmaceuticalLicenseDTO>> getByTypeId(
            @Parameter(description = "ID типа лицензии") @PathVariable Long typeId
    ) {
        return ResponseEntity.ok(pharmaceuticalLicenseService.getLicenseByTypeId(typeId));
    }

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "Получить лицензии на производство по ID категории")
    public ResponseEntity<List<PharmaceuticalLicenseDTO>> getByCategoryId(
            @Parameter(description = "ID типа лицензии") @PathVariable Long categoryId
    ) {
        return ResponseEntity.ok(pharmaceuticalLicenseService.getLicenseByCategoryId(categoryId));
    }

    @PostMapping()
    @Operation(summary = "Создать новую лицензию на производство")
    public ResponseEntity<PharmaceuticalLicenseDTO> createPharmaceuticalLicense(
            @Parameter(description = "Данные типа лицензий") @RequestBody PharmaceuticalLicenseRequest request
    ) {
        return new ResponseEntity<>(pharmaceuticalLicenseService.createLicense(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Редактировать лицензию на производство по ID")
    public ResponseEntity<PharmaceuticalLicenseDTO> updatePharmaceuticalLicense(
            @Parameter(description = "ID лицензии на производство") @PathVariable Long id,
            @Parameter(description = "Данные лицензии на производство") @RequestBody PharmaceuticalLicenseRequest request
    ) {
        return ResponseEntity.ok(pharmaceuticalLicenseService.editLicense(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "удалить лицензию на производство по ID")
    public ResponseEntity<Void> deletePharmaceuticalLicense(
            @Parameter(description = "ID лицензии на производство") @PathVariable Long id
    ) {
        pharmaceuticalLicenseService.deleteLicenseById(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(PharmaceuticalLicenseNotFoundException.class)
    public ResponseEntity<ErrorNotFoundResponse> handleLicenseTypeNotFoundException(PharmaceuticalLicenseNotFoundException ex) {
        ErrorNotFoundResponse response = ErrorNotFoundResponse.builder().message(ex.getMessage()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
