package gamz.projects.pharmacyfair.model.entity.projects.storage;

import gamz.projects.pharmacyfair.model.entity.projects.Device;
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
@Table(name="priority_types")
public class PriorityType {

    @Id
    @SequenceGenerator(name = "medication_details_local_seq", sequenceName = "medication_details_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medication_details_local_seq")
    private long id;

    @Column(name="code", unique = true)
    private String code;

    @Column(name="name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "medical_device_priority_types",
            joinColumns = @JoinColumn(name = "priority_id"),
            inverseJoinColumns = @JoinColumn(name = "medical_device_detail_id")
    )
    private List<Device> devices;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "medication_priority_types",
            joinColumns = @JoinColumn(name = "priority_id"),
            inverseJoinColumns = @JoinColumn(name = "medication_detail_id")
    )
    private List<Medication> medications;


}
