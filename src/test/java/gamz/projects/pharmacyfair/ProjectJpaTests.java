package gamz.projects.pharmacyfair;

import gamz.projects.pharmacyfair.model.entity.Organization;
import gamz.projects.pharmacyfair.model.entity.User;
import gamz.projects.pharmacyfair.model.entity.projects.Project;
import gamz.projects.pharmacyfair.model.entity.projects.storage.*;
import gamz.projects.pharmacyfair.service.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("dev")
@ComponentScan
public class ProjectJpaTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProjectService projectService;

    private Project project;

    @Autowired
    private Environment env;

    @Test
    void checkActiveProfile() {
        System.out.println("Активные профили: " + Arrays.toString(env.getActiveProfiles()));
    }

    @BeforeEach
    void setUp() {
        // Создаем тестовые данные для связанных сущностей
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setPassword("password");
        entityManager.persist(user);

        Organization organization = new Organization();
        organization.setName("Test Organization");
        entityManager.persist(organization);

        ProductType productType = projectService.getProductTypeByCode("DEVICE");
        entityManager.persist(productType);

        ProjectStatus projectStatus = projectService.getProjectStatusByCode("SUBMITTED");
        entityManager.persist(projectStatus);

        IprStatus iprStatus = projectService.getIprStatusByCode("PATENT");
        entityManager.persist(iprStatus);

        CommercialStatus commercialStatus = projectService.getCommercialStatusByCode("PARTNER");
        entityManager.persist(commercialStatus);

        MarketPerspective marketPerspective = projectService.getMarketPerspectiveByCode("UP1");
        entityManager.persist(marketPerspective);

        Scope scope = projectService.getScopeByCode("SINGLE");
        entityManager.persist(scope);

        ProductionRequirement productionRequirement = projectService.getProductionRequirementByCode("NONE");
        entityManager.persist(productionRequirement);

        CompletionTime completionTime = projectService.getCompletionTimeByCode("LESS5");
        entityManager.persist(completionTime);

        StudentsInvolved studentsInvolved = projectService.getStudentsInvolvedByCode("MORE");
        entityManager.persist(studentsInvolved);

//        Device device = new Device();
//        device.setName("Test Device");
//        entityManager.persist(device);

        // Создаем объект Project для тестирования
        project = Project.builder()
                .user(user)
                .productType(productType)
                .organization(organization)
                .name("Test Project")
                .description("This is a test project")
                .scope(scope)
                .projectStatus(projectStatus)
                .iprStatus(iprStatus)
                .iprValuationExists(false)
                .commercialStatus(commercialStatus)
                .commercialEffect("Increased Revenue")
                .marketPerspectives(marketPerspective)
                .novelty("New Technology")
                .keyDifferences("Improved Efficiency")
                .exportPotential(true)
                .productionRequirements(productionRequirement)
                .completionTime(completionTime)
                .studentsInvolved(studentsInvolved)
                .device(null)
                .medication(null)
                .build();
    }

    @Test
    void shouldSaveProjectCorrectly() {
        // Сохраняем проект в базу данных
        Project savedProject = projectService.save(project);

        // Проверяем, что проект был сохранен корректно
        assertThat(savedProject.getId()).isGreaterThan(0); // ID должен быть назначен
        assertThat(savedProject.getName()).isEqualTo("Test Project");
        assertThat(savedProject.getDescription()).isEqualTo("This is a test project");
        assertThat(savedProject.getScope()).isEqualTo("Internal Use");
        assertThat(savedProject.isIprValuationExists()).isFalse();
        assertThat(savedProject.getExportPotential()).isTrue();

        // Проверяем связанные сущности
        assertThat(savedProject.getUser().getEmail()).isEqualTo("test@gmail.com");
        assertThat(savedProject.getOrganization().getName()).isEqualTo("Test Organization");
        assertThat(savedProject.getProductType().getName()).isEqualTo("Test Product Type");
        assertThat(savedProject.getProjectStatus().getName()).isEqualTo("In Progress");
        assertThat(savedProject.getCommercialStatus().getName()).isEqualTo("Not Started");
        assertThat(savedProject.getMarketPerspectives().getName()).isEqualTo("High Potential");

        // Проверяем OneToOne связи
        assertThat(savedProject.getDevice().getName()).isNull();
        assertThat(savedProject.getMedication().getName()).isNull();
    }

}
