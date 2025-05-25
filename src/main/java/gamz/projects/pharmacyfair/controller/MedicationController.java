package gamz.projects.pharmacyfair.controller;

import gamz.projects.pharmacyfair.model.dto.MedicationDTO;
import gamz.projects.pharmacyfair.model.dto.ReferenceDTO;
import gamz.projects.pharmacyfair.model.entity.projects.Medication;
import gamz.projects.pharmacyfair.model.mapper.ProjectMapper;
import gamz.projects.pharmacyfair.service.ReferenceService;
import gamz.projects.pharmacyfair.service.impl.MedicationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects/medications")
@RequiredArgsConstructor
@Tag(name = "Medication controller", description = "API для управления лекарственными препаратами")
public class MedicationController {

    private final MedicationServiceImpl medicationService;
    private final ProjectMapper mapper;
    private final ReferenceService referenceService;

    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "Получить все лекарственные изделия")
    @GetMapping("/get-all")
    public ResponseEntity<List<MedicationDTO>> getAll() {
        List<Medication> meds = medicationService.findAll();
        List<MedicationDTO> dtos = meds.stream()
                .map(mapper::fromMedicationToDto)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "Получить лекарственное изделие по ID")
    @GetMapping("/get/{id}")
    public ResponseEntity<MedicationDTO> getById(@PathVariable Long id) {
        Medication med = medicationService.findById(id);
        return ResponseEntity.ok(mapper.fromMedicationToDto(med));
    }

    @Operation(summary = "Создать или обновить (автосохранение)",
            security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping("save/{id}")
    public ResponseEntity<MedicationDTO> save(@RequestBody @Valid MedicationDTO medicationDTO,
                                              @PathVariable Long id) {
        if (!medicationDTO.getId().equals(id)) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        Medication saved = medicationService.saveDto(medicationDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapper.fromMedicationToDto(saved));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Удалить лекарственное изделие по ID",
            security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        medicationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Получить все записи справочника по имени для лекарственных изделий")
    @GetMapping("/get/reference/{name}")
    public ResponseEntity<List<ReferenceDTO>> getAllReferenceByName(@PathVariable String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(referenceService.getReference(name, "medication", null));
    }

    @Operation(summary = "Получить все записи справочника по имени для лекарственных изделий")
    @GetMapping("/get/reference/{name}/{id}")
    public ResponseEntity<List<ReferenceDTO>> getOneReferenceByNameAndId(@PathVariable String name,
                                                                         @PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(referenceService.getReference(name, "medication", id));
    }
}
