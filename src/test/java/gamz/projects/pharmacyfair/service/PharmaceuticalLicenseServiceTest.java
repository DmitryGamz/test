package gamz.projects.pharmacyfair.service;

import gamz.projects.pharmacyfair.model.dto.PharmaceuticalLicenseDTO;
import gamz.projects.pharmacyfair.model.entity.LicenseCategory;
import gamz.projects.pharmacyfair.model.entity.LicenseType;
import gamz.projects.pharmacyfair.model.entity.PharmaceuticalLicense;
import gamz.projects.pharmacyfair.model.exception.LicenseCategoryNotFoundException;
import gamz.projects.pharmacyfair.model.exception.LicenseTypeNotFoundException;
import gamz.projects.pharmacyfair.model.exception.PharmaceuticalLicenseNotFoundException;
import gamz.projects.pharmacyfair.model.mapper.PharmaceuticalLicenseMapper;
import gamz.projects.pharmacyfair.model.request.PharmaceuticalLicenseRequest;
import gamz.projects.pharmacyfair.repository.LicenseCategoryRepository;
import gamz.projects.pharmacyfair.repository.LicenseTypeRepository;
import gamz.projects.pharmacyfair.repository.PharmaceuticalLicenseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PharmaceuticalLicenseServiceTest {

    @Mock
    private PharmaceuticalLicenseRepository pharmaceuticalLicenseRepository;

    @Mock
    private PharmaceuticalLicenseMapper pharmaceuticalLicenseMapper;

    @Mock
    private LicenseCategoryRepository licenseCategoryRepository;

    @Mock
    private LicenseTypeRepository licenseTypeRepository;

    @InjectMocks
    private PharmaceuticalLicenseService pharmaceuticalLicenseService;

    private PharmaceuticalLicense license;
    private PharmaceuticalLicenseDTO licenseDTO;
    private PharmaceuticalLicenseRequest licenseRequest;
    private LicenseCategory category;
    private LicenseType type;

    @BeforeEach
    void setUp() {
        license = new PharmaceuticalLicense();
        license.setId(1L);

        licenseDTO = new PharmaceuticalLicenseDTO();
        licenseDTO.setId(1L);

        licenseRequest = new PharmaceuticalLicenseRequest();
        licenseRequest.setLicenseCategoryId(1L);
        licenseRequest.setLicenseTypeId(1L);

        category = new LicenseCategory();
        category.setId(1L);

        type = new LicenseType();
        type.setId(1L);
    }

    @Test
    @DisplayName("Should return all licenses")
    void getAllLicenses() {
        // Arrange
        List<PharmaceuticalLicense> licenses = Collections.singletonList(license);
        when(pharmaceuticalLicenseRepository.findAll()).thenReturn(licenses);
        when(pharmaceuticalLicenseMapper.toPharmaceuticalLicenseDTO(any())).thenReturn(licenseDTO);

        // Act
        List<PharmaceuticalLicenseDTO> result = pharmaceuticalLicenseService.getAllLicenses();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(licenseDTO, result.getFirst());
        verify(pharmaceuticalLicenseRepository, times(1)).findAll();
        verify(pharmaceuticalLicenseMapper, times(1)).toPharmaceuticalLicenseDTO(any(PharmaceuticalLicense.class));
    }

    @Test
    @DisplayName("Should return license by ID")
    void getLicenseById() {
        // Arrange
        when(pharmaceuticalLicenseRepository.findById(1L)).thenReturn(Optional.of(license));
        when(pharmaceuticalLicenseMapper.toPharmaceuticalLicenseDTO(license)).thenReturn(licenseDTO);

        // Act
        PharmaceuticalLicenseDTO result = pharmaceuticalLicenseService.getLicenseById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(licenseDTO, result);
        verify(pharmaceuticalLicenseRepository, times(1)).findById(1L);
        verify(pharmaceuticalLicenseMapper, times(1)).toPharmaceuticalLicenseDTO(any(PharmaceuticalLicense.class));
    }

    @Test
    @DisplayName("Should throw exception when ID not found")
    void getLicenseById_NotFound() {
        // Arrange
        Long wrongId = 999L;
        when(pharmaceuticalLicenseRepository.findById(wrongId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(PharmaceuticalLicenseNotFoundException.class,
                () -> pharmaceuticalLicenseService.getLicenseById(wrongId));
        verify(pharmaceuticalLicenseRepository, times(1)).findById(wrongId);
        verify(pharmaceuticalLicenseMapper, never()).toPharmaceuticalLicenseDTO(any(PharmaceuticalLicense.class));
    }

    @Test
    @DisplayName("Should return license list related to License Type ID")
    void getLicenseByTypeId() {
        // Arrange
        List<PharmaceuticalLicense> licenses = Collections.singletonList(license);
        when(licenseTypeRepository.existsById(1L)).thenReturn(true);
        when(pharmaceuticalLicenseRepository.findByLicenseTypeId(1L)).thenReturn(licenses);
        when(pharmaceuticalLicenseMapper.toPharmaceuticalLicenseDTO(any())).thenReturn(licenseDTO);

        // Act
        List<PharmaceuticalLicenseDTO> result = pharmaceuticalLicenseService.getLicenseByTypeId(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(licenseDTO, result.getFirst());
        verify(licenseTypeRepository, times(1)).existsById(1L);
        verify(pharmaceuticalLicenseRepository, times(1)).findByLicenseTypeId(1L);
        verify(pharmaceuticalLicenseMapper, times(1)).toPharmaceuticalLicenseDTO(any(PharmaceuticalLicense.class));
    }

    @Test
    @DisplayName("Should return exception if Type ID not found")
    void getLicenseByTypeId_TypeNotFound() {
        // Arrange
        when(licenseTypeRepository.existsById(1L)).thenReturn(false);

        // Act & Assert
        assertThrows(LicenseTypeNotFoundException.class,
                () -> pharmaceuticalLicenseService.getLicenseByTypeId(1L));

        verify(licenseTypeRepository, times(1)).existsById(1L);
        verify(pharmaceuticalLicenseRepository, never()).findByLicenseTypeId(1L);
        verify(pharmaceuticalLicenseMapper, never()).toPharmaceuticalLicenseDTO(any(PharmaceuticalLicense.class));
    }

    @Test
    @DisplayName("Should create license")
    void createLicense() {
        // Arrange
        when(licenseCategoryRepository.findById(1L)).thenReturn(Optional.of(category));
        when(licenseTypeRepository.findById(1L)).thenReturn(Optional.of(type));
        when(pharmaceuticalLicenseMapper.toPharmaceuticalLicenseFromRequest(licenseRequest)).thenReturn(license);
        when(pharmaceuticalLicenseRepository.save(any(PharmaceuticalLicense.class))).thenReturn(license);
        when(pharmaceuticalLicenseMapper.toPharmaceuticalLicenseDTO(license)).thenReturn(licenseDTO);

        // Act
        PharmaceuticalLicenseDTO result = pharmaceuticalLicenseService.createLicense(licenseRequest);

        // Assert
        assertNotNull(result);
        assertEquals(licenseDTO, result);
        verify(licenseCategoryRepository, times(1)).findById(1L);
        verify(licenseTypeRepository, times(1)).findById(1L);
        verify(pharmaceuticalLicenseMapper, times(1))
                .toPharmaceuticalLicenseFromRequest(any(PharmaceuticalLicenseRequest.class));
        verify(pharmaceuticalLicenseRepository).save(any(PharmaceuticalLicense.class));
        verify(pharmaceuticalLicenseMapper, times(1)).toPharmaceuticalLicenseDTO(any(PharmaceuticalLicense.class));
    }

    @Test
    @DisplayName("Should edit license")
    void editLicense() {
        // Arrange
        when(pharmaceuticalLicenseRepository.findById(1L)).thenReturn(Optional.of(license));
        when(licenseCategoryRepository.findById(1L)).thenReturn(Optional.of(category));
        when(licenseTypeRepository.findById(1L)).thenReturn(Optional.of(type));
        when(pharmaceuticalLicenseRepository.save(any(PharmaceuticalLicense.class))).thenReturn(license);
        when(pharmaceuticalLicenseMapper.toPharmaceuticalLicenseDTO(license)).thenReturn(licenseDTO);

        // Act
        PharmaceuticalLicenseDTO result = pharmaceuticalLicenseService.editLicense(1L, licenseRequest);

        // Assert
        assertNotNull(result);
        assertEquals(licenseDTO, result);
        verify(pharmaceuticalLicenseRepository, times(1)).findById(1L);
        verify(licenseCategoryRepository, times(1)).findById(1L);
        verify(licenseTypeRepository, times(1)).findById(1L);
        verify(pharmaceuticalLicenseRepository, times(1)).save(any(PharmaceuticalLicense.class));
        verify(pharmaceuticalLicenseMapper, times(1)).toPharmaceuticalLicenseDTO(any(PharmaceuticalLicense.class));
    }

    @Test
    @DisplayName("Should throw exception when license ID not found")
    void editLicense_NotFoundLicenseId() {
        // Arrange
        Long nonExistentId = 999L;
        when(pharmaceuticalLicenseRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(
                PharmaceuticalLicenseNotFoundException.class,
                () -> pharmaceuticalLicenseService.editLicense(nonExistentId, licenseRequest)
        );

        verify(pharmaceuticalLicenseRepository, times(1)).findById(nonExistentId);
        verify(licenseCategoryRepository, never()).findById(any());
        verify(licenseTypeRepository, never()).findById(any());
        verify(pharmaceuticalLicenseRepository, never()).save(any(PharmaceuticalLicense.class));
        verify(pharmaceuticalLicenseMapper, never()).toPharmaceuticalLicenseDTO(any(PharmaceuticalLicense.class));
    }

    @Test
    @DisplayName("Should throw exception when category ID not found")
    void editLicense_NotFoundCategoryId() {
        // Arrange
        Long nonExistentCategoryId = 999L;
        licenseRequest.setLicenseCategoryId(nonExistentCategoryId);

        when(pharmaceuticalLicenseRepository.findById(1L)).thenReturn(Optional.of(license));
        when(licenseCategoryRepository.findById(nonExistentCategoryId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(
                LicenseCategoryNotFoundException.class,
                () -> pharmaceuticalLicenseService.editLicense(1L, licenseRequest)
        );

        verify(pharmaceuticalLicenseRepository, times(1)).findById(1L);
        verify(licenseCategoryRepository, times(1)).findById(nonExistentCategoryId);
        verify(licenseTypeRepository, never()).findById(any());
        verify(pharmaceuticalLicenseRepository, never()).save(any(PharmaceuticalLicense.class));
        verify(pharmaceuticalLicenseMapper, never()).toPharmaceuticalLicenseDTO(any(PharmaceuticalLicense.class));
    }

    @Test
    @DisplayName("Should throw exception when type ID not found")
    void editLicense_WhenLicenseTypeNotFound_ShouldThrowException() {
        // Arrange
        Long nonExistentTypeId = 999L;
        licenseRequest.setLicenseTypeId(nonExistentTypeId);

        when(pharmaceuticalLicenseRepository.findById(1L)).thenReturn(Optional.of(license));
        when(licenseCategoryRepository.findById(1L)).thenReturn(Optional.of(category));
        when(licenseTypeRepository.findById(nonExistentTypeId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(
                LicenseTypeNotFoundException.class,
                () -> pharmaceuticalLicenseService.editLicense(1L, licenseRequest)
        );

        verify(pharmaceuticalLicenseRepository, times(1)).findById(1L);
        verify(licenseCategoryRepository, times(1)).findById(1L);
        verify(licenseTypeRepository, times(1)).findById(nonExistentTypeId);
        verify(pharmaceuticalLicenseRepository, never()).save(any(PharmaceuticalLicense.class));
        verify(pharmaceuticalLicenseMapper, never()).toPharmaceuticalLicenseDTO(any(PharmaceuticalLicense.class));
    }

    @Test
    @DisplayName("Should delete license by ID")
    void deleteLicenseById() {
        // Arrange
        when(pharmaceuticalLicenseRepository.existsById(1L)).thenReturn(true);
        doNothing().when(pharmaceuticalLicenseRepository).deleteById(1L);

        // Act
        pharmaceuticalLicenseService.deleteLicenseById(1L);

        // Assert
        verify(pharmaceuticalLicenseRepository, times(1)).existsById(1L);
        verify(pharmaceuticalLicenseRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteLicenseById_WhenNotExists_ShouldThrowException() {
        // Arrange
        when(pharmaceuticalLicenseRepository.existsById(1L)).thenReturn(false);

        // Act & Assert
        assertThrows(PharmaceuticalLicenseNotFoundException.class,
                () -> pharmaceuticalLicenseService.deleteLicenseById(1L));
        verify(pharmaceuticalLicenseRepository, times(1)).existsById(1L);
        verify(pharmaceuticalLicenseRepository, never()).deleteById(1L);
    }
}