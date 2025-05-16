package gamz.projects.pharmacyfair.model.entity.projects;

import gamz.projects.pharmacyfair.model.entity.projects.storage.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="medical_device_details")
public class Device extends Project {
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "risk_class_id")
    private RiskClass riskClass;

    @ManyToOne
    @JoinColumn(name = "technological_readiness_level_id")
    private TechReadinessDevice techReadiness;

    @ManyToOne
    @JoinColumn(name = "assessment_demand_device_id")
    private AssendDemand assendDemand;

    @Column(name = "included_in_standards")
    private boolean includedInStandards;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "medical_device_priority_types",
            joinColumns = @JoinColumn(name = "medical_device_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "priority_id")
    )
    private List<PriorityType> priorityTypes;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "medical_device_NKMI_link",
            joinColumns = @JoinColumn(name = "medical_device_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "nkmi_id")
    )
    private List<Nkmi> nkmis;

}
