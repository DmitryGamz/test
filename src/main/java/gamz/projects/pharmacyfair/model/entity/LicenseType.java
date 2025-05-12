package gamz.projects.pharmacyfair.model.entity;

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
@Table(name = "license_types")
public class LicenseType {
    @Id
    @SequenceGenerator(name = "license_types_local_seq", sequenceName = "license_types_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "license_types_local_seq")
    private long id;

    @Column(name = "type_name")
    public String typeName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "license_type_id")
    public List<PharmaceuticalLicense> pharmaceuticalLicensesList;
}
