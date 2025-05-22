package gamz.projects.pharmacyfair.controller;

import gamz.projects.pharmacyfair.model.dto.SettingDTO;
import gamz.projects.pharmacyfair.model.dto.SettingsDTO;
import gamz.projects.pharmacyfair.model.request.SettingRequest;
import gamz.projects.pharmacyfair.service.SettingsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/settings")
@Tag(name = "Settings", description = "API для работы с настройками")
public class SettingsController {
    private final SettingsService settingsService;


    @GetMapping("/get-all")
    @Operation(summary = "Получить все настройки")
    public ResponseEntity<SettingsDTO> getAllSettings() {
        return ResponseEntity.ok(settingsService.getAllSettings());
    }

    @GetMapping("/get/{key}")
    @Operation(summary = "Получить настройку по ключу")
    public ResponseEntity<SettingDTO> getSetting(@Parameter(description = "Ключ настройки") @PathVariable String key) {
        SettingDTO value = settingsService.getSetting(key);
        return ResponseEntity.ok(value);
    }

    @PostMapping("save")
    @Operation(summary = "Обновляет/сохраняет настройку",
            security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<SettingDTO> saveSetting(@Valid @RequestBody SettingRequest settingRequest) {
        return ResponseEntity.ok(settingsService.saveSetting(settingRequest));
    }

    @DeleteMapping("delete/{key}")
    @Operation(summary = "Удаляет настройку по ключу",
            security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Void> deleteSetting(@Parameter (description = "Ключ настройки") @PathVariable String key) {
        settingsService.deleteByKey(key);
        return ResponseEntity.noContent().build();
    }
}
