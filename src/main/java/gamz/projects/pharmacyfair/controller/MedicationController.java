package gamz.projects.pharmacyfair.controller;

import gamz.projects.pharmacyfair.model.dto.MedicationDTO;
import gamz.projects.pharmacyfair.model.dto.ReferenceDTO;
import gamz.projects.pharmacyfair.model.entity.projects.Medication;
import gamz.projects.pharmacyfair.model.mapper.MedicationMapper;
import gamz.projects.pharmacyfair.service.ReferenceService;
import gamz.projects.pharmacyfair.service.impl.MedicationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects/medications")
@RequiredArgsConstructor
public class MedicationController {

    private final MedicationServiceImpl medicationService;
    private final MedicationMapper medicationMapper;
    private final ReferenceService referenceService;

    @Operation(summary = "Получить все лекарственные изделия")
    @GetMapping("/get-all")
    public ResponseEntity<List<MedicationDTO>> getAll() {
        List<Medication> meds = medicationService.findAll();
        List<MedicationDTO> dtos = meds.stream()
                .map(medicationMapper::fromMedicationToDto)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @Operation(summary = "Получить лекарственное изделие по ID")
    @GetMapping("/get/{id}")
    public ResponseEntity<MedicationDTO> getById(@PathVariable Long id) {
        Medication med = medicationService.findById(id);
        return ResponseEntity.ok(medicationMapper.fromMedicationToDto(med));
    }

    @Operation(summary = "Создать или обновить (автосохранение)")
    @PostMapping("save/{id}")
    public ResponseEntity<MedicationDTO> save(@RequestBody @Valid MedicationDTO medicationDTO,
                                              @PathVariable Long id) {
        if (!medicationDTO.getId().equals(id)) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        Medication saved = medicationService.saveDto(medicationDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(medicationMapper.fromMedicationToDto(saved));
    }

    @Operation(summary = "Удалить лекарственное изделие по ID")
    @DeleteMapping("/{id}")
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
