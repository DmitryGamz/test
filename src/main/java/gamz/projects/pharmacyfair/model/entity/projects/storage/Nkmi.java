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
@Table(name="NKMI_categories")
public class Nkmi {

    @Id
    @SequenceGenerator(name = "NKMI_categories_local_seq", sequenceName = "NKMI_categories_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NKMI_categories_local_seq")
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
            name = "medical_device_NKMI_link",
            joinColumns = @JoinColumn(name = "nkmi_id"),
            inverseJoinColumns = @JoinColumn(name = "medical_device_detail_id")
    )
    private List<Device> devices;
}
