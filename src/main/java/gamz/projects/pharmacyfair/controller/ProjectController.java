package gamz.projects.pharmacyfair.controller;

import gamz.projects.pharmacyfair.model.dto.MedicationDTO;
import gamz.projects.pharmacyfair.model.entity.projects.Device;
import gamz.projects.pharmacyfair.model.entity.projects.Project;
import gamz.projects.pharmacyfair.service.ProjectService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
@Tag(name = "Projects", description = "API for projects with extends to Medication and Device")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getProject(@PathVariable Long id) {
        Project project = projectService.findById(id);
        if (project instanceof Device) {
            return ResponseEntity.ok("device");
        } else {
            return ResponseEntity.ok("medication");
        }
    }

    /**
     * Create empty project by code of type
     * @param code
     * @return DTO of new project
     */
    @GetMapping("/create/empty/{code}")
    public ResponseEntity<?> createEmptyProject(@PathVariable String code) {
        return ResponseEntity.ok(projectService.createEmptyProject(code));
    }
}
