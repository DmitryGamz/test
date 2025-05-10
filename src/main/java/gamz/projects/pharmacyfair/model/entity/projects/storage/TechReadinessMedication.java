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
@Table(name="medication_technology_readiness_levels")
public class TechReadinessMedication {

    @Id
    @SequenceGenerator(name = "medication_technology_readiness_levels_local_seq", sequenceName = "medication_technology_readiness_levels_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medication_technology_readiness_levels_local_seq")
    private long id;

    @Column(name = "level")
    private String level;

    @Column(name = "description")
    private String description;
}
