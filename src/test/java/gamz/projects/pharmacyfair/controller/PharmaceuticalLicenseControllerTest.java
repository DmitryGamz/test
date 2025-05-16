package gamz.projects.pharmacyfair.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import gamz.projects.pharmacyfair.configuration.TestSecurityConfig;
import gamz.projects.pharmacyfair.model.dto.PharmaceuticalLicenseDTO;
import gamz.projects.pharmacyfair.model.exception.PharmaceuticalLicenseNotFoundException;
import gamz.projects.pharmacyfair.model.request.PharmaceuticalLicenseRequest;
import gamz.projects.pharmacyfair.service.PharmaceuticalLicenseService;
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

@WebMvcTest(controllers = PharmaceuticalLicenseController.class)
@Import({TestSecurityConfig.class, TestGlobalExceptionHandler.class})
class PharmaceuticalLicenseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private PharmaceuticalLicenseService pharmaceuticalLicenseService;

    private PharmaceuticalLicenseDTO licenseDTO;
    private PharmaceuticalLicenseRequest licenseRequest;

    @BeforeEach
    void setUp() {
        licenseDTO = new PharmaceuticalLicenseDTO();
        licenseDTO.setId(1L);
        licenseDTO.setPartnerDetailId(100L);
        licenseDTO.setLicenseTypeId(1L);
        licenseDTO.setLicenseCategoryId(1L);

        licenseRequest = new PharmaceuticalLicenseRequest();
        licenseRequest.setPartnerDetailId(100L);
        licenseRequest.setLicenseTypeId(1L);
        licenseRequest.setLicenseCategoryId(1L);
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return all pharmaceutical licenses")
    void getAllPharmaceuticalLicenses() throws Exception {
        // Arrange
        List<PharmaceuticalLicenseDTO> licenses = Collections.singletonList(licenseDTO);
        when(pharmaceuticalLicenseService.getAllLicenses()).thenReturn(licenses);

        // Act & Assert
        mockMvc.perform(get("/api/v1/pharmaceutical-license")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].partnerDetailId", is(100)))
                .andExpect(jsonPath("$[0].licenseTypeId", is(1)))
                .andExpect(jsonPath("$[0].licenseCategoryId", is(1)));

        verify(pharmaceuticalLicenseService).getAllLicenses();
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return pharmaceutical license by ID")
    void getById() throws Exception {
        // Arrange
        when(pharmaceuticalLicenseService.getLicenseById(1L)).thenReturn(licenseDTO);

        // Act & Assert
        mockMvc.perform(get("/api/v1/pharmaceutical-license/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.partnerDetailId", is(100)))
                .andExpect(jsonPath("$.licenseTypeId", is(1)))
                .andExpect(jsonPath("$.licenseCategoryId", is(1)));

        verify(pharmaceuticalLicenseService).getLicenseById(1L);
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return licenses by type ID")
    void getByTypeId() throws Exception {
        // Arrange
        List<PharmaceuticalLicenseDTO> licenses = Collections.singletonList(licenseDTO);
        when(pharmaceuticalLicenseService.getLicenseByTypeId(1L)).thenReturn(licenses);

        // Act & Assert
        mockMvc.perform(get("/api/v1/pharmaceutical-license/type/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].partnerDetailId", is(100)))
                .andExpect(jsonPath("$[0].licenseTypeId", is(1)))
                .andExpect(jsonPath("$[0].licenseCategoryId", is(1)));

        verify(pharmaceuticalLicenseService).getLicenseByTypeId(1L);
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return licenses by category ID")
    void getByCategoryId() throws Exception {
        // Arrange
        List<PharmaceuticalLicenseDTO> licenses = Collections.singletonList(licenseDTO);
        when(pharmaceuticalLicenseService.getLicenseByCategoryId(1L)).thenReturn(licenses);

        // Act & Assert
        mockMvc.perform(get("/api/v1/pharmaceutical-license/category/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].partnerDetailId", is(100)))
                .andExpect(jsonPath("$[0].licenseTypeId", is(1)))
                .andExpect(jsonPath("$[0].licenseCategoryId", is(1)));

        verify(pharmaceuticalLicenseService).getLicenseByCategoryId(1L);
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should create new pharmaceutical license")
    void createPharmaceuticalLicense() throws Exception {
        // Arrange
        when(pharmaceuticalLicenseService.createLicense(any(PharmaceuticalLicenseRequest.class)))
                .thenReturn(licenseDTO);

        // Act & Assert
        mockMvc.perform(post("/api/v1/pharmaceutical-license")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(licenseRequest)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.partnerDetailId", is(100)))
                .andExpect(jsonPath("$.licenseTypeId", is(1)))
                .andExpect(jsonPath("$.licenseCategoryId", is(1)));

        verify(pharmaceuticalLicenseService).createLicense(any(PharmaceuticalLicenseRequest.class));
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should update pharmaceutical license")
    void updatePharmaceuticalLicense() throws Exception {
        // Arrange
        when(pharmaceuticalLicenseService.editLicense(eq(1L), any(PharmaceuticalLicenseRequest.class)))
                .thenReturn(licenseDTO);

        // Act & Assert
        mockMvc.perform(put("/api/v1/pharmaceutical-license/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(licenseRequest)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.partnerDetailId", is(100)))
                .andExpect(jsonPath("$.licenseTypeId", is(1)))
                .andExpect(jsonPath("$.licenseCategoryId", is(1)));

        verify(pharmaceuticalLicenseService).editLicense(eq(1L), any(PharmaceuticalLicenseRequest.class));
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return 404 when updating non-existent license")
    void updatePharmaceuticalLicense_NotFound() throws Exception {
        // Arrange
        when(pharmaceuticalLicenseService.editLicense(eq(999L), any(PharmaceuticalLicenseRequest.class)))
                .thenThrow(new PharmaceuticalLicenseNotFoundException("License not found"));

        // Act & Assert
        mockMvc.perform(put("/api/v1/pharmaceutical-license/999")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(licenseRequest)))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(pharmaceuticalLicenseService).editLicense(eq(999L), any(PharmaceuticalLicenseRequest.class));
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should delete pharmaceutical license")
    void deletePharmaceuticalLicense() throws Exception {
        // Arrange
        doNothing().when(pharmaceuticalLicenseService).deleteLicenseById(1L);

        // Act & Assert
        mockMvc.perform(delete("/api/v1/pharmaceutical-license/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());

        verify(pharmaceuticalLicenseService).deleteLicenseById(1L);
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return 404 when deleting non-existent license")
    void deletePharmaceuticalLicense_NotFound() throws Exception {
        // Arrange
        doThrow(new PharmaceuticalLicenseNotFoundException("License not found"))
                .when(pharmaceuticalLicenseService).deleteLicenseById(999L);

        // Act & Assert
        mockMvc.perform(delete("/api/v1/pharmaceutical-license/999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(pharmaceuticalLicenseService).deleteLicenseById(999L);
    }
}