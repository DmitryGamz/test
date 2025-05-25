package gamz.projects.pharmacyfair.service;

import gamz.projects.pharmacyfair.model.dto.DeviceDTO;
import gamz.projects.pharmacyfair.model.dto.MedicationDTO;

import gamz.projects.pharmacyfair.model.entity.User;
import gamz.projects.pharmacyfair.model.entity.projects.Device;
import gamz.projects.pharmacyfair.model.entity.projects.Medication;
import gamz.projects.pharmacyfair.model.entity.projects.Project;
import gamz.projects.pharmacyfair.model.entity.projects.storage.*;
import gamz.projects.pharmacyfair.model.mapper.ProjectMapper;
import gamz.projects.pharmacyfair.repository.ProjectRepository;
import gamz.projects.pharmacyfair.repository.projects.storage.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectMapper mapper;

    private final UserService userService;

    private final ProjectRepository projectRepository;

    private final ProductTypeRepository productTypeRepository;
    private final ProjectStatusRepository projectStatusRepository;
    private final IprStatusRepository iprStatusRepository;
    private final CommercialStatusRepository commercialStatusRepository;
    private final MarketPerspectiveRepository marketPerspectiveRepository;
    private final ScopeRepository scopeRepository;
    private final ProductionRequirementRepository productionRequirementRepository;
    private final StudentsInvolvedRepository studentsInvolvedRepository;
    private final CompletionTimeRepository completionTimeRepository;
    private final RiskClassRepository riskClassRepository;
    private final TechReadinessDeviceRepository techReadinessDeviceRepository;
    private final AssendDemandRepository assendDemandRepository;
    private final TechReadinessMedicationRepository techReadinessMedicationRepository;
    private final ApplicationAreaMedicationRepository applicationAreaMedicationRepository;
    private final MedicationFormRepository medicationFormRepository;
    private final PriorityTypeRepository priorityTypeRepository;
    private final NkmiRepository nkmiRepository;

    /*
        Block of enum-table elements
        TODO Вынести в различные сервисы.
     */

    public ProductType getProductTypeByCode(String code) {
        return productTypeRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException(
                        "ProductType not found with code: " + code));
    }

    public ProductType getProductTypeById(Long id) {
        return productTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "ProductType not found with id: " + id));
    }

// ------------------------------------------------

    public ProjectStatus getProjectStatusByCode(String code) {
        return projectStatusRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException(
                        "ProjectStatus not found with code: " + code));
    }

    public ProjectStatus getProjectStatusById(Long id) {
        return projectStatusRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "ProjectStatus not found with id: " + id));
    }

// ------------------------------------------------

    public IprStatus getIprStatusByCode(String code) {
        return iprStatusRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException(
                        "IprStatus not found with code: " + code));
    }

    public IprStatus getIprStatusById(Long id) {
        return iprStatusRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "IprStatus not found with id: " + id));
    }

// ------------------------------------------------

    public CommercialStatus getCommercialStatusByCode(String code) {
        return commercialStatusRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException(
                        "CommercialStatus not found with code: " + code));
    }

    public CommercialStatus getCommercialStatusById(Long id) {
        return commercialStatusRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "CommercialStatus not found with id: " + id));
    }

// ------------------------------------------------

    public MarketPerspective getMarketPerspectiveByCode(String code) {
        return marketPerspectiveRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException(
                        "MarketPerspective not found with code: " + code));
    }

    public MarketPerspective getMarketPerspectiveById(Long id) {
        return marketPerspectiveRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "MarketPerspective not found with id: " + id));
    }

// ------------------------------------------------

    public Scope getScopeByCode(String code) {
        return scopeRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Scope not found with code: " + code));
    }

    public Scope getScopeById(Long id) {
        return scopeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Scope not found with id: " + id));
    }

// ------------------------------------------------

    public ProductionRequirement getProductionRequirementByCode(String code) {
        return productionRequirementRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException(
                        "ProductionRequirement not found with code: " + code));
    }

    public ProductionRequirement getProductionRequirementById(Long id) {
        return productionRequirementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "ProductionRequirement not found with id: " + id));
    }

// ------------------------------------------------

    public StudentsInvolved getStudentsInvolvedByCode(String code) {
        return studentsInvolvedRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException(
                        "StudentsInvolved not found with code: " + code));
    }

    public StudentsInvolved getStudentsInvolvedById(Long id) {
        return studentsInvolvedRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "StudentsInvolved not found with id: " + id));
    }

// ------------------------------------------------

    public CompletionTime getCompletionTimeByCode(String code) {
        return completionTimeRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException(
                        "CompletionTime not found with code: " + code));
    }

    public CompletionTime getCompletionTimeById(Long id) {
        return completionTimeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "CompletionTime not found with id: " + id));
    }

    // ------------------------------------------------

    public RiskClass getRiskClassById(Long id) {
        return riskClassRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "RiskClass not found with id: " + id));
    }

    public RiskClass getRiskClassByCode(String code) {
        return riskClassRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException(
                        "RiskClass not found with code: " + code));
    }

    // ------------------------------------------------

    public TechReadinessDevice getTechReadinessDeviceById(Long id) {
        return techReadinessDeviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "TechReadinessDevice not found with id: " + id));
    }

    // ------------------------------------------------

    public TechReadinessMedication getTechReadinessMedicationById(Long id) {
        return techReadinessMedicationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "TechReadinessMedication not found with id: " + id));
    }

    // ------------------------------------------------
    public AssendDemand getAssendDemandById(Long id) {
        return assendDemandRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "AssendDemand not found with id: " + id));
    }

    // ------------------------------------------------

    public ApplicationAreaMedication getApplicationAreaMedicationById (Long id) {
        return applicationAreaMedicationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "ApplicationAreaMedication not found with id: " + id));
    }

    public ApplicationAreaMedication getApplicationAreaMedicationByCode(String code) {
        return applicationAreaMedicationRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException(
                        "ApplicationAreaMedication not found with code: " + code));
    }

    // ------------------------------------------------

    public MedicationForm getMedicationFormById (Long id) {
        return medicationFormRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "MedicationForm not found with id: " + id));
    }

    public MedicationForm getMedicationFormByCode(String code) {
        return medicationFormRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException(
                        "MedicationForm not found with code: " + code));
    }

    // ------------------------------------------------

    public PriorityType getPriorityTypeById (Long id) {
        return priorityTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "PriorityType not found with id: " + id));
    }

    public PriorityType getPriorityTypeByCode(String code) {
        return priorityTypeRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException(
                        "PriorityType not found with code: " + code));
    }

    // ------------------------------------------------

    public Nkmi getNkmiById (Long id) {
        return nkmiRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Nkmi not found with id: " + id));
    }

    public Nkmi getNkmiByCode(String code) {
        return nkmiRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Nkmi not found with code: " + code));
    }

    @Transactional
    public Object createEmptyProject(String code) {
        User user = userService.getUserBySecurityContext();
        ProductType productType = productTypeRepository.findByCode(code.toUpperCase())
                .orElseThrow(() -> new IllegalArgumentException("Unsupported project type: " + code));

        // Создаём нужный подкласс проекта
        Project project = switch (code.toUpperCase()) {
            case "DEVICE" -> new Device();
            case "MEDICATION" -> new Medication();
            default -> throw new IllegalArgumentException("Unsupported project type: " + code);
        };

        // Заполняем общие поля
        project.setName("Новый проект");
        project.setUser(user);
        project.setProductType(productType);

        project = projectRepository.saveAndFlush(project);


        return switch (project) {
            case Device d -> convertToDeviceDTO(d);
            case Medication m -> convertToMedicationDTO(m);
            default ->
                    throw new IllegalStateException("Unsupported project type: " + project.getClass().getSimpleName());
        };
    }

    /*
    Блок преобразований
     */
    private MedicationDTO convertToMedicationDTO(Medication medication) {
        return mapper.fromMedicationToDto(medication);
    }

    private DeviceDTO convertToDeviceDTO(Device device) {
        return mapper.fromDeviceToDto(device);
    }


}
