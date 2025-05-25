package gamz.projects.pharmacyfair.service;

import gamz.projects.pharmacyfair.model.dto.ReferenceDTO;
import gamz.projects.pharmacyfair.service.components.EntityFetcher;
import gamz.projects.pharmacyfair.util.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        if (wrapper.isReadableProperty("id")) {
            builder.id((Long) wrapper.getPropertyValue("id"));
        }

        if (wrapper.isReadableProperty("code")) {
            builder.code((String) wrapper.getPropertyValue("code"));
        }

        if (wrapper.isReadableProperty("description")) {
            builder.description((String) wrapper.getPropertyValue("description"));
        }

        if (wrapper.isReadableProperty("level")) {
            builder.level((String) wrapper.getPropertyValue("level"));
        }

        if (wrapper.isReadableProperty("name")) {
            builder.name((String) wrapper.getPropertyValue("name"));
        }

        if (wrapper.isReadableProperty("parentId")) {
            builder.parentId((Long) wrapper.getPropertyValue("parentId"));
        }

        return builder.build();
    }

    public Object fromDtoToEntity(ReferenceDTO dto) {
        if (dto == null || dto.getType() == null) {
            return null;
        }

        Class<?> clazz = getClassFromType(dto.getType());

        try {
            Object entity = clazz.getDeclaredConstructor().newInstance();
            BeanWrapper wrapper = new BeanWrapperImpl(entity);

            if (dto.getId() != null && wrapper.isWritableProperty("id")) {
                wrapper.setPropertyValue("id", dto.getId());
            }

            if (dto.getCode() != null && wrapper.isWritableProperty("code")) {
                wrapper.setPropertyValue("code", dto.getCode());
            }

            if (dto.getDescription() != null && wrapper.isWritableProperty("description")) {
                wrapper.setPropertyValue("description", dto.getDescription());
            }

            if (dto.getLevel() != null && wrapper.isWritableProperty("level")) {
                wrapper.setPropertyValue("level", dto.getLevel());
            }

            if (dto.getName() != null && wrapper.isWritableProperty("name")) {
                wrapper.setPropertyValue("name", dto.getName());
            }

            if (dto.getParentId() != 0 && wrapper.isWritableProperty("parentId")) {
                wrapper.setPropertyValue("parentId", dto.getParentId());
            }

            return entity;

        } catch (Exception e) {
            throw new RuntimeException("Failed to create entity for type: " + dto.getType(), e);
        }
    }

    private Class<?> getClassFromType(String type) {
        Map<String, Class<?>> referenceMap = Stream.of(
                        Constants.referenceNamesMedicationMap,
                        Constants.referenceNamesDeviceMap
                ).flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(
                        entry -> entry.getKey().toLowerCase(),
                        Map.Entry::getValue,
                        (first, second) -> first
                ));

        Class<?> clazz = referenceMap.get(type.toLowerCase());
        if (clazz == null) {
            throw new IllegalArgumentException("Unknown reference type: " + type);
        }
        return clazz;
    }
}
