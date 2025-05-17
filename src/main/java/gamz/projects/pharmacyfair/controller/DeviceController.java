package gamz.projects.pharmacyfair.controller;

import gamz.projects.pharmacyfair.model.dto.DeviceDTO;
import gamz.projects.pharmacyfair.model.dto.ReferenceDTO;
import gamz.projects.pharmacyfair.model.entity.projects.Device;
import gamz.projects.pharmacyfair.model.mapper.DeviceMapper;
import gamz.projects.pharmacyfair.service.ReferenceService;
import gamz.projects.pharmacyfair.service.impl.DeviceServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects/devices")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceServiceImpl deviceService;
    private final DeviceMapper deviceMapper;
    private final ReferenceService referenceService;

    @Operation(summary = "Получить все устройства")
    @GetMapping("/get-all")
    public ResponseEntity<List<DeviceDTO>> getAll() {
        List<Device> devices = deviceService.findAll();
        List<DeviceDTO> dtos = devices.stream()
                .map(deviceMapper::fromDeviceToDto)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @Operation(summary = "Получить устройство по ID")
    @GetMapping("/get/{id}")
    public ResponseEntity<DeviceDTO> getById(@Parameter(description = "ID медицинского изделия") @PathVariable Long id) {
        Device device = deviceService.findById(id);
        return ResponseEntity.ok(deviceMapper.fromDeviceToDto(device));
    }

    @Operation(summary = "Создать или обновить (автосохранение)")
    @PostMapping("/save/{id}")
    public ResponseEntity<DeviceDTO> save(@Parameter(description = "Данные по проекту на сохранение (обновление)") @RequestBody @Valid DeviceDTO deviceDTO,
                                          @PathVariable Long id) {
        if (deviceDTO.getId() != null && !deviceDTO.getId().equals(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Device saved = deviceService.saveDto(deviceDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(deviceMapper.fromDeviceToDto(saved));
    }

    @Operation(summary = "Удалить медицинское устройство по ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "ID медицинского изделия") @PathVariable Long id) {
        deviceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Получить все записи справочника по имени для медицинских устройств")
    @GetMapping("/get/reference/{name}")
    public ResponseEntity<List<ReferenceDTO>> getAllReferenceByName(@Parameter(description = "Название справочника (лист находится в константах)") @PathVariable String name) {
        List<ReferenceDTO> refs = referenceService.getReference(name, "device", null);
        return ResponseEntity.ok(refs);
    }

    @Operation(summary = "Получить одну запись справочника по имени и ID для медицинских устройств")
    @GetMapping("/get/reference/{name}/{id}")
    public ResponseEntity<List<ReferenceDTO>> getOneReferenceByNameAndId(@Parameter(description = "Название справочника (лист находится в константах)") @PathVariable String name,
                                                                         @Parameter(description = "ID справочного элемента") @PathVariable Long id) {
        List<ReferenceDTO> refs = referenceService.getReference(name, "device", id);
        return ResponseEntity.ok(refs);
    }
}