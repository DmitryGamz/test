package gamz.projects.pharmacyfair.model.request;

import gamz.projects.pharmacyfair.model.annotation.UniqueSettingKey;
import gamz.projects.pharmacyfair.util.Constants;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SettingRequest {
    @NotEmpty(message = "Ключ настройки не должен быть пустым")
    @UniqueSettingKey
    private String key;

    @NotEmpty(message = "Значение настройки не должно быть пустым")
    private String value;

    private String description;
    private Constants.SettingType type;
}
