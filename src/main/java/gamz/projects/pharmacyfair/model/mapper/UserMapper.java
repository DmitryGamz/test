package gamz.projects.pharmacyfair.model.mapper;

import gamz.projects.pharmacyfair.model.dto.UserDTO;
import gamz.projects.pharmacyfair.model.entity.Organization;
import gamz.projects.pharmacyfair.model.entity.Role;
import gamz.projects.pharmacyfair.model.entity.User;
import gamz.projects.pharmacyfair.model.request.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
		unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface UserMapper {

    @Mapping(source = "roles", target = "roles")
    @Mapping(source = "organization", target = "organization")
    UserDTO toUserDTOFromUser(User user);

    User toUserFromRegisterRequest(RegisterRequest request);

    // Methods from User to UserDTO
    default String roleToString(Role role) {
        return role.getName();
    }

    default String organizationToString(Organization organization) {
        if (organization == null) {
            return "";
        }
        return organization.getName();
    }
}
