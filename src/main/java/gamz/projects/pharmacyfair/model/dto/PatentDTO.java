package gamz.projects.pharmacyfair.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatentDTO {
	private Long id;
	private Long projectId;
	private Long patentTypeId;
	private String patentTypeName;
	private String patentNumber;
	private LocalDate expiryDate;
	private Long patentOwnerId;
	private String applicationNumber;
	private LocalDate filingDate;
	private Long applicantId;
} 