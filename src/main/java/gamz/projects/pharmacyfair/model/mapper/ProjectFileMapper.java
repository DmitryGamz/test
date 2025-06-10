package gamz.projects.pharmacyfair.model.mapper;

import gamz.projects.pharmacyfair.model.dto.ProjectFileDto;
import gamz.projects.pharmacyfair.model.entity.ProjectFile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectFileMapper {

    @Mapping(target = "fileType.id", source = "fileType")
    ProjectFile toEntity(ProjectFileDto projectFileDto);

    @Mapping(target = "fileType", source = "fileType.id")
    ProjectFileDto toDto(ProjectFile projectFile);
}