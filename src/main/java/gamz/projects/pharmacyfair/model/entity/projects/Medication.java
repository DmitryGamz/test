package gamz.projects.pharmacyfair.model.entity.projects;

import gamz.projects.pharmacyfair.model.entity.projects.storage.MedicationForm;
import gamz.projects.pharmacyfair.model.entity.projects.storage.PriorityType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
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
}
