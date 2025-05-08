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
@Table(name="market_perspectives")
public class MarketPerspective {

    @Id
    @SequenceGenerator(name = "market_perspectives_local_seq", sequenceName = "market_perspectives_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "market_perspectives_local_seq")
    private long id;

    @Column(name="code", unique = true, nullable = false)
    private String code;

    @Column(name = "description")
    private String description;
}
