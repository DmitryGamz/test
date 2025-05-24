package gamz.projects.pharmacyfair.model.entity.projects.storage;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "presentation_formats")
public class PresentationFormat {

    @Id
    @SequenceGenerator(name = "presentation_formats_local_seq", sequenceName = "presentation_formats_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "presentation_formats_local_seq")
    private long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;
}
