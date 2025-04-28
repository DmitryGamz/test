package gamz.projects.pharmacyfair.model.mapper;

import gamz.projects.pharmacyfair.model.dto.PatentDTO;
import gamz.projects.pharmacyfair.model.entity.Patent;
import gamz.projects.pharmacyfair.model.request.PatentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PatentMapper {
    
    @Mapping(target = "project.id", source = "projectId")
    @Mapping(target = "patentType.id", source = "patentTypeId")
    Patent toPatentFromRequest(PatentRequest request);
    
    @Mapping(target = "projectId", source = "project.id")
    @Mapping(target = "patentTypeId", source = "patentType.id")
    @Mapping(target = "patentTypeName", source = "patentType.typeName")
    PatentDTO toPatentDTO(Patent patent);
} 