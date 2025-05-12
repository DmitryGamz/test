package gamz.projects.pharmacyfair.model.mapper;

import gamz.projects.pharmacyfair.model.dto.DeviceDTO;
import gamz.projects.pharmacyfair.model.entity.User;
import gamz.projects.pharmacyfair.model.entity.projects.Device;
import gamz.projects.pharmacyfair.model.entity.projects.storage.*;
import gamz.projects.pharmacyfair.service.ProjectService;
import gamz.projects.pharmacyfair.service.UserService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING ,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class DeviceMapper {

    @Autowired
    private UserService userService;

    @Autowired
    @Lazy
    private ProjectService projectService;

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
    @Mapping(source = "studentsInvolved.id", target = "hasStudentsInvolvedId")
    @Mapping(source = "riskClass.id", target = "riskClassId")
    @Mapping(source = "techReadiness.id", target = "techReadinessId")
    @Mapping(source = "assendDemand.id", target = "assessmentDemandId")
    @Mapping(source = "includedInStandards", target = "includedInStandards")
    @Mapping(source = "priorityTypes", target = "priorityTypeIds", qualifiedByName = "mapPriorityTypeIds")
    @Mapping(source = "nkmis", target = "nkmiIds", qualifiedByName = "mapNkmiIds")
    public abstract DeviceDTO fromDeviceToDto(Device device);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "userId", target = "user", qualifiedByName = "mapUser")
    @Mapping(source = "productTypeId", target = "productType", qualifiedByName = "mapProductType")
    @Mapping(source = "scopeId", target = "scope", qualifiedByName = "mapScope")
    @Mapping(source = "projectStatusId", target = "status", qualifiedByName = "mapProjectStatus")
    @Mapping(source = "iprStatusId", target = "iprStatus", qualifiedByName = "mapIprStatus")
    @Mapping(source = "commercialStatusId", target = "commercialStatus", qualifiedByName = "mapCommercialStatus")
    @Mapping(source = "marketPerspectivesId", target = "marketPerspectives", qualifiedByName = "mapMarketPerspective")
    @Mapping(source = "hasStudentsInvolvedId", target = "studentsInvolved", qualifiedByName = "mapStudentsInvolved")
    @Mapping(source = "riskClassId", target = "riskClass", qualifiedByName = "mapRiskClass")
    @Mapping(source = "techReadinessId", target = "techReadiness", qualifiedByName = "mapTechReadiness")
    @Mapping(source = "assessmentDemandId", target = "assendDemand", qualifiedByName = "mapAssendDemand")
    @Mapping(source = "priorityTypeIds", target = "priorityTypes", qualifiedByName = "mapPriorityTypeList")
    @Mapping(source = "nkmiIds", target = "nkmis", qualifiedByName = "mapNkmiList")
    public abstract Device fromDtoToDevice(DeviceDTO dto);

    @Named("mapUser")
    protected User mapUser(Long id) {
        return id == null ? null : userService.findById(id);
    }
    @Named("mapProductType")
    protected ProductType mapProductType(Long id) {
        return id == null ? null : projectService.getProductTypeById(id);
    }
    @Named("mapScope")
    protected Scope mapScope(Long id) {
        return id == null ? null : projectService.getScopeById(id);
    }
    @Named("mapProjectStatus")
    protected ProjectStatus mapProjectStatus(Long id) {
        return id == null ? null : projectService.getProjectStatusById(id);
    }
    @Named("mapIprStatus")
    protected IprStatus mapIprStatus(Long id) {
        return id == null ? null : projectService.getIprStatusById(id);
    }
    @Named("mapCommercialStatus")
    protected CommercialStatus mapCommercialStatus(Long id) {
        return id == null ? null : projectService.getCommercialStatusById(id);
    }
    @Named("mapMarketPerspective")
    protected MarketPerspective mapMarketPerspective(Long id) {
        return id == null ? null : projectService.getMarketPerspectiveById(id);
    }
    @Named("mapStudentsInvolved")
    protected StudentsInvolved mapStudentsInvolved(Long id) {
        return id == null ? null : projectService.getStudentsInvolvedById(id);
    }
    @Named("mapRiskClass")
    protected RiskClass mapRiskClass(Long id) {
        return id == null ? null : projectService.getRiskClassById(id);
    }
    @Named("mapTechReadiness")
    protected TechReadinessDevice mapTechReadiness(Long id) {
        return id == null ? null : projectService.getTechReadinessDeviceById(id);
    }
    @Named("mapAssendDemand")
    protected AssendDemand mapAssendDemand(Long id) {
        return id == null ? null : projectService.getAssendDemandById(id);
    }

    @Named("mapPriorityTypeIds")
    protected List<Long> mapPriorityTypeIds(List<PriorityType> priorityTypes) {
        return priorityTypes == null ? null : priorityTypes.stream()
                .map(PriorityType::getId)
                .toList();
    }

    @Named("mapNkmiIds")
    protected List<Long> mapNkmiIds(List<Nkmi> nkmis) {
        return nkmis == null ? null : nkmis.stream()
                .map(Nkmi::getId)
                .toList();
    }

    @Named("mapPriorityTypeList")
    protected List<PriorityType> mapPriorityTypeList(List<Long> ids) {
        return ids == null ? null : ids.stream()
                .map(projectService::getPriorityTypeById)
                .toList();
    }

    @Named("mapNkmiList")
    protected List<Nkmi> mapNkmiList(List<Long> ids) {
        return ids == null ? null : ids.stream()
                .map(projectService::getNkmiById)
                .toList();
    }

}
