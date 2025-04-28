package gamz.projects.pharmacyfair.model.mapper;

import gamz.projects.pharmacyfair.model.dto.PatentTypeDTO;
import gamz.projects.pharmacyfair.model.entity.PatentType;
import gamz.projects.pharmacyfair.model.request.PatentTypeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PatentTypeMapper {
    
    PatentType toPatentTypeFromRequest(PatentTypeRequest request);
    
    PatentTypeDTO toPatentTypeDTO(PatentType patentType);
} 