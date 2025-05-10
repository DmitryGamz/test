package gamz.projects.pharmacyfair.model.entity.projects;

import gamz.projects.pharmacyfair.model.entity.Organization;
import gamz.projects.pharmacyfair.model.entity.User;
import gamz.projects.pharmacyfair.model.entity.projects.storage.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED) // Каждый подкласс — в своей таблице
@DiscriminatorColumn(name = "project_type")
@Entity
@Table(name="projects")
public class Project {
    @Id
    @SequenceGenerator(name = "projects_local_seq", sequenceName = "projects_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projects_local_seq")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductType productType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "application_scope_id")
    private Scope scope;

    @ManyToOne
    private ProjectStatus projectStatus;

    @ManyToOne
    private IprStatus iprStatus;

    @Column(name = "ipr_valuation_exists")
    private boolean iprValuationExists;

    @ManyToOne(fetch = FetchType.EAGER)
    private CommercialStatus commercialStatus;

    @Column(name = "commercial_effect")
    private String commercialEffect;

    @ManyToOne(fetch = FetchType.EAGER)
    private MarketPerspective marketPerspectives;

    @Column(name = "novelty")
    private String novelty;

    @Column(name = "key_differences")
    private String keyDifferences;

    @Column(name = "export_potential")
    private Boolean exportPotential;

    @ManyToOne
    private ProductionRequirement productionRequirements;

    @ManyToOne
    private CompletionTime completionTime;

    @ManyToOne
    private StudentsInvolved studentsInvolved;

    @OneToOne
    @Builder.Default
    private Device device = null;

    @OneToOne
    @Builder.Default
    private Medication medication = null;
}
