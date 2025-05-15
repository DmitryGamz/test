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
@Table(name = "license_categories")
public class LicenseCategory {
    // TODO: Sequence generator is broken. Collision error: `id=1 is already exists`
    @Id
    @SequenceGenerator(name = "license_categories_local_seq", sequenceName = "license_categories_id_seq", allocationSize = 1,
            // added initial value to evade conflicts from migrations test data
            initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "license_categories_local_seq")
    private long id;

    @Column(name = "category_name")
    public String categoryName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_category_id")
    public List<LicenseCategory> relatedCategories;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_category_id")
    public LicenseCategory parentCategory;
}
