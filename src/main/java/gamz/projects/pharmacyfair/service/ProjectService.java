package gamz.projects.pharmacyfair.service;

import gamz.projects.pharmacyfair.model.entity.projects.Project;
import gamz.projects.pharmacyfair.model.entity.projects.storage.*;
import gamz.projects.pharmacyfair.model.exception.ProjectNotFoundException;
import gamz.projects.pharmacyfair.repository.ProjectRepository;
import gamz.projects.pharmacyfair.repository.projects.storage.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private ProjectRepository projectRepository;

    private ProductTypeRepository productTypeRepository;
    private ProjectStatusRepository projectStatusRepository;
    private IprStatusRepository iprStatusRepository;
    private CommercialStatusRepository commercialStatusRepository;
    private MarketPerspectiveRepository marketPerspectiveRepository;
    private ScopeRepository scopeRepository;
    private ProductionRequirementRepository productionRequirementRepository;
    private StudentsInvolvedRepository studentsInvolvedRepository;
    private CompletionTimeRepository completionTimeRepository;

    /*
        Block of enum-table elements
        TODO Вынести в различные сервисы.
     */

    public ProductType getProductTypeByCode(String code){
        return productTypeRepository.findByCode(code).orElse(null);
    }

    public ProjectStatus getProjectStatusByCode(String code){
        return projectStatusRepository.findByCode(code).orElse(null);
    }

    public IprStatus getIprStatusByCode(String code){
        return iprStatusRepository.findByCode(code).orElse(null);
    }

    public CommercialStatus getCommercialStatusByCode(String code){
        return commercialStatusRepository.findByCode(code).orElse(null);
    }

    public MarketPerspective getMarketPerspectiveByCode(String code){
        return marketPerspectiveRepository.findByCode(code).orElse(null);
    }

    public Scope getScopeByCode(String code){
        return scopeRepository.findByCode(code).orElse(null);
    }

    public ProductionRequirement getProductionRequirementByCode(String code){
        return productionRequirementRepository.findByCode(code).orElse(null);
    }

    public StudentsInvolved getStudentsInvolvedByCode(String code){
        return studentsInvolvedRepository.findByCode(code).orElse(null);
    }

    public CompletionTime getCompletionTimeByCode(String code){
        return completionTimeRepository.findByCode(code).orElse(null);
    }

    @Transactional
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Transactional(readOnly = true)
    public Project findById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException("Проект не найден"));
    }


}
