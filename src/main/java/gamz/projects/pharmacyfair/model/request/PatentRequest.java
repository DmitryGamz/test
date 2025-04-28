package gamz.projects.pharmacyfair.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatentRequest {
    private Long projectId;
    private Long patentTypeId;
    private String patentNumber;
    private LocalDate expiryDate;
    private Long patentOwnerId;
    private String applicationNumber;
    private LocalDate filingDate;
    private Long applicantId;
} 