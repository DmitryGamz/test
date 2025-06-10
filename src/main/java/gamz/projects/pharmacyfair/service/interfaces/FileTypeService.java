package gamz.projects.pharmacyfair.service.interfaces;

import gamz.projects.pharmacyfair.model.dto.FileTypeDto;
import org.springframework.stereotype.Service;

@Service
public interface FileTypeService {

    FileTypeDto createFileType(FileTypeDto fileType);
    FileTypeDto readFileType(Long id);
    FileTypeDto updateFileType(FileTypeDto fileTypeDto, Long id);
    void deleteFileType(Long id);

}
