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
@Table(name="IPR_statuses")
public class IprStatus {

    @Id
    @SequenceGenerator(name = "IPR_statuses_local_seq", sequenceName = "IPR_statuses_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IPR_statuses_local_seq")
    private long id;

    @Column(name="code", unique = true, nullable = false)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
