package gamz.projects.pharmacyfair.service.impl;

import gamz.projects.pharmacyfair.model.dto.FileTypeDto;
import gamz.projects.pharmacyfair.model.entity.FileType;
import gamz.projects.pharmacyfair.model.mapper.FileTypeMapper;
import gamz.projects.pharmacyfair.repository.FileTypeRepository;
import gamz.projects.pharmacyfair.service.interfaces.FileTypeService;
import gamz.projects.pharmacyfair.util.ValidationUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Slf4j
public class FileTypeServiceImpl implements FileTypeService {

    private final FileTypeRepository fileTypeRepository;
    private final FileTypeMapper fileTypeMapper;

    @Override
    @Transactional
    public FileTypeDto createFileType(FileTypeDto fileTypeDto) {

        log.info("Запрос на создание FileType с {}", fileTypeDto.toString());

        FileType fileType = fileTypeMapper.toEntity(fileTypeDto);

        FileType savedFileType = fileTypeRepository.save(fileType);

        log.info("FileType {} сохранен в БД", fileTypeDto);
        return fileTypeMapper.toDto(savedFileType);
    }

    @Override
    public FileTypeDto readFileType(Long id) {

        log.info("Запрошен FileType с id={}", id);

        ValidationUtils.validateId(id);

        return fileTypeMapper.toDto(fileTypeRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Тип файлов с id = " + id + " не найден")));
    }

    @Override
    @Transactional
    public FileTypeDto updateFileType(FileTypeDto fileTypeDto, Long id) {

        log.info("Запрос на изменение FileType с id={}", id);

        ValidationUtils.validateId(id);

        FileType existingFileType = fileTypeRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Тип файлов с id = " + id + " не найден"));

        existingFileType.setCode(fileTypeDto.getCode());
        existingFileType.setName(fileTypeDto.getName());
        existingFileType.setDescription(fileTypeDto.getDescription());

        FileType savedFileType = fileTypeRepository.save(existingFileType);

        log.info("Измененный FileType {} сохранен в БД", savedFileType);

        return fileTypeMapper.toDto(savedFileType);
    }

    @Override
    public void deleteFileType(Long id) {
        log.info("Запрос на удаление FileType с id={}", id);

        ValidationUtils.validateId(id);

        if (!fileTypeRepository.existsById(id)){
            throw new EntityNotFoundException("Тип файлов с id = " + id + " не найден");
        }

        fileTypeRepository.deleteById(id);
        log.info("FileType с id={} удален из БД", id);
    }
}
