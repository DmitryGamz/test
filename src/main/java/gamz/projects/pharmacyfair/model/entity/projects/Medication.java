package gamz.projects.pharmacyfair.model.entity.projects;

import gamz.projects.pharmacyfair.model.entity.projects.storage.ApplicationAreaMedication;
import gamz.projects.pharmacyfair.model.entity.projects.storage.MedicationForm;
import gamz.projects.pharmacyfair.model.entity.projects.storage.PriorityType;
import gamz.projects.pharmacyfair.model.entity.projects.storage.TechReadinessMedication;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="medication_details")
public class Medication extends Project{
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "technological_readiness_level_id")
    private TechReadinessMedication techReadiness;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "medication_forms_link",
            joinColumns = @JoinColumn(name = "medication_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "form_id")
    )
    private List<MedicationForm> forms;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "medication_priority_types",
            joinColumns = @JoinColumn(name = "medication_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "priority_id")
    )
    private List<PriorityType> priorityTypes;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "medication_application_areas_link",
            joinColumns = @JoinColumn(name = "medication_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "application_areas_medication_id")
    )
    private List<ApplicationAreaMedication> applicationAreaMedications;
}
