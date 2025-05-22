package gamz.projects.pharmacyfair.controller;

import gamz.projects.pharmacyfair.model.dto.SettingDTO;
import gamz.projects.pharmacyfair.model.dto.SettingsDTO;
import gamz.projects.pharmacyfair.service.SettingsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/settings")
public class SettingsController {
    private final SettingsService service;


    @GetMapping("/get-all")
    @Operation(summary = "Получить все настройки")
    public ResponseEntity<SettingsDTO> getAllSettings() {
        return ResponseEntity.ok(service.getAllSettings());
    }

    @GetMapping("/get/{key}")
    @Operation(summary = "Получить настройку по ключу")
    public ResponseEntity<SettingDTO> getSetting(@Parameter(description = "Ключ настройки") @PathVariable String key) {
        SettingDTO value = service.getSetting(key);
        if (value == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(value);
    }
}
