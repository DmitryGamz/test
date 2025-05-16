package gamz.projects.pharmacyfair.model.mapper;

import gamz.projects.pharmacyfair.model.dto.LicenseTypeDTO;
import gamz.projects.pharmacyfair.model.entity.LicenseType;
import gamz.projects.pharmacyfair.model.request.LicenseTypeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LicenseTypeMapper {
    LicenseTypeDTO ToLicenseTypeDTO(LicenseType licenseType);
    LicenseType FromLicenseTypeRequest(LicenseTypeRequest request);
}
