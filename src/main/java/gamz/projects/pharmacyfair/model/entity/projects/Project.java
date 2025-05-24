package gamz.projects.pharmacyfair.model.entity.projects;

import gamz.projects.pharmacyfair.model.entity.Organization;
import gamz.projects.pharmacyfair.model.entity.User;
import gamz.projects.pharmacyfair.model.entity.projects.storage.*;
import gamz.projects.pharmacyfair.model.entity.projects.storage.PresentationFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED) // Каждый подкласс — в своей таблице
@Entity
@SuperBuilder
@Table(name="projects")
public class Project {
    @Id
    @SequenceGenerator(name = "projects_local_seq", sequenceName = "projects_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projects_local_seq")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_scope_id")
    private Scope scope;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private ProjectStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ipr_status_id")
    private IprStatus iprStatus;

    @Column(name = "ipr_valuation_exists")
    private boolean iprValuationExists;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commercial_status_id")
    private CommercialStatus commercialStatus;

    @Column(name = "commercial_effect")
    private String commercialEffect;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "market_perspective_id")
    private MarketPerspective marketPerspectives;

    @Column(name = "novelty")
    private String novelty;

    @Column(name = "key_differences")
    private String keyDifferences;

    @Column(name = "export_potential")
    private Boolean exportPotential;

    @ManyToOne
    @JoinColumn(name = "production_requirement_id")
    private ProductionRequirement productionRequirements;

    @ManyToOne
    @JoinColumn(name = "completion_time_id")
    private CompletionTime completionTime;

    @ManyToOne
    @JoinColumn(name = "students_involved_id")
    private StudentsInvolved studentsInvolved;

    @ManyToMany
    @JoinTable(
            name = "project_presentation_formats",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "format_id")
    )
    private List<PresentationFormat> presentationFormats;

    @Column(name = "presentation_file_path")
    private String presentationFilePath;

    @OneToOne(mappedBy = "project", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Device device;

    @OneToOne(mappedBy = "project", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Medication medication;
}
