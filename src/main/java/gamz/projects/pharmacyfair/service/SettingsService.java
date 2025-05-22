package gamz.projects.pharmacyfair.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gamz.projects.pharmacyfair.model.dto.SettingDTO;
import gamz.projects.pharmacyfair.model.dto.SettingsDTO;
import gamz.projects.pharmacyfair.model.entity.Setting;
import gamz.projects.pharmacyfair.model.mapper.SettingMapper;
import gamz.projects.pharmacyfair.model.request.SettingRequest;
import gamz.projects.pharmacyfair.repository.SettingsRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class SettingsService {
    private final SettingsRepository repository;
    private final SettingMapper settingMapper;

    //Никита, сделал эту переменную, для обновления кэша без блокировки
    private final AtomicReference<Map<String, Object>> settingsRef = new AtomicReference<>(Map.of());
    private final Map<String, Object> parsedSettings = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        refreshCache();
    }

    @CacheEvict(value = "settings", allEntries = true)
    public void refreshCache() {
        List<Setting> settings = repository.findAll();
        parsedSettings.clear();

        settings.forEach(setting -> {
            switch (setting.getType()) {
                case BOOLEAN -> parsedSettings.put(setting.getKey(), Boolean.parseBoolean(setting.getValue()));
                case NUMBER -> parsedSettings.put(setting.getKey(), parseNumber(setting.getValue()));
                case JSON -> parsedSettings.put(setting.getKey(), parseJson(setting.getValue()));
                default -> parsedSettings.put(setting.getKey(), setting.getValue());
            }
        });
        settingsRef.set(Map.copyOf(parsedSettings));
    }

    public SettingsDTO getAllSettings() {
        return new SettingsDTO(settingsRef.get());
    }

    public SettingDTO getSetting(String key) {
        return new SettingDTO(settingsRef.get().get(key));
    }

    private Long parseNumber(String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

    private Object parseJson(String value) {
        try {
            return new ObjectMapper().readValue(value, Map.class);
        } catch (JsonProcessingException e) {
            return Collections.emptyMap();
        }
    }

    @Scheduled(fixedRate = 300_000) // Обновление каждые 5 минут
    public void scheduledCacheRefresh() {
        refreshCache();
    }

    @Transactional
    public void deleteByKey(String key) {
        if (!repository.existsByKey(key)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Настройка не найдена");
        }
        repository.deleteByKey(key);
    }

    @Transactional
    public SettingDTO saveSetting(SettingRequest request) {
        Setting existing = repository.findByKey(request.getKey()).orElse(null);

        if (existing == null) {
            existing = settingMapper.ToSettingFromRequest(request);
        } else {
            settingMapper.updateFromRequest(request, existing);

        }
        Setting setting = repository.save(existing);
        return settingMapper.toDtoFromSetting(setting);
    }
}
