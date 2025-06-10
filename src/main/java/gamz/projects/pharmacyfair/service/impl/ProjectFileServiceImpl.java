package gamz.projects.pharmacyfair.service.impl;

import gamz.projects.pharmacyfair.model.dto.ProjectFileDto;
import gamz.projects.pharmacyfair.model.entity.FileType;
import gamz.projects.pharmacyfair.model.entity.ProjectFile;
import gamz.projects.pharmacyfair.model.exception.FileNotAccessibleException;
import gamz.projects.pharmacyfair.model.exception.FileStorageException;
import gamz.projects.pharmacyfair.model.exception.InvalidFileException;
import gamz.projects.pharmacyfair.model.mapper.ProjectFileMapper;
import gamz.projects.pharmacyfair.model.response.DownloadFileResponse;
import gamz.projects.pharmacyfair.repository.FileTypeRepository;
import gamz.projects.pharmacyfair.repository.ProjectFileRepository;
import gamz.projects.pharmacyfair.service.interfaces.ProjectFileService;
import gamz.projects.pharmacyfair.util.ValidationUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectFileServiceImpl implements ProjectFileService {

    private final FileTypeRepository fileTypeRepository;
    private final ProjectFileRepository projectFileRepository;
    private final ProjectFileMapper projectFileMapper;
    private final Path fileStorageLocation;

    @Override
    @Transactional
    public ProjectFileDto uploadFile(MultipartFile file, Long fileTypeId) {

        if (file == null) {
            throw new InvalidFileException("Не прикреплен файл");
        }

        String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path targetPath = fileStorageLocation.resolve(filename);

        try {
            file.transferTo(targetPath);
        } catch (IOException e) {
            throw new FileStorageException("Ошибка сохранения файла " + e.getMessage(), e);
        }

        ProjectFile projectFile = new ProjectFile();

        if (fileTypeId != null){
            ValidationUtils.validateId(fileTypeId);
            FileType fileType = fileTypeRepository
                    .findById(fileTypeId)
                    .orElseThrow(() -> new EntityNotFoundException("Тип файлов с id = " + fileTypeId + " не найден"));
            projectFile.setFileType(fileType);
        }

        projectFile.setName(file.getOriginalFilename());
        projectFile.setPath(targetPath.toString());
        projectFile.setSize(file.getSize());
        projectFile.setMimeType(file.getContentType());
        projectFile.setUploadedAt(LocalDateTime.now());

        projectFileRepository.save(projectFile);

        return projectFileMapper.toDto(projectFile);
    }

    @Override
    @Transactional
    public DownloadFileResponse downLoadFile(Long id) {

        ValidationUtils.validateId(id);


        ProjectFile file = projectFileRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Файл с id = " + id + " не найден"));

        Path filePath = Paths.get(file.getPath()).normalize();
        Resource resource;
        try {
            resource = new FileSystemResource(filePath);
            if (!resource.exists() || !resource.isReadable()) {
                throw new FileNotAccessibleException("Файл недоступен: " + filePath);
            }
        } catch (Exception e) {
            throw new FileNotAccessibleException("Ошибка доступа к файлу", e);
        }

        return new DownloadFileResponse(
                resource,
                file.getName(),
                file.getMimeType()
        );
    }

    @Override
    @Transactional
    public ProjectFileDto updateFile(Long id, MultipartFile file) {

        ValidationUtils.validateId(id);
        if (file == null) {
            throw new InvalidFileException("Не прикреплен файл");
        }

        ProjectFile newFile = projectFileRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Файл с id = " + id + " не найден"));

        Path oldFilePath = Paths.get(newFile.getPath()).normalize();

        try {
            Files.deleteIfExists(oldFilePath);
        } catch (IOException e) {
            throw new FileNotAccessibleException("Не удалось удалить старый файл" + e);
        }

        String newFilename = UUID.randomUUID() + "_changed_" + file.getOriginalFilename();
        Path targetPath = fileStorageLocation.resolve(newFilename);

        try {
            file.transferTo(targetPath);
        } catch (IOException e) {
            throw new FileStorageException("Ошибка сохранения файла", e);
        }

        newFile.setName(file.getOriginalFilename());
        newFile.setPath(targetPath.toString());
        newFile.setSize(file.getSize());
        newFile.setMimeType(file.getContentType());
        newFile.setUploadedAt(LocalDateTime.now());

        projectFileRepository.save(newFile);

        return projectFileMapper.toDto(newFile);
    }

    @Override
    public void deleteFile(Long id) {

        ValidationUtils.validateId(id);

        ProjectFile file = projectFileRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Файл с id = " + id + " не найден"));

        Path pathFile = Paths.get(file.getPath()).normalize();

        try {
            Files.deleteIfExists(pathFile);
        } catch (IOException e) {
            throw new FileNotAccessibleException("Ошибка удаления файла");
        }

        projectFileRepository.deleteById(id);
    }
}



