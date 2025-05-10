package gamz.projects.pharmacyfair.model.entity.projects;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import gamz.projects.pharmacyfair.model.entity.projects.storage.ApplicationAreaMedication;
import gamz.projects.pharmacyfair.model.entity.projects.storage.MedicationForm;
import gamz.projects.pharmacyfair.model.entity.projects.storage.PriorityType;
import gamz.projects.pharmacyfair.model.entity.projects.storage.TechReadinessMedication;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Device.class, name = "device"),
        @JsonSubTypes.Type(value = Medication.class, name = "medication")
})
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("medication")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="medication_details")
public class Medication extends Project{

    @Id
    @SequenceGenerator(name = "medication_details_local_seq", sequenceName = "medication_details_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medication_details_local_seq")
    private long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Project project;

    @ManyToOne
    private TechReadinessMedication techReadiness;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "medication_forms_link",
            joinColumns = @JoinColumn(name = "medication_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "form_id")
    )
    private List<MedicationForm> forms;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "medication_priority_types",
            joinColumns = @JoinColumn(name = "medication_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "priority_id")
    )
    private List<PriorityType> priorityTypes;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "medication_application_areas_link",
            joinColumns = @JoinColumn(name = "medication_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "application_areas_medication_id")
    )
    private List<ApplicationAreaMedication> applicationAreaMedications;
}
