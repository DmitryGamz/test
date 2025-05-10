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
@Table(name="commercial_statuses")
public class CommercialStatus {

    @Id
    @SequenceGenerator(name = "commercial_statuses_local_seq", sequenceName = "commercial_statuses_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commercial_statuses_local_seq")
    private long id;

    @Column(name="code", unique = true, nullable = false)
    private String code;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;
}
