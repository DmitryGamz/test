package gamz.projects.pharmacyfair.model.entity.projects.storage;

import gamz.projects.pharmacyfair.model.entity.projects.Device;
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
@Table(name="application_areas_medication")
public class ApplicationAreaMedication {

    @Id
    @SequenceGenerator(name = "application_areas_medication_local_seq", sequenceName = "application_areas_medication_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_areas_medication_local_seq")
    private long id;

    @Column(unique = true)
    private String code;

    private String name;

    @OneToMany
    private List<Nkmi> children;

    @ManyToOne
    private Nkmi parent;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "medication_application_areas_link",
            joinColumns = @JoinColumn(name = "application_areas_medication_id"),
            inverseJoinColumns = @JoinColumn(name = "medication_detail_id")
    )
    private List<Device> devices;
}
