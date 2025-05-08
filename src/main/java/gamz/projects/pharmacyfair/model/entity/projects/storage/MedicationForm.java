package gamz.projects.pharmacyfair.model.entity.projects.storage;

import gamz.projects.pharmacyfair.model.entity.projects.Medication;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="medication_forms")
public class MedicationForm {

    @Id
    @SequenceGenerator(name = "medication_forms_local_seq", sequenceName = "medication_forms_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medication_forms_local_seq")
    private long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "medication_forms_link",
            joinColumns = @JoinColumn(name = "form_id"),
            inverseJoinColumns = @JoinColumn(name = "medication_detail_id")
    )
    private List<Medication> medications;
}
