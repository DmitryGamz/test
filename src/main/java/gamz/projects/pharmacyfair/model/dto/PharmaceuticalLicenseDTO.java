package gamz.projects.pharmacyfair.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PharmaceuticalLicenseDTO {
    private Long id;
    private Long partnerDetailId;
    private Long licenseTypeId;
    private Long licenseCategoryId;
}
