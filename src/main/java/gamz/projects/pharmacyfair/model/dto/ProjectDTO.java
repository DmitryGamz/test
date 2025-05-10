package gamz.projects.pharmacyfair.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ProjectDTO {

    private long id;
    private Long userId; // Используем ID вместо объекта User
    private Long productTypeId; // Используем ID вместо объекта ProductType
    private String name;
    private String description;
    private Long scopeId;
    private Long projectStatusId; // Используем ID вместо объекта ProjectStatus
    private Long iprStatusId; // Используем ID вместо объекта IprStatus
    private boolean iprValuationExists;
    private Long commercialStatusId; // Используем ID вместо объекта CommercialStatus
    private String commercialEffect;
    private Long marketPerspectivesId; // Используем ID вместо объекта MarketPerspectiv
    private String novelty;
    private String keyDifferences;
    private Boolean exportPotential;
    private Long productionRequirementsId; // Используем ID вместо объекта ProductionRequirement
    private Long completionTimeId; // Используем ID вместо объекта CompletionTime
    private Boolean hasStudentsInvolved;
}
