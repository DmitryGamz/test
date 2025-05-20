package gamz.projects.pharmacyfair.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gamz.projects.pharmacyfair.model.dto.SettingDTO;
import gamz.projects.pharmacyfair.model.dto.SettingsDTO;
import gamz.projects.pharmacyfair.model.entity.Setting;
import gamz.projects.pharmacyfair.repository.SettingsRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class SettingsService {
    private final SettingsRepository repository;

    //Никита, сделал эту переменную, для обновления кэша без блокировки
    private final AtomicReference<Map<Long, Object>> settingsRef = new AtomicReference<>(Map.of());
    private final Map<Long, Object> parsedSettings = new ConcurrentHashMap<>();

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
                case BOOLEAN -> parsedSettings.put(setting.getId(), Boolean.parseBoolean(setting.getValue()));
                case NUMBER -> parsedSettings.put(setting.getId(), parseNumber(setting.getValue()));
                case JSON -> parsedSettings.put(setting.getId(), parseJson(setting.getValue()));
                default -> parsedSettings.put(setting.getId(), setting.getValue());
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
}
