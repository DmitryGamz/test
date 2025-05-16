package gamz.projects.pharmacyfair.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LicenseCategoryRequest {
    private String categoryName;
    private Long parentCategoryId;
}
