package gamz.projects.pharmacyfair.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import gamz.projects.pharmacyfair.configuration.TestSecurityConfig;
import gamz.projects.pharmacyfair.model.dto.LicenseCategoryDTO;
import gamz.projects.pharmacyfair.model.exception.LicenseCategoryNotFoundException;
import gamz.projects.pharmacyfair.model.request.LicenseCategoryRequest;
import gamz.projects.pharmacyfair.service.LicenseCategoryService;
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

@WebMvcTest(controllers = LicenseCategoryController.class)
@Import({TestSecurityConfig.class, TestGlobalExceptionHandler.class})
class LicenseCategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private LicenseCategoryService licenseCategoryService;

    private LicenseCategoryDTO licenseCategoryDTO;
    private LicenseCategoryRequest licenseCategoryRequest;

    @BeforeEach
    void setUp() {
        licenseCategoryDTO = LicenseCategoryDTO.builder()
                .id(1L)
                .categoryName("Test Category")
                .parentCategoryId(null)
                .build();

        licenseCategoryRequest = LicenseCategoryRequest.builder()
                .categoryName("Test Category")
                .parentCategoryId(null)
                .build();
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return all categories")
    void getAllCategories() throws Exception {
        // Arrange
        List<LicenseCategoryDTO> categories = Collections.singletonList(licenseCategoryDTO);
        when(licenseCategoryService.getAllLicenseCategories()).thenReturn(categories);

        // Act & Assert
        mockMvc.perform(get("/api/v1/license-categories")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].categoryName", is("Test Category")));

        verify(licenseCategoryService).getAllLicenseCategories();
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return root categories")
    void getRootCategories() throws Exception {
        // Arrange
        List<LicenseCategoryDTO> categories = Collections.singletonList(licenseCategoryDTO);
        when(licenseCategoryService.getLicenseCategoriesByParentCategoryIsNull()).thenReturn(categories);

        // Act & Assert
        mockMvc.perform(get("/api/v1/license-categories/root")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].categoryName", is("Test Category")));

        verify(licenseCategoryService).getLicenseCategoriesByParentCategoryIsNull();
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return category by ID")
    void getCategoryById() throws Exception {
        // Arrange
        when(licenseCategoryService.getLicenseCategoryById(1L)).thenReturn(licenseCategoryDTO);

        // Act & Assert
        mockMvc.perform(get("/api/v1/license-categories/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.categoryName", is("Test Category")));

        verify(licenseCategoryService).getLicenseCategoryById(1L);
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return related categories by parent ID")
    void getRelatedCategoriesByParentId() throws Exception {
        // Arrange
        List<LicenseCategoryDTO> categories = Collections.singletonList(licenseCategoryDTO);
        when(licenseCategoryService.getLicenseCategoriesByParentCategoryId(1L)).thenReturn(categories);

        // Act & Assert
        mockMvc.perform(get("/api/v1/license-categories/1/related")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].categoryName", is("Test Category")));

        verify(licenseCategoryService).getLicenseCategoriesByParentCategoryId(1L);
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should create new category")
    void createCategory() throws Exception {
        // Arrange
        when(licenseCategoryService.createLicenseCategory(any(LicenseCategoryRequest.class)))
                .thenReturn(licenseCategoryDTO);

        // Act & Assert
        mockMvc.perform(post("/api/v1/license-categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(licenseCategoryRequest)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.categoryName", is("Test Category")));

        verify(licenseCategoryService).createLicenseCategory(any(LicenseCategoryRequest.class));
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should update category")
    void editCategory() throws Exception {
        // Arrange
        when(licenseCategoryService.editLicenseCategory(eq(1L), any(LicenseCategoryRequest.class)))
                .thenReturn(licenseCategoryDTO);

        // Act & Assert
        mockMvc.perform(put("/api/v1/license-categories/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(licenseCategoryRequest)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.categoryName", is("Test Category")));

        verify(licenseCategoryService).editLicenseCategory(eq(1L), any(LicenseCategoryRequest.class));
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return 404 when category not found")
    void getCategoryById_NotFound() throws Exception {
        // Arrange
        when(licenseCategoryService.getLicenseCategoryById(999L))
                .thenThrow(new LicenseCategoryNotFoundException("Category not found"));

        // Act & Assert
        mockMvc.perform(get("/api/v1/license-categories/999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(licenseCategoryService).getLicenseCategoryById(999L);
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return 404 when updating non-existent category")
    void editCategory_NotFound() throws Exception {
        // Arrange
        when(licenseCategoryService.editLicenseCategory(eq(999L), any(LicenseCategoryRequest.class)))
                .thenThrow(new LicenseCategoryNotFoundException("Category not found"));

        // Act & Assert
        mockMvc.perform(put("/api/v1/license-categories/999")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(licenseCategoryRequest)))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(licenseCategoryService).editLicenseCategory(eq(999L), any(LicenseCategoryRequest.class));
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should delete category")
    void deleteCategory() throws Exception {
        // Arrange
        doNothing().when(licenseCategoryService).deleteLicenseCategory(1L);

        // Act & Assert
        mockMvc.perform(delete("/api/v1/license-categories/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());

        verify(licenseCategoryService).deleteLicenseCategory(1L);
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return 404 when deleting non-existent category")
    void deleteCategory_NotFound() throws Exception {
        // Arrange
        doThrow(new LicenseCategoryNotFoundException("Category not found"))
                .when(licenseCategoryService).deleteLicenseCategory(999L);

        // Act & Assert
        mockMvc.perform(delete("/api/v1/license-categories/999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(licenseCategoryService).deleteLicenseCategory(999L);
    }
}