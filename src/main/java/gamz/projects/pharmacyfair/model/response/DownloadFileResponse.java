package gamz.projects.pharmacyfair.model.response;

import org.springframework.core.io.Resource;

public record DownloadFileResponse (
    Resource resource,
    String filename,   // Оригинальное имя файла
    String mimeType
) {}
