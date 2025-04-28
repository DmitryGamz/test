package gamz.projects.pharmacyfair.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatentTypeDTO {
	private Long id;
	private String typeCode;
	private String typeName;
	private String description;
} 