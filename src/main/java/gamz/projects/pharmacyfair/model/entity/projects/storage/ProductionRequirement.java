package gamz.projects.pharmacyfair.model.entity.projects.storage;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="production_requirements")
public class ProductionRequirement {

    @Id
    @SequenceGenerator(name = "production_requirements_local_seq", sequenceName = "production_requirements_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "production_requirements_local_seq")
    private long id;

    @Column(name="code", unique = true, nullable = false)
    private String code;

    @Column(name = "description")
    private String description;
}
