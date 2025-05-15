package gamz.projects.pharmacyfair.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class MedicationDTO {
    private Long id;
    private long userId;
    private long productTypeId;
    private String name;
    private String description;
    private long scopeId;
    private long projectStatusId;
    private long iprStatusId;
    private boolean iprValuationExists;
    private long commercialStatusId;
    private String commercialEffect;
    private long marketPerspectivesId;
    private String novelty;
    private String keyDifferences;
    private Boolean exportPotential;
    private long hasStudentsInvolvedId;
    private long techReadinessId;
    private List<Long> formIds;
    private List<Long> priorityTypeIds;
    private List<Long> applicationAreaMedicationIds;
}
