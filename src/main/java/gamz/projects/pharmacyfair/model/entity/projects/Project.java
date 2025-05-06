package gamz.projects.pharmacyfair.model.entity.projects;

import gamz.projects.pharmacyfair.model.entity.User;
import gamz.projects.pharmacyfair.model.entity.projects.storage.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    private String projectName;

    private String description;

    private int techReadiness;

    private String scope;

    @ManyToOne
    private ProjectStatus projectStatus;

    @ManyToOne
    private IprStatus iprStatus;

    private boolean iprValuationExists;

    @ManyToOne(fetch = FetchType.EAGER)
    private CommercialStatus commercialStatus;

    @Column
    private String commercialEffect;

    @ManyToOne(fetch = FetchType.EAGER)
    private MarketPerspective marketPerspectives;

    @Column
    private String novelty;

    @Column(name = "key_differences")
    private String keyDifferences;

    @Column(name = "export_potential")
    private Boolean exportPotential;

    @ManyToOne
    private ProductionRequirement productionRequirements;

    @ManyToOne
    private CompletionTime completionTime;

    @Column(name = "has_students_involved")
    private Boolean hasStudentsInvolved;
}
