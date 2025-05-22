package gamz.projects.pharmacyfair.model.mapper;

import gamz.projects.pharmacyfair.model.dto.UserDTO;
import gamz.projects.pharmacyfair.model.entity.Organization;
import gamz.projects.pharmacyfair.model.entity.Role;
import gamz.projects.pharmacyfair.model.entity.User;
import gamz.projects.pharmacyfair.model.request.RegisterRequest;
import gamz.projects.pharmacyfair.model.request.UserRequest;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
		unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface UserMapper {

    @Mapping(source = "roles", target = "roles")
    @Mapping(source = "organization", target = "organization")
    UserDTO toUserDTOFromUser(User user);

    User toUserFromRegisterRequest(RegisterRequest request);

    void updateUserFromDTO(UserRequest request, @MappingTarget User user);

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
