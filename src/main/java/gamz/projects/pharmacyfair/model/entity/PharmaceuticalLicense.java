package gamz.projects.pharmacyfair.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pharmaceutical_licenses")
public class PharmaceuticalLicense {
    @Id
    @SequenceGenerator(name = "pharmaceutical_licenses_local_seq", sequenceName = "pharmaceutical_licenses_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pharmaceutical_licenses_local_seq")
    private long id;

    //TODO: create relation to pharmaceutical_partner_details table
    @Column(name = "partner_detail_id")
    public long partnerDetail;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "license_type_id")
    public LicenseType licenseType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "license_category_id")
    public LicenseCategory licenseCategory;
}
