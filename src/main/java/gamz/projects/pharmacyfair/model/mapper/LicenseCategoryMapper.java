package gamz.projects.pharmacyfair.model.mapper;

import org.mapstruct.*;

import gamz.projects.pharmacyfair.model.dto.LicenseCategoryDTO;
import gamz.projects.pharmacyfair.model.entity.LicenseCategory;
import gamz.projects.pharmacyfair.model.request.LicenseCategoryRequest;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LicenseCategoryMapper {

    @Mapping(target = "parentCategory.id", source = "parentCategoryId")
    LicenseCategory toLicenseCategoryFromRequest(LicenseCategoryRequest request);

    @Mapping(target = "parentCategoryId", source = "parentCategory.id")
    LicenseCategoryDTO toLicenseCategoryDTO(LicenseCategory licenseCategory);
}
