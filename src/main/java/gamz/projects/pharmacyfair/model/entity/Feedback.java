package gamz.projects.pharmacyfair.model.entity;

import java.time.LocalDateTime;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="feedback")
public class Feedback {

    @Id
    @SequenceGenerator(name = "feedback_local_seq", sequenceName = "feedback_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_local_seq")
    private long id;

    public String name;

    public String email;

    public String message;

    @Column(name = "is_processed")
    @Default
    public Boolean isProcessed = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "processed_by")
    public User processedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "processed_at")
    public LocalDateTime processedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    public LocalDateTime createdAt;
}
