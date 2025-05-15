package gamz.projects.pharmacyfair.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import gamz.projects.pharmacyfair.model.dto.LicenseCategoryDTO;
import gamz.projects.pharmacyfair.model.entity.LicenseCategory;
import gamz.projects.pharmacyfair.model.exception.LicenseCategoryNotFoundException;
import gamz.projects.pharmacyfair.model.mapper.LicenseCategoryMapper;
import gamz.projects.pharmacyfair.model.request.LicenseCategoryRequest;
import gamz.projects.pharmacyfair.repository.LicenseCategoryRepository;

@ExtendWith(MockitoExtension.class)
class LicenseCategoryServiceTest {
    @Mock
    private LicenseCategoryRepository licenseCategoryRepository;

    @Mock
    private LicenseCategoryMapper licenseCategoryMapper;

    @InjectMocks
    private LicenseCategoryService licenseCategoryService;

    private LicenseCategory licenseCategory;
    private LicenseCategoryDTO licenseCategoryDTO;
    private LicenseCategoryRequest licenseCategoryRequest;

    @BeforeEach
    void setUp() {
        // Set up test data
        licenseCategory = LicenseCategory.builder()
                .id(1L)
                .categoryName("test category 1")
                .build();

        licenseCategoryDTO = LicenseCategoryDTO.builder()
                .id(1L)
                .categoryName("test category 1")
                .build();

        licenseCategoryRequest = LicenseCategoryRequest.builder()
                .categoryName("test category 2")
                .build();
    }

    @Test
    @DisplayName("Should return all categories")
    void getAllCategories() {
        // Arrange
        List<LicenseCategory> categories = Collections.singletonList(licenseCategory);
        when(licenseCategoryRepository.findAll()).thenReturn(categories);
        when(licenseCategoryMapper.toLicenseCategoryDTO(any(LicenseCategory.class))).thenReturn(licenseCategoryDTO);

        // Act
        List<LicenseCategoryDTO> result = licenseCategoryService.getAllLicenseCategories();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(licenseCategoryDTO, result.getFirst());
        verify(licenseCategoryRepository, times(1)).findAll();
        verify(licenseCategoryMapper, times(1)).toLicenseCategoryDTO(any(LicenseCategory.class));
    }

    @Test
    @DisplayName("Should return license category by ID")
    void getCategoryById() {
        // Arrange
        Long id = 1L;
        when(licenseCategoryRepository.findById(id)).thenReturn(Optional.of(licenseCategory));
        when(licenseCategoryMapper.toLicenseCategoryDTO(any(LicenseCategory.class))).thenReturn(licenseCategoryDTO);

        // Act
        LicenseCategoryDTO result = licenseCategoryService.getLicenseCategoryById(id);

        // Assert
        assertNotNull(result);
        assertEquals(licenseCategoryDTO, result);
        verify(licenseCategoryRepository, times(1)).findById(id);
        verify(licenseCategoryMapper, times(1)).toLicenseCategoryDTO(any(LicenseCategory.class));
    }

    @Test
    @DisplayName("Should throw exception when category ID if not found")
    void getCategoryById_NotFound() {
        // Arrange
        Long wrongId = 999L;
        when(licenseCategoryRepository.findById(wrongId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(
                LicenseCategoryNotFoundException.class,
                () -> licenseCategoryService.getLicenseCategoryById(wrongId));
        verify(licenseCategoryRepository, times(1)).findById(wrongId);
        verify(licenseCategoryMapper, never()).toLicenseCategoryDTO(any(LicenseCategory.class));
    }

    @Test
    @DisplayName("Should return license categories by parent category ID")
    void getLicenseCategoriesByParentCategoryId() {
        // Arrange
        Long parentId = 1L;
        List<LicenseCategory> categories = Collections.singletonList(licenseCategory);
        when(licenseCategoryRepository.existsById(parentId)).thenReturn(true);
        when(licenseCategoryRepository.findByParentCategoryId(parentId)).thenReturn(categories);
        when(licenseCategoryMapper.toLicenseCategoryDTO(any(LicenseCategory.class))).thenReturn(licenseCategoryDTO);

        // Act
        List<LicenseCategoryDTO> result = licenseCategoryService.getLicenseCategoriesByParentCategoryId(parentId);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(licenseCategoryDTO, result.getFirst());
        verify(licenseCategoryRepository, times(1)).existsById(parentId);
        verify(licenseCategoryRepository, times(1)).findByParentCategoryId(parentId);
        verify(licenseCategoryMapper, times(1)).toLicenseCategoryDTO(any(LicenseCategory.class));
    }

    @Test
    @DisplayName("Should throw exception when parent category ID not found")
    void getLicenseCategoriesByParentCategoryId_NotFound() {
        // Arrange
        Long wrongParentId = 999L;
        when(licenseCategoryRepository.existsById(wrongParentId)).thenReturn(false);

        // Act & Assert
        assertThrows(
                LicenseCategoryNotFoundException.class,
                () -> licenseCategoryService.getLicenseCategoriesByParentCategoryId(wrongParentId)
        );
        verify(licenseCategoryRepository, times(1)).existsById(wrongParentId);
        verify(licenseCategoryRepository, never()).findByParentCategoryId(any());
        verify(licenseCategoryMapper, never()).toLicenseCategoryDTO(any());
    }

    @Test
    @DisplayName("Should return license categories with null parent")
    void getLicenseCategoriesByParentCategoryIsNull() {
        // Arrange
        List<LicenseCategory> categories = Collections.singletonList(licenseCategory);
        when(licenseCategoryRepository.findByParentCategoryIsNull()).thenReturn(categories);
        when(licenseCategoryMapper.toLicenseCategoryDTO(any(LicenseCategory.class))).thenReturn(licenseCategoryDTO);

        // Act
        List<LicenseCategoryDTO> result = licenseCategoryService.getLicenseCategoriesByParentCategoryIsNull();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(licenseCategoryDTO, result.getFirst());
        verify(licenseCategoryRepository, times(1)).findByParentCategoryIsNull();
        verify(licenseCategoryMapper, times(1)).toLicenseCategoryDTO(any(LicenseCategory.class));
    }

    @Test
    @DisplayName("Should create license category with parent category")
    void createCategoryWithParent() {
        // Arrange
        Long parentId = 2L;
        LicenseCategory parentCategory = LicenseCategory.builder()
                .id(parentId)
                .categoryName("parent category")
                .build();

        licenseCategoryRequest.setParentCategoryId(parentId);
        licenseCategory.setParentCategory(parentCategory);

        when(licenseCategoryRepository.findById(parentId)).thenReturn(Optional.of(parentCategory));
        when(licenseCategoryMapper.toLicenseCategoryFromRequest(any(LicenseCategoryRequest.class)))
                .thenReturn(licenseCategory);
        when(licenseCategoryRepository.save(any(LicenseCategory.class))).thenReturn(licenseCategory);
        when(licenseCategoryMapper.toLicenseCategoryDTO(any(LicenseCategory.class))).thenReturn(licenseCategoryDTO);

        // Act
        LicenseCategoryDTO result = licenseCategoryService.createLicenseCategory(licenseCategoryRequest);

        // Assert
        assertNotNull(result);
        assertEquals(licenseCategoryDTO, result);
        verify(licenseCategoryRepository, times(1)).findById(parentId);
        verify(licenseCategoryMapper, times(1)).toLicenseCategoryFromRequest(any(LicenseCategoryRequest.class));
        verify(licenseCategoryRepository, times(1)).save(any(LicenseCategory.class));
        verify(licenseCategoryMapper, times(1)).toLicenseCategoryDTO(any(LicenseCategory.class));
    }

    @Test
    @DisplayName("Should throw exception when parent category not found during creation")
    void createCategory_ParentNotFound() {
        // Arrange
        Long wrongParentId = 999L;
        licenseCategoryRequest.setParentCategoryId(wrongParentId);
        when(licenseCategoryRepository.findById(wrongParentId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(
                LicenseCategoryNotFoundException.class,
                () -> licenseCategoryService.createLicenseCategory(licenseCategoryRequest)
        );
        verify(licenseCategoryRepository, times(1)).findById(wrongParentId);
        verify(licenseCategoryMapper, never()).toLicenseCategoryFromRequest(any());
        verify(licenseCategoryRepository, never()).save(any());
    }

    @Test
    @DisplayName("Should edit license category with parent category")
    void editCategoryWithParent() {
        // Arrange
        Long id = 1L;
        Long parentId = 2L;
        LicenseCategory parentCategory = LicenseCategory.builder()
                .id(parentId)
                .categoryName("parent category")
                .build();

        licenseCategoryRequest.setParentCategoryId(parentId);
        licenseCategory.setParentCategory(parentCategory);

        when(licenseCategoryRepository.findById(id)).thenReturn(Optional.of(licenseCategory));
        when(licenseCategoryRepository.findById(parentId)).thenReturn(Optional.of(parentCategory));
        when(licenseCategoryRepository.save(any(LicenseCategory.class))).thenReturn(licenseCategory);
        when(licenseCategoryMapper.toLicenseCategoryDTO(any(LicenseCategory.class))).thenReturn(licenseCategoryDTO);

        // Act
        LicenseCategoryDTO result = licenseCategoryService.editLicenseCategory(id, licenseCategoryRequest);

        // Assert
        assertNotNull(result);
        assertEquals(licenseCategoryDTO, result);
        verify(licenseCategoryRepository, times(1)).findById(id);
        verify(licenseCategoryRepository, times(1)).findById(parentId);
        verify(licenseCategoryRepository, times(1)).save(any(LicenseCategory.class));
        verify(licenseCategoryMapper, times(1)).toLicenseCategoryDTO(any(LicenseCategory.class));
    }

    @Test
    @DisplayName("Should throw exception when parent category not found during edit")
    void editCategory_ParentNotFound() {
        // Arrange
        Long id = 1L;
        Long wrongParentId = 999L;
        licenseCategoryRequest.setParentCategoryId(wrongParentId);

        when(licenseCategoryRepository.findById(id)).thenReturn(Optional.of(licenseCategory));
        when(licenseCategoryRepository.findById(wrongParentId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(
                LicenseCategoryNotFoundException.class,
                () -> licenseCategoryService.editLicenseCategory(id, licenseCategoryRequest)
        );
        verify(licenseCategoryRepository, times(1)).findById(id);
        verify(licenseCategoryRepository, times(1)).findById(wrongParentId);
        verify(licenseCategoryRepository, never()).save(any());
    }

    @Test
    @DisplayName("Should throw exception when edited category ID not found")
    void editCategory_NotFound() {
        // Arrange
        Long wrongId = 999L;
        when(licenseCategoryRepository.findById(wrongId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(
                LicenseCategoryNotFoundException.class,
                () -> licenseCategoryService.editLicenseCategory(wrongId, licenseCategoryRequest));
        verify(licenseCategoryRepository, times(1)).findById(wrongId);
        verify(licenseCategoryRepository, never()).save(any(LicenseCategory.class));
        verify(licenseCategoryMapper, never()).toLicenseCategoryDTO(any(LicenseCategory.class));
    }

    @Test
    @DisplayName("Should delete license category")
    void deleteCategory() {
        // Arrange
        Long id = 1L;
        when(licenseCategoryRepository.existsById(id)).thenReturn(true);
        doNothing().when(licenseCategoryRepository).deleteById(id);

        // Act
        licenseCategoryService.deleteLicenseCategory(id);

        // Assert
        verify(licenseCategoryRepository, times(1)).existsById(id);
        verify(licenseCategoryRepository, times(1)).deleteById(id);
    }

    @Test
    @DisplayName("Should throw exception when deleted category ID not found")
    void deleteCategory_NotFound() {
        // Arrange
        Long wrongId = 999L;
        when(licenseCategoryRepository.existsById(wrongId)).thenReturn(false);

        // Act & Assert
        assertThrows(
                LicenseCategoryNotFoundException.class,
                () -> licenseCategoryService.deleteLicenseCategory(wrongId));
        verify(licenseCategoryRepository, times(1)).existsById(wrongId);
        verify(licenseCategoryRepository, never()).deleteById(anyLong());
    }
}
