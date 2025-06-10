package gamz.projects.pharmacyfair.controller;


import gamz.projects.pharmacyfair.model.dto.ProjectFileDto;
import gamz.projects.pharmacyfair.model.response.DownloadFileResponse;
import gamz.projects.pharmacyfair.service.impl.ProjectFileServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/project-file")
@RequiredArgsConstructor
public class ProjectFileController {

    private final ProjectFileServiceImpl projectFileService;

    @Operation(
            summary = "Загрузить файл ProjectFile на сервер",
            description = "Файл в теле form-data, ключ \"file\", так же ключ id - привязать к FileType"
    )
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ProjectFileDto uploadFile(@RequestParam("file") MultipartFile file,
                                     @RequestParam(required = false) Long id){
        return projectFileService.uploadFile(file, id);
    }

    @Operation(
            summary = "Скачать файл ProjectFile с сервера",
            description = "В строке запроса передать id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Resource> downLoadFile(@PathVariable Long id) {
        DownloadFileResponse response = projectFileService.downLoadFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + response.filename() + "\"")
                .contentType(MediaType.parseMediaType(response.mimeType()))
                .body(response.resource());
    }

    @Operation(
            summary = "Обновить файл ProjectFile на сервере",
            description = "Файл в теле form-data, ключ \"file\", так же ключ id - это id ProjectType!"
    )
    @PatchMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ProjectFileDto updateFile(@RequestParam Long id, @RequestParam("file") MultipartFile file){
        return projectFileService.updateFile(id, file);
    }

    @Operation(
            summary = "Удалить файл ProjectFile",
            description = "Передать в строке запроса id файла"
    )
    @DeleteMapping("{id}")
    public void deleteFile(@PathVariable Long id){
        projectFileService.deleteFile(id);
    }
}
