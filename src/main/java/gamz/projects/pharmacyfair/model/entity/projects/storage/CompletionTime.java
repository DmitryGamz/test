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
@Table(name="completion_times")
public class CompletionTime {

    @Id
    @SequenceGenerator(name = "completion_times_local_seq", sequenceName = "completion_times_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "completion_times_local_seq")
    private long id;

    @Column(name="time_code", unique = true, nullable = false)
    private String timeCode;

    @Column(name = "time_name", nullable = false)
    private String timeName;

    @Column
    private String description;
}
