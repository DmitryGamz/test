package gamz.projects.pharmacyfair.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MedicationDTO {
    private Long id;
    private UserProjectDTO user;
    private ReferenceDTO productType;
    private String name;
    private String description;
    private ReferenceDTO scope;
    private ReferenceDTO projectStatus;
    private ReferenceDTO iprStatus;
    private boolean iprValuationExists;
    private ReferenceDTO commercialStatus;
    private String commercialEffect;
    private ReferenceDTO marketPerspectives;
    private String novelty;
    private String keyDifferences;
    private Boolean exportPotential;
    private ReferenceDTO studentsInvolved;
    private ReferenceDTO techReadiness;
    private String presentationFilePath;
    private List<ReferenceDTO> forms;
    private List<ReferenceDTO> priorityTypes;
    private List<ReferenceDTO> applicationAreaMedications;
    private List<ReferenceDTO> presentationFormats;
}
