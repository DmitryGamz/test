package gamz.projects.pharmacyfair.model.mapper;

import gamz.projects.pharmacyfair.model.dto.ProjectDTO;
import gamz.projects.pharmacyfair.model.entity.projects.Project;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING ,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectMapper {
    ProjectDTO toProjectDtoFromProject(Project project);
}
