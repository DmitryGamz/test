package gamz.projects.pharmacyfair.model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProjectDTO {
    private  String email;
    private  String firstName;
    private  String lastName;
    private  String middleName;
    private  OrganisationDTO organization;
    private  String jobTitle;
    private  String phone;
}
