package gamz.projects.pharmacyfair.model.mapper;

import gamz.projects.pharmacyfair.model.dto.MedicationDTO;
import gamz.projects.pharmacyfair.model.entity.projects.Medication;
import gamz.projects.pharmacyfair.service.ProjectService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING ,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class MedicationMapper {

    @Autowired
    protected ProjectService projectService;

    @Mapping(source = "id", target = "id")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "productType.id", target = "productTypeId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "scope.id", target = "scopeId")
    @Mapping(source = "status.id", target = "projectStatusId")
    @Mapping(source = "iprStatus.id", target = "iprStatusId")
    @Mapping(source = "iprValuationExists", target = "iprValuationExists")
    @Mapping(source = "commercialStatus.id", target = "commercialStatusId")
    @Mapping(source = "commercialEffect", target = "commercialEffect")
    @Mapping(source = "marketPerspectives.id", target = "marketPerspectivesId")
    @Mapping(source = "novelty", target = "novelty")
    @Mapping(source = "keyDifferences", target = "keyDifferences")
    @Mapping(source = "exportPotential", target = "exportPotential")
    @Mapping(source = "studentsInvolved.id", target = "hasStudentsInvolved")
    @Mapping(source = "techReadiness.id", target = "techReadinessId")
    @Mapping(expression = "java(med.getForms().stream().map(f -> f.getId()).collect(Collectors.toList()))", target = "formIds")
    @Mapping(expression = "java(med.getPriorityTypes().stream().map(pt -> pt.getId()).collect(Collectors.toList()))", target = "priorityTypeIds")
    @Mapping(expression = "java(med.getApplicationAreaMedications().stream().map(a -> a.getId()).collect(Collectors.toList()))", target = "applicationAreaMedicationIds")
    public abstract MedicationDTO fromMedicationToDto(Medication medication);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "userId", target = "user", qualifiedByName = "mapUser")
    @Mapping(source = "productTypeId", target = "productType", qualifiedByName = "mapProductType")
    @Mapping(source = "scopeId", target = "scope", qualifiedByName = "mapScope")
    @Mapping(source = "projectStatusId", target = "status", qualifiedByName = "mapProjectStatus")
    @Mapping(source = "iprStatusId", target = "iprStatus", qualifiedByName = "mapIprStatus")
    @Mapping(source = "commercialStatusId", target = "commercialStatus", qualifiedByName = "mapCommercialStatus")
    @Mapping(source = "marketPerspectivesId", target = "marketPerspectives", qualifiedByName = "mapMarketPerspective")
    @Mapping(source = "hasStudentsInvolved", target = "studentsInvolved", qualifiedByName = "mapStudentsInvolved")
    @Mapping(source = "riskClassId", target = "riskClass", qualifiedByName = "mapRiskClass")
    @Mapping(source = "techReadinessId", target = "techReadiness", qualifiedByName = "mapTechReadiness")
    @Mapping(source = "assessmentDemandId", target = "assendDemand", qualifiedByName = "mapAssendDemand")
    @Mapping(target = "priorityTypes", expression = "java(deviceDto.getPriorityTypeIds().stream().map(ptRepo::getReferenceById).collect(Collectors.toList()))")
    @Mapping(target = "nkmis", expression = "java(deviceDto.getNkmiIds().stream().map(projectRepo::getReferenceById).collect(Collectors.toList()))")
    public abstract Medication fromDtoToMedication(MedicationDTO dto);
}
