package gamz.projects.pharmacyfair.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class DeviceDTO {
    private long id;
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
    private long productionRequirementsId;
    private long completionTimeId;
    private long hasStudentsInvolvedId;
    private long riskClassId;
    private long techReadinessId;
    private long assessmentDemandId;
    private boolean includedInStandards;
    private List<Long> priorityTypeIds;
    private List<Long> nkmiIds;
}