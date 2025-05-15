package gamz.projects.pharmacyfair.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PharmaceuticalLicenseRequest {
    private Long partnerDetailId;
    private Long licenseTypeId;
    private Long licenseCategoryId;
}
