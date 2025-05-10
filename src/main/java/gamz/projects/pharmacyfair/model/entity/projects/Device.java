package gamz.projects.pharmacyfair.model.entity.projects;

import gamz.projects.pharmacyfair.model.entity.projects.storage.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("device")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="medical_device_details")
public class Device extends Project{

    @Id
    @SequenceGenerator(name = "medical_device_details_local_seq", sequenceName = "medical_device_details_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medical_device_details_local_seq")
    private long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Project project;

    @ManyToOne
    private RiskClass riskClass;

    @ManyToOne
    private ProductionRequirement productionRequirements;

    @ManyToOne
    private TechReadinessDevice techReadiness;

    @ManyToOne
    private AssendDemand assendDemand;

    @Column(name = "included_in_standards")
    private boolean includedInStandards;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "medical_device_priority_types",
            joinColumns = @JoinColumn(name = "medical_device_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "priority_id")
    )
    private List<PriorityType> priorityTypes;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "medical_device_NKMI_link",
            joinColumns = @JoinColumn(name = "medical_device_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "nkmi_id")
    )
    private List<Nkmi> nkmis;

}
