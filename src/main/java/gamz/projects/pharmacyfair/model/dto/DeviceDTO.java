package gamz.projects.pharmacyfair.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class DeviceDTO {
    private long id;
    private long userId; // Используем ID вместо объекта User
    private long productTypeId; // Используем ID вместо объекта ProductType
    private String name;
    private String description;
    private long scopeId;
    private long projectStatusId; // Используем ID вместо объекта ProjectStatus
    private long iprStatusId; // Используем ID вместо объекта IprStatus
    private boolean iprValuationExists;
    private long commercialStatusId; // Используем ID вместо объекта CommercialStatus
    private String commercialEffect;
    private long marketPerspectivesId; // Используем ID вместо объекта MarketPerspectiv
    private String novelty;
    private String keyDifferences;
    private Boolean exportPotential;
    private long productionRequirementsId; // Используем ID вместо объекта ProductionRequirement
    private long completionTimeId; // Используем ID вместо объекта CompletionTime
    private long studentsInvolvedId;
    private long riskClassId;
    private long techReadinessId;
    private long assessmentDemandId;
    private boolean includedInStandards;
    private List<Long> priorityTypeIds;
    private List<Long> nkmiIds;
}