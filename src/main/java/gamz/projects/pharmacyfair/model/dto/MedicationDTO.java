package gamz.projects.pharmacyfair.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class MedicationDTO {
    private long id;
    private Long userId;
    private Long productTypeId;
    private String name;
    private String description;
    private Long scopeId;
    private Long projectStatusId;
    private Long iprStatusId;
    private boolean iprValuationExists;
    private Long commercialStatusId;
    private String commercialEffect;
    private Long marketPerspectivesId;
    private String novelty;
    private String keyDifferences;
    private Boolean exportPotential;
    private Boolean hasStudentsInvolved;
    private Long techReadinessId;
    private List<Long> formIds;
    private List<Long> priorityTypeIds;
    private List<Long> applicationAreaMedicationIds;
}
