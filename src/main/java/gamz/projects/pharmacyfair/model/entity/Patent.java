package gamz.projects.pharmacyfair.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="patents")
public class Patent {
    @Id
    @SequenceGenerator(name = "patents_local_seq", sequenceName = "patents_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patents_local_seq")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patent_type_id")
    private PatentType patentType;

    @Column(name = "patent_number")
    private String patentNumber;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "patent_owner_id")
    private Long patentOwnerId;

    @Column(name = "application_number")
    private String applicationNumber;

    @Column(name = "filing_date")
    private LocalDate filingDate;

    @Column(name = "applicant_id")
    private Long applicantId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
} 