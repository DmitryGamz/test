package gamz.projects.pharmacyfair.model.mapper;

import gamz.projects.pharmacyfair.model.dto.*;
import gamz.projects.pharmacyfair.model.entity.Organization;
import gamz.projects.pharmacyfair.model.entity.User;
import gamz.projects.pharmacyfair.model.entity.projects.Device;
import gamz.projects.pharmacyfair.model.entity.projects.Medication;
import gamz.projects.pharmacyfair.model.entity.projects.storage.*;
import gamz.projects.pharmacyfair.service.ReferenceService;
import gamz.projects.pharmacyfair.service.UserService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING ,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ProjectMapper {

    @Autowired
    private UserService userService;

    @Autowired
    ReferenceService referenceService;

    @Mapping(source = "id", target = "id")
    @Mapping(source = "user", target = "user", qualifiedByName = "toUserDtoFromUser")
    @Mapping(source = "productType", target = "productType", qualifiedByName = "toDtoFromEntity")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "scope", target = "scope", qualifiedByName = "toDtoFromEntity")
    @Mapping(source = "projectStatus", target = "projectStatus", qualifiedByName = "toDtoFromEntity")
    @Mapping(source = "iprStatus", target = "iprStatus", qualifiedByName = "toDtoFromEntity")
    @Mapping(source = "iprValuationExists", target = "iprValuationExists")
    @Mapping(source = "commercialStatus", target = "commercialStatus", qualifiedByName = "toDtoFromEntity")
    @Mapping(source = "commercialEffect", target = "commercialEffect")
    @Mapping(source = "marketPerspectives", target = "marketPerspectives", qualifiedByName = "toDtoFromEntity")
    @Mapping(source = "novelty", target = "novelty")
    @Mapping(source = "keyDifferences", target = "keyDifferences")
    @Mapping(source = "exportPotential", target = "exportPotential")
    @Mapping(source = "studentsInvolved", target = "studentsInvolved", qualifiedByName = "toDtoFromEntity")
    @Mapping(source = "riskClass", target = "riskClass", qualifiedByName = "toDtoFromEntity")
    @Mapping(source = "techReadiness", target = "techReadiness", qualifiedByName = "toDtoFromEntity")
    @Mapping(source = "assendDemand", target = "assessmentDemand", qualifiedByName = "toDtoFromEntity")
    @Mapping(source = "includedInStandards", target = "includedInStandards")
    @Mapping(source = "priorityTypes", target = "priorityTypes", qualifiedByName = "toDtoFromListEntities")
    @Mapping(source = "nkmis", target = "nkmis", qualifiedByName = "toDtoFromListEntities")
    @Mapping(source = "presentationFormats", target = "presentationFormats", qualifiedByName = "toDtoFromListEntities")
    public abstract DeviceDTO fromDeviceToDto(Device device);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "user", target = "user", qualifiedByName = "toUserDtoFromUser")
    @Mapping(source = "productType", target = "productType", qualifiedByName = "toDtoFromEntity")
    @Mapping(source = "scope", target = "scope", qualifiedByName = "toDtoFromEntity")
    @Mapping(source = "projectStatus", target = "projectStatus", qualifiedByName = "toDtoFromEntity")
    @Mapping(source = "iprStatus", target = "iprStatus", qualifiedByName = "toDtoFromEntity")
    @Mapping(source = "commercialStatus", target = "commercialStatus", qualifiedByName = "toDtoFromEntity")
    @Mapping(source = "marketPerspectives", target = "marketPerspectives", qualifiedByName = "toDtoFromEntity")
    @Mapping(source = "studentsInvolved", target = "studentsInvolved", qualifiedByName = "toDtoFromEntity")
    @Mapping(source = "techReadiness", target = "techReadiness", qualifiedByName = "toDtoFromEntity")
    @Mapping(source = "forms", target = "forms", qualifiedByName = "toDtoFromListEntities")
    @Mapping(source = "priorityTypes", target = "priorityTypes", qualifiedByName = "toDtoFromListEntities")
    @Mapping(source = "applicationAreaMedications", target = "applicationAreaMedications", qualifiedByName = "toDtoFromListEntities")
    @Mapping(source = "presentationFormats", target = "presentationFormats", qualifiedByName = "toDtoFromListEntities")
    public abstract MedicationDTO fromMedicationToDto(Medication medication);

    @Named("toUserDtoFromUser")
    protected UserProjectDTO toUserDtoFromUser(User user) {
        if (user == null) {
            return null;
        }
        Organization organization = user.getOrganization();
        return UserProjectDTO.builder()
                .organization(OrganisationDTO.builder()
                        .name(organization.getName())
                        .logoPath(organization.getLogoPath())
                        .build()
                )
                .firstName(user.getFirstName())
                .middleName(user.getMiddleName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .jobTitle(user.getJobTitle())
                .build();
    }

    @Named("toDtoFromEntity")
    protected ReferenceDTO toDtoFromEntity(Object object) {
        if (object == null) {
            return null;
        }
        return referenceService.fromEntityToDto(object);
    }

    @Named("toDtoFromListEntities")
    protected <T> List<ReferenceDTO> toDtoFromListEntities(List<T> objects) {
        if (objects == null) {
            return List.of();
        }
        return objects.stream().map(object -> referenceService.fromEntityToDto(object)).toList();
    }

    @Mapping(source = "id", target = "id")
    @Mapping(source = "user", target = "user", qualifiedByName = "toUserFromUserDto")
    @Mapping(source = "productType", target = "productType", qualifiedByName = "toProductTypeFromDto")
    @Mapping(source = "scope", target = "scope", qualifiedByName = "toScopeFromDto")
    @Mapping(source = "projectStatus", target = "projectStatus", qualifiedByName = "toProjectStatusFromDto")
    @Mapping(source = "iprStatus", target = "iprStatus", qualifiedByName = "toIprStatusFromDto")
    @Mapping(source = "commercialStatus", target = "commercialStatus", qualifiedByName = "toCommercialStatusFromDto")
    @Mapping(source = "marketPerspectives", target = "marketPerspectives", qualifiedByName = "toMarketPerspectivesFromDto")
    @Mapping(source = "studentsInvolved", target = "studentsInvolved", qualifiedByName = "toStudentsInvolvedFromDto")
    @Mapping(source = "techReadiness", target = "techReadiness", qualifiedByName = "toTechReadinessDeviceFromDto")
    @Mapping(source = "riskClass", target = "riskClass", qualifiedByName = "toRiskClassFromDto")
    @Mapping(source = "assessmentDemand", target = "assendDemand", qualifiedByName = "toAssessmentDemandFromDto")
    @Mapping(source = "priorityTypes", target = "priorityTypes", qualifiedByName = "toPriorityTypeListFromDto")
    @Mapping(source = "nkmis", target = "nkmis", qualifiedByName = "toNkmisListFromDto")
    @Mapping(source = "presentationFormats", target = "presentationFormats", qualifiedByName = "toPresentationFormatsListFromDto")
    public abstract Device fromDtoToDevice(DeviceDTO dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "user", target = "user", qualifiedByName = "toUserFromUserDto")
    @Mapping(source = "productType", target = "productType", qualifiedByName = "toProductTypeFromDto")
    @Mapping(source = "scope", target = "scope", qualifiedByName = "toScopeFromDto")
    @Mapping(source = "projectStatus", target = "projectStatus", qualifiedByName = "toProjectStatusFromDto")
    @Mapping(source = "iprStatus", target = "iprStatus", qualifiedByName = "toIprStatusFromDto")
    @Mapping(source = "commercialStatus", target = "commercialStatus", qualifiedByName = "toCommercialStatusFromDto")
    @Mapping(source = "marketPerspectives", target = "marketPerspectives", qualifiedByName = "toMarketPerspectivesFromDto")
    @Mapping(source = "studentsInvolved", target = "studentsInvolved", qualifiedByName = "toStudentsInvolvedFromDto")
    @Mapping(source = "techReadiness", target = "techReadiness", qualifiedByName = "toTechReadinessMedicationFromDto")
    @Mapping(source = "forms", target = "forms", qualifiedByName = "toFormsListFromDto")
    @Mapping(source = "priorityTypes", target = "priorityTypes", qualifiedByName = "toPriorityTypeListFromDto")
    @Mapping(source = "applicationAreaMedications", target = "applicationAreaMedications", qualifiedByName = "toApplicationAreaMedicationListFromDto")
    @Mapping(source = "presentationFormats", target = "presentationFormats", qualifiedByName = "toPresentationFormatsListFromDto")
    public abstract Medication fromDtoToMedication(MedicationDTO dto);

    @Named("toUserFromUserDto")
    protected User toUserFromUserDto(UserProjectDTO dto) {
        if (dto == null) {
            return null;
        }
        return userService.findByEmail(dto.getEmail());
    }

    // MupStruct не поддерживает дженерики, СЕЙЧАС БУДЕТ КОСТЫЛЬ
    //@Named("toEntityFromDto")
    @SuppressWarnings("unchecked")
    protected <T> T toEntityFromDto(ReferenceDTO dto, Class<T> targetClass) {
        if (dto == null) {
            return null;
        }
        Object entity = referenceService.fromDtoToEntity(dto);
        return targetClass.cast(entity);
    }

    //@Named("toListEntitiesFromDto")
    @SuppressWarnings("unchecked")
    protected <T> List<T> toListEntitiesFromDto(List<ReferenceDTO> dtos, Class<T> targetClass) {
        if (dtos == null) {
            return List.of();
        }
        return dtos.stream().map(dto -> targetClass.cast(referenceService.fromDtoToEntity(dto))).toList();
    }

    //КОНКРЕТНЫЕ методы
    @Named("toProductTypeFromDto")
    protected ProductType toProductTypeFromDto(ReferenceDTO dto) {
        return toEntityFromDto(dto, ProductType.class);
    }

    @Named("toScopeFromDto")
    protected Scope toScopeFromDto(ReferenceDTO dto) {
        return toEntityFromDto(dto, Scope.class);
    }

    @Named("toProjectStatusFromDto")
    protected ProjectStatus toProjectStatusFromDto(ReferenceDTO dto) {
        return toEntityFromDto(dto, ProjectStatus.class);
    }

    @Named("toIprStatusFromDto")
    protected IprStatus toIprStatusFromDto(ReferenceDTO dto) {
        return toEntityFromDto(dto, IprStatus.class);
    }

    @Named("toCommercialStatusFromDto")
    protected CommercialStatus toCommercialStatusFromDto(ReferenceDTO dto) {
        return toEntityFromDto(dto, CommercialStatus.class);
    }

    @Named("toRiskClassFromDto")
    protected RiskClass toRiskClassFromDto(ReferenceDTO dto) {
        return toEntityFromDto(dto, RiskClass.class);
    }

    @Named("toMarketPerspectivesFromDto")
    protected MarketPerspective toMarketPerspectivesFromDto(ReferenceDTO dto) {
        return toEntityFromDto(dto, MarketPerspective.class);
    }

    @Named("toStudentsInvolvedFromDto")
    protected StudentsInvolved toStudentsInvolvedFromDto(ReferenceDTO dto) {
        return toEntityFromDto(dto, StudentsInvolved.class);
    }



    @Named("toScopeListFromDto")
    protected List<Scope> toScopeListFromDto(List<ReferenceDTO> dtos) {
        return toListEntitiesFromDto(dtos, Scope.class);
    }

    @Named("toProductTypeListFromDto")
    protected List<ProductType> toProductTypeListFromDto(List<ReferenceDTO> dtos) {
        return toListEntitiesFromDto(dtos, ProductType.class);
    }

    @Named("toPresentationFormatsListFromDto")
    protected List<PresentationFormat> toPresentationFormatsListFromDto(List<ReferenceDTO> dtos) {
        return toListEntitiesFromDto(dtos, PresentationFormat.class);
    }

    // Частные для лекарственных препаратов

    @Named("toTechReadinessMedicationFromDto")
    protected TechReadinessMedication toTechReadinessMedicationFromDto(ReferenceDTO dto) {
        return toEntityFromDto(dto, TechReadinessMedication.class);
    }

    @Named("toFormsListFromDto")
    protected List<MedicationForm> toFormsListFromDto(List<ReferenceDTO> dtos) {
        return toListEntitiesFromDto(dtos, MedicationForm.class);
    }

    @Named("toPriorityTypeListFromDto")
    protected List<PriorityType> toPriorityTypeListFromDto(List<ReferenceDTO> dtos) {
        return toListEntitiesFromDto(dtos, PriorityType.class);
    }

    @Named("toApplicationAreaMedicationListFromDto")
    protected List<ApplicationAreaMedication> toApplicationAreaMedicationListFromDto(List<ReferenceDTO> dtos) {
        return toListEntitiesFromDto(dtos, ApplicationAreaMedication.class);
    }

    //Частные для лекарственных изделий

    @Named("toTechReadinessDeviceFromDto")
    protected TechReadinessDevice toTechReadinessDeviceFromDto(ReferenceDTO dto) {
        return toEntityFromDto(dto, TechReadinessDevice.class);
    }


    @Named("toAssessmentDemandFromDto")
    protected AssendDemand toAssessmentDemandFromDto(ReferenceDTO dto) {
        return toEntityFromDto(dto, AssendDemand.class);
    }

    @Named("toNkmisListFromDto")
    protected List<Nkmi> toNkmisListFromDto(List<ReferenceDTO> dtos) {
        return toListEntitiesFromDto(dtos, Nkmi.class);
    }
}
