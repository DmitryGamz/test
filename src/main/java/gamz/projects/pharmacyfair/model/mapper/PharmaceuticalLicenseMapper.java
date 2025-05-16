package gamz.projects.pharmacyfair.model.mapper;

import gamz.projects.pharmacyfair.model.dto.PharmaceuticalLicenseDTO;
import gamz.projects.pharmacyfair.model.entity.PharmaceuticalLicense;
import gamz.projects.pharmacyfair.model.request.PharmaceuticalLicenseRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PharmaceuticalLicenseMapper {
    @Mapping(target = "partnerDetail", source = "partnerDetailId")
    @Mapping(target = "licenseType.id", source = "licenseTypeId")
    @Mapping(target = "licenseCategory.id", source = "licenseCategoryId")
    PharmaceuticalLicense toPharmaceuticalLicenseFromRequest(PharmaceuticalLicenseRequest pharmaceuticalLicenseRequest);

    @Mapping(target = "partnerDetailId", source = "partnerDetail")
    @Mapping(target = "licenseTypeId", source = "licenseType.id")
    @Mapping(target = "licenseCategoryId", source = "licenseCategory.id")
    PharmaceuticalLicenseDTO toPharmaceuticalLicenseDTO(PharmaceuticalLicense pharmaceuticalLicense);
}
