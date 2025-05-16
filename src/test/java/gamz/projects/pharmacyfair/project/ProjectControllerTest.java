package gamz.projects.pharmacyfair.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import gamz.projects.pharmacyfair.controller.ProjectController;
import gamz.projects.pharmacyfair.model.entity.projects.Project;
import gamz.projects.pharmacyfair.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ProjectController.class)
//TODO Не могу пока продумать все взаимодействия
@MockitoSettings(strictness = Strictness.LENIENT)
public class ProjectControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProjectService projectService;

    @Autowired
    private ObjectMapper objectMapper;

    private Project project;

    @Test
    void createDevice_ReturnsCreated() throws Exception {
        /*
        1) Создать проект
        2) Создать устройство
        3) Привязать к проекту
        4) Отправить на сохранение
         */

        // Given
        DeviceDTO request = new DeviceDTO(
                1L, 2L, 3L, true, List.of(4L, 5L), List.of(6L, 7L));

        // When
        mockMvc.perform(post("/api/devices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))

                // Then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.riskClassId").value(1));
    }

    @Test
    void createMedication_ReturnsCreated() throws Exception {
        // Given
        DeviceDTO request = new DeviceDTO(
                1L, 2L, 3L, true, List.of(4L, 5L), List.of(6L, 7L));

        // When
        mockMvc.perform(post("/api/devices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))

                // Then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.riskClassId").value(1));
    }
}
