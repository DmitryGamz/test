package gamz.projects.pharmacyfair.service;

import gamz.projects.pharmacyfair.model.dto.LicenseTypeDTO;
import gamz.projects.pharmacyfair.model.entity.LicenseType;
import gamz.projects.pharmacyfair.model.exception.LicenseTypeNotFoundException;
import gamz.projects.pharmacyfair.model.mapper.LicenseTypeMapper;
import gamz.projects.pharmacyfair.model.request.LicenseTypeRequest;
import gamz.projects.pharmacyfair.repository.LicenseTypeRepository;
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
class LicenseTypeServiceTest {

    @Mock
    private LicenseTypeRepository licenseTypeRepository;

    @Mock
    private LicenseTypeMapper licenseTypeMapper;

    @InjectMocks
    private LicenseTypeService licenseTypeService;

    private LicenseType licenseType;
    private LicenseTypeDTO licenseTypeDTO;
    private LicenseTypeRequest licenseTypeRequest;

    @BeforeEach
    void setUp() {
        licenseType = new LicenseType();
        licenseType.setId(1L);
        licenseType.setTypeName("Test License Type");

        licenseTypeDTO = new LicenseTypeDTO();
        licenseTypeDTO.setId(1L);
        licenseTypeDTO.setTypeName("Test License Type");

        licenseTypeRequest = new LicenseTypeRequest();
        licenseTypeRequest.setTypeName("Test License Type");
    }

    @Test
    @DisplayName("Should return all license types")
    void getAllLicenseTypes() {
        // Arrange
        List<LicenseType> licenseTypes = Collections.singletonList(licenseType);
        when(licenseTypeRepository.findAll()).thenReturn(licenseTypes);
        when(licenseTypeMapper.ToLicenseTypeDTO(any(LicenseType.class))).thenReturn(licenseTypeDTO);

        // Act
        List<LicenseTypeDTO> result = licenseTypeService.getAllLicenseTypes();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(licenseTypeDTO, result.getFirst());
        verify(licenseTypeRepository, times(1)).findAll();
        verify(licenseTypeMapper, times(1)).ToLicenseTypeDTO(any(LicenseType.class));
    }

    @Test
    @DisplayName("Should return license type by ID")
    void getLicenseById() {
        // Arrange
        when(licenseTypeRepository.findById(1L)).thenReturn(Optional.of(licenseType));
        when(licenseTypeMapper.ToLicenseTypeDTO(licenseType)).thenReturn(licenseTypeDTO);

        // Act
        LicenseTypeDTO result = licenseTypeService.getLicenseById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(licenseTypeDTO, result);
        verify(licenseTypeRepository, times(1)).findById(1L);
        verify(licenseTypeMapper, times(1)).ToLicenseTypeDTO(licenseType);
    }

    @Test
    @DisplayName("Should throw exception when license type ID not found")
    void getLicenseById_NotFound() {
        // Arrange
        Long nonExistentId = 999L;
        when(licenseTypeRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(LicenseTypeNotFoundException.class,
                () -> licenseTypeService.getLicenseById(nonExistentId));
        verify(licenseTypeRepository, times(1)).findById(nonExistentId);
        verify(licenseTypeMapper, never()).ToLicenseTypeDTO(any(LicenseType.class));
    }

    @Test
    @DisplayName("Should create license type")
    void createLicense() {
        // Arrange
        when(licenseTypeMapper.FromLicenseTypeRequest(licenseTypeRequest)).thenReturn(licenseType);
        when(licenseTypeRepository.save(any(LicenseType.class))).thenReturn(licenseType);
        when(licenseTypeMapper.ToLicenseTypeDTO(licenseType)).thenReturn(licenseTypeDTO);

        // Act
        LicenseTypeDTO result = licenseTypeService.createLicense(licenseTypeRequest);

        // Assert
        assertNotNull(result);
        assertEquals(licenseTypeDTO, result);
        verify(licenseTypeMapper, times(1)).FromLicenseTypeRequest(licenseTypeRequest);
        verify(licenseTypeRepository, times(1)).save(any(LicenseType.class));
        verify(licenseTypeMapper, times(1)).ToLicenseTypeDTO(licenseType);
    }

    @Test
    @DisplayName("Should edit license type")
    void editLicenseById() {
        // Arrange
        when(licenseTypeRepository.findById(1L)).thenReturn(Optional.of(licenseType));
        when(licenseTypeRepository.save(any(LicenseType.class))).thenReturn(licenseType);
        when(licenseTypeMapper.ToLicenseTypeDTO(licenseType)).thenReturn(licenseTypeDTO);

        // Act
        LicenseTypeDTO result = licenseTypeService.editLicenseById(1L, licenseTypeRequest);

        // Assert
        assertNotNull(result);
        assertEquals(licenseTypeDTO, result);
        verify(licenseTypeRepository, times(1)).findById(1L);
        verify(licenseTypeRepository, times(1)).save(any(LicenseType.class));
        verify(licenseTypeMapper, times(1)).ToLicenseTypeDTO(licenseType);
    }

    @Test
    @DisplayName("Should throw exception when editing non-existent license type")
    void editLicenseById_NotFound() {
        // Arrange
        Long nonExistentId = 999L;
        when(licenseTypeRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(LicenseTypeNotFoundException.class,
                () -> licenseTypeService.editLicenseById(nonExistentId, licenseTypeRequest));
        verify(licenseTypeRepository, times(1)).findById(nonExistentId);
        verify(licenseTypeRepository, never()).save(any());
        verify(licenseTypeMapper, never()).ToLicenseTypeDTO(any());
    }

    @Test
    @DisplayName("Should delete license type by ID")
    void deleteById() {
        // Arrange
        when(licenseTypeRepository.existsById(1L)).thenReturn(true);
        doNothing().when(licenseTypeRepository).deleteById(1L);

        // Act
        licenseTypeService.deleteById(1L);

        // Assert
        verify(licenseTypeRepository, times(1)).existsById(1L);
        verify(licenseTypeRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("Should throw exception when deleting non-existent license type")
    void deleteById_NotFound() {
        // Arrange
        Long nonExistentId = 999L;
        when(licenseTypeRepository.existsById(nonExistentId)).thenReturn(false);

        // Act & Assert
        assertThrows(LicenseTypeNotFoundException.class,
                () -> licenseTypeService.deleteById(nonExistentId));
        verify(licenseTypeRepository, times(1)).existsById(nonExistentId);
        verify(licenseTypeRepository, never()).deleteById(any());
    }
}