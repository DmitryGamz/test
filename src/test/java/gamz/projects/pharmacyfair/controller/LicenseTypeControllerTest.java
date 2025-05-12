package gamz.projects.pharmacyfair.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import gamz.projects.pharmacyfair.configuration.TestSecurityConfig;
import gamz.projects.pharmacyfair.model.dto.LicenseTypeDTO;
import gamz.projects.pharmacyfair.model.exception.LicenseTypeNotFoundException;
import gamz.projects.pharmacyfair.model.request.LicenseTypeRequest;
import gamz.projects.pharmacyfair.service.LicenseTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = LicenseTypeController.class)
@Import({TestSecurityConfig.class, TestGlobalExceptionHandler.class})
class LicenseTypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private LicenseTypeService licenseTypeService;

    private LicenseTypeDTO licenseTypeDTO;
    private LicenseTypeRequest licenseTypeRequest;

    @BeforeEach
    void setUp() {
        licenseTypeDTO = new LicenseTypeDTO();
        licenseTypeDTO.setId(1L);
        licenseTypeDTO.setTypeName("Test License Type");

        licenseTypeRequest = new LicenseTypeRequest();
        licenseTypeRequest.setTypeName("Test License Type");
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return all license types")
    void getAllLicenseTypes() throws Exception {
        // Arrange
        List<LicenseTypeDTO> licenseTypes = Collections.singletonList(licenseTypeDTO);
        when(licenseTypeService.getAllLicenseTypes()).thenReturn(licenseTypes);

        // Act & Assert
        mockMvc.perform(get("/api/v1/license-type")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].typeName", is("Test License Type")));

        verify(licenseTypeService, times(1)).getAllLicenseTypes();
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return license type by ID")
    void getLicenseTypeById() throws Exception {
        // Arrange
        when(licenseTypeService.getLicenseById(1L)).thenReturn(licenseTypeDTO);

        // Act & Assert
        mockMvc.perform(get("/api/v1/license-type/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.typeName", is("Test License Type")));

        verify(licenseTypeService, times(1)).getLicenseById(1L);
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return 404 when license type ID not found")
    void getLicenseTypeById_NotFound() throws Exception {
        // Arrange
        when(licenseTypeService.getLicenseById(999L))
                .thenThrow(new LicenseTypeNotFoundException("License type with ID 999 not found"));

        // Act & Assert
        mockMvc.perform(get("/api/v1/license-type/999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(licenseTypeService, times(1)).getLicenseById(999L);
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should create new license type")
    void createLicenseType() throws Exception {
        // Arrange
        when(licenseTypeService.createLicense(any(LicenseTypeRequest.class))).thenReturn(licenseTypeDTO);

        // Act & Assert
        mockMvc.perform(post("/api/v1/license-type")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(licenseTypeRequest)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.typeName", is("Test License Type")));

        verify(licenseTypeService, times(1)).createLicense(any(LicenseTypeRequest.class));
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should update license type")
    void editLicenseType() throws Exception {
        // Arrange
        LicenseTypeDTO updatedDTO = new LicenseTypeDTO();
        updatedDTO.setId(1L);
        updatedDTO.setTypeName("Updated License Type");

        LicenseTypeRequest updateRequest = new LicenseTypeRequest();
        updateRequest.setTypeName("Updated License Type");

        when(licenseTypeService.editLicenseById(eq(1L), any(LicenseTypeRequest.class))).thenReturn(updatedDTO);

        // Act & Assert
        mockMvc.perform(put("/api/v1/license-type/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateRequest)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.typeName", is("Updated License Type")));

        verify(licenseTypeService, times(1)).editLicenseById(eq(1L), any(LicenseTypeRequest.class));
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return 404 when updating non-existent license type")
    void editLicenseType_NotFound() throws Exception {
        // Arrange
        when(licenseTypeService.editLicenseById(eq(999L), any(LicenseTypeRequest.class)))
                .thenThrow(new LicenseTypeNotFoundException("License type with ID 999 not found"));

        // Act & Assert
        mockMvc.perform(put("/api/v1/license-type/999")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(licenseTypeRequest)))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(licenseTypeService, times(1)).editLicenseById(eq(999L), any(LicenseTypeRequest.class));
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should delete license type")
    void deleteLicenseType() throws Exception {
        // Arrange
        doNothing().when(licenseTypeService).deleteById(1L);

        // Act & Assert
        mockMvc.perform(delete("/api/v1/license-type/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());

        verify(licenseTypeService, times(1)).deleteById(1L);
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return 404 when deleting non-existent license type")
    void deleteLicenseType_NotFound() throws Exception {
        // Arrange
        doThrow(new LicenseTypeNotFoundException("License type with ID 999 not found"))
                .when(licenseTypeService).deleteById(999L);

        // Act & Assert
        mockMvc.perform(delete("/api/v1/license-type/999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(licenseTypeService, times(1)).deleteById(999L);
    }
}