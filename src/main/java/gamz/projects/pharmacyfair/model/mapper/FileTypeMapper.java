package gamz.projects.pharmacyfair.model.mapper;

import gamz.projects.pharmacyfair.model.dto.FileTypeDto;
import gamz.projects.pharmacyfair.model.entity.FileType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileTypeMapper {

    FileTypeDto toDto(FileType fileType);
    FileType toEntity(FileTypeDto fileTypeDto);
}
