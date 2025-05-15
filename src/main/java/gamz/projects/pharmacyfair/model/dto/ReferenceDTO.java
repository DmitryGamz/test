package gamz.projects.pharmacyfair.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReferenceDTO {
    //Обязательные
    private Long id;
    private String type;
    //Необязательные
    private String code;
    private String description;
    private String level;
    private String name;
    private long parentId;
}