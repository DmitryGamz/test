package gamz.projects.pharmacyfair.service;

import gamz.projects.pharmacyfair.model.dto.ReferenceDTO;
import gamz.projects.pharmacyfair.util.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReferenceService {

    private final EntityFetcher entityFetcher;

    public List<ReferenceDTO> getReference(String reference, String type, Long id) {
        Map<String, Class<?>> referenceMap = switch (type.toLowerCase()) {
            case "medication" -> Constants.referenceNamesMedicationMap;
            case "device" -> Constants.referenceNamesDeviceMap;
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };

        for (Map.Entry<String, Class<?>> entry : referenceMap.entrySet()) {
            String referenceName = entry.getKey().toLowerCase();
            Class<?> referenceClass = entry.getValue();

            if (referenceName.equals(reference)) {
                if (id != null) {
                    return List.of(fromEntityToDto(
                            entityFetcher.fetchOneById(referenceClass, id)
                    ));
                }
                return entityFetcher.fetchAll(referenceClass)
                        .stream()
                        .map(this::fromEntityToDto)
                        .toList();
            }
        }
        return List.of();
    }

    public ReferenceDTO fromEntityToDto(Object entity) {
        if (entity == null) {
            return null;
        }

        BeanWrapper wrapper = new BeanWrapperImpl(entity);
        ReferenceDTO.ReferenceDTOBuilder builder = ReferenceDTO.builder()
                .type(entity.getClass().getSimpleName());

        // Считаем, что id всегда есть
        if (wrapper.isReadableProperty("id")) {
            builder.id((Long) wrapper.getPropertyValue("id"));
        }
        // Читаем code, если есть
        if (wrapper.isReadableProperty("code")) {
            builder.code((String) wrapper.getPropertyValue("code"));
        }
        // Читаем description, если есть
        if (wrapper.isReadableProperty("description")) {
            builder.description((String) wrapper.getPropertyValue("description"));
        }
        // Читаем level, если есть
        if (wrapper.isReadableProperty("level")) {
            builder.level((String) wrapper.getPropertyValue("level"));
        }
        // Читаем name, если есть
        if (wrapper.isReadableProperty("name")) {
            builder.name((String) wrapper.getPropertyValue("name"));
        }
        // Читаем parentId, если есть
        if (wrapper.isReadableProperty("parentId")) {
            builder.parentId((Long) wrapper.getPropertyValue("parentId"));
        }

        return builder.build();
    }
}
