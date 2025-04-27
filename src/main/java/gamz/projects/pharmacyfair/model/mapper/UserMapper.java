package gamz.projects.pharmacyfair.model.mapper;

import gamz.projects.pharmacyfair.model.dto.UserDTO;
import gamz.projects.pharmacyfair.model.entity.User;
import gamz.projects.pharmacyfair.model.request.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING ,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface UserMapper {

    //@Mapping(target = "organization", expression = "java(userDTO.getOrganization())")
    //User toUserFromDTO(UserDTO userDTO);

    //UserDTO toUserDTOfromUser(User user);

    User toUserFromRegisterRequest(RegisterRequest request);
}
