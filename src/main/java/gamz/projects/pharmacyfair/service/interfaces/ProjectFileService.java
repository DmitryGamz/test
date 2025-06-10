package gamz.projects.pharmacyfair.service.interfaces;

import gamz.projects.pharmacyfair.model.dto.ProjectFileDto;
import gamz.projects.pharmacyfair.model.response.DownloadFileResponse;
import org.springframework.web.multipart.MultipartFile;


public interface ProjectFileService {
    ProjectFileDto uploadFile(MultipartFile file, Long fileTypeId);
    DownloadFileResponse downLoadFile(Long id);
    ProjectFileDto updateFile(Long id, MultipartFile file);
    void deleteFile(Long id);
}
