package gamz.projects.pharmacyfair.model.validator;

import gamz.projects.pharmacyfair.model.annotation.UniqueSettingKey;
import gamz.projects.pharmacyfair.repository.SettingsRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueSettingKeyValidator implements ConstraintValidator<UniqueSettingKey, String> {

    @Autowired
    private SettingsRepository settingsRepository;

    @Override
    public boolean isValid(String key, ConstraintValidatorContext context) {
        if (key == null || key.trim().isEmpty()) {
            return true;
        }
        return !settingsRepository.existsByKey(key);
    }
}
