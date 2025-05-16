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
@Table(name="assessment_demand_device")
public class AssendDemand {

    @Id
    @SequenceGenerator(name = "assessment_demand_device_local_seq", sequenceName = "assessment_demand_device_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assessment_demand_device_local_seq")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}