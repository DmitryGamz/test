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
    private UserDTO user;
    private ReferenceDTO productType;
    private String name;
    private String description;
    private ReferenceDTO scope;
    private ReferenceDTO projectStatus;
    private ReferenceDTO iprStatus;
    private boolean iprValuationExists;
    private ReferenceDTO commercialStatus;
    private String commercialEffect;
    private long marketPerspectivesId;
    private String novelty;
    private String keyDifferences;
    private Boolean exportPotential;
    private ReferenceDTO hasStudentsInvolved;
    private ReferenceDTO techReadiness;
    private String presentationFilePath;
    private List<ReferenceDTO> form;
    private List<ReferenceDTO> priorityType;
    private List<ReferenceDTO> applicationAreaMedication;
    private List<ReferenceDTO> presentationFormats;
}
