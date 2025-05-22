package gamz.projects.pharmacyfair.model.mapper;

import gamz.projects.pharmacyfair.model.dto.SettingDTO;
import gamz.projects.pharmacyfair.model.entity.Setting;
import gamz.projects.pharmacyfair.model.request.SettingRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SettingMapper {
    SettingDTO toDtoFromSetting(Setting setting);
    Setting ToSettingFromRequest(SettingRequest request);
    void updateFromRequest(SettingRequest request, @MappingTarget Setting setting);

}