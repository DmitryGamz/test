package gamz.projects.pharmacyfair.configuration.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class FilePathConfig {

    @Value("${file.storage.location}")
    private String location;

    @Bean
    public Path filePath() throws IOException {
        Path path = Paths.get(location).toAbsolutePath().normalize();

        Files.createDirectories(path);

        if (!Files.exists(path)){
            throw new RuntimeException("Папка не создана");
        }

        return path;
    }
}
