package gamz.projects.pharmacyfair.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import gamz.projects.pharmacyfair.model.dto.PatentTypeDTO;
import gamz.projects.pharmacyfair.model.entity.PatentType;
import gamz.projects.pharmacyfair.model.exception.PatentTypeNotFoundException;
import gamz.projects.pharmacyfair.model.mapper.PatentTypeMapper;
import gamz.projects.pharmacyfair.model.request.PatentTypeRequest;
import gamz.projects.pharmacyfair.repository.PatentTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PatentTypeServiceTest {
	
	@Mock
	private PatentTypeRepository patentTypeRepository;
	
	@Mock
	private PatentTypeMapper patentTypeMapper;
	
	@InjectMocks
	private PatentTypeService patentTypeService;
	
	private PatentType patentType;
	private PatentTypeDTO patentTypeDTO;
	private PatentTypeRequest patentTypeRequest;
	
	@BeforeEach
	void setUp() {
		// Set up test data
		patentType = PatentType.builder()
				.id(1L)
				.typeCode("TEST_CODE")
				.typeName("Test Patent Type")
				.description("Test Description")
				.build();
		
		patentTypeDTO = PatentTypeDTO.builder()
				.id(1L)
				.typeCode("TEST_CODE")
				.typeName("Test Patent Type")
				.description("Test Description")
				.build();
		
		patentTypeRequest = new PatentTypeRequest();
		patentTypeRequest.setTypeCode("TEST_CODE");
		patentTypeRequest.setTypeName("Test Patent Type");
		patentTypeRequest.setDescription("Test Description");
	}
	
	@Test
	@DisplayName("Should return all patent types")
	void getAllPatentTypes() {
		// Arrange
		List<PatentType> patentTypes = Collections.singletonList(patentType);
		when(patentTypeRepository.findAll()).thenReturn(patentTypes);
		when(patentTypeMapper.toPatentTypeDTO(any(PatentType.class))).thenReturn(patentTypeDTO);
		
		// Act
		List<PatentTypeDTO> result = patentTypeService.getAllPatentTypes();
		
		// Assert
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(patentTypeDTO, result.getFirst());
		verify(patentTypeRepository, times(1)).findAll();
		verify(patentTypeMapper, times(1)).toPatentTypeDTO(any(PatentType.class));
	}
	
	@Test
	@DisplayName("Should return patent type by ID")
	void getPatentTypeById() {
		// Arrange
		when(patentTypeRepository.findById(1L)).thenReturn(Optional.of(patentType));
		when(patentTypeMapper.toPatentTypeDTO(patentType)).thenReturn(patentTypeDTO);
		
		// Act
		PatentTypeDTO result = patentTypeService.getPatentTypeById(1L);
		
		// Assert
		assertNotNull(result);
		assertEquals(patentTypeDTO, result);
		verify(patentTypeRepository, times(1)).findById(1L);
		verify(patentTypeMapper, times(1)).toPatentTypeDTO(patentType);
	}
	
	@Test
	@DisplayName("Should throw exception when patent type ID not found")
	void getPatentTypeById_NotFound() {
		// Arrange
		when(patentTypeRepository.findById(1L)).thenReturn(Optional.empty());
		
		// Act & Assert
		assertThrows(PatentTypeNotFoundException.class, () -> patentTypeService.getPatentTypeById(1L));
		verify(patentTypeRepository, times(1)).findById(1L);
		verify(patentTypeMapper, never()).toPatentTypeDTO(any(PatentType.class));
	}
	
	@Test
	@DisplayName("Should return patent type by type code")
	void getPatentTypeByTypeCode() {
		// Arrange
		String typeCode = "TEST_CODE";
		when(patentTypeRepository.findByTypeCode(typeCode)).thenReturn(Optional.of(patentType));
		when(patentTypeMapper.toPatentTypeDTO(patentType)).thenReturn(patentTypeDTO);
		
		// Act
		PatentTypeDTO result = patentTypeService.getPatentTypeByTypeCode(typeCode);
		
		// Assert
		assertNotNull(result);
		assertEquals(patentTypeDTO, result);
		verify(patentTypeRepository, times(1)).findByTypeCode(typeCode);
		verify(patentTypeMapper, times(1)).toPatentTypeDTO(patentType);
	}
	
	@Test
	@DisplayName("Should throw exception when type code not found")
	void getPatentTypeByTypeCode_NotFound() {
		// Arrange
		String typeCode = "NONEXISTENT_CODE";
		when(patentTypeRepository.findByTypeCode(typeCode)).thenReturn(Optional.empty());
		
		// Act & Assert
		assertThrows(PatentTypeNotFoundException.class, () -> patentTypeService.getPatentTypeByTypeCode(typeCode));
		verify(patentTypeRepository, times(1)).findByTypeCode(typeCode);
		verify(patentTypeMapper, never()).toPatentTypeDTO(any(PatentType.class));
	}
	
	@Test
	@DisplayName("Should return patent type by name")
	void getPatentTypeByTypeName() {
		// Arrange
		String typeName = "Test Patent Type";
		when(patentTypeRepository.findByTypeName(typeName)).thenReturn(Optional.of(patentType));
		when(patentTypeMapper.toPatentTypeDTO(patentType)).thenReturn(patentTypeDTO);
		
		// Act
		PatentTypeDTO result = patentTypeService.getPatentTypeByTypeName(typeName);
		
		// Assert
		assertNotNull(result);
		assertEquals(patentTypeDTO, result);
		verify(patentTypeRepository, times(1)).findByTypeName(typeName);
		verify(patentTypeMapper, times(1)).toPatentTypeDTO(patentType);
	}
	
	@Test
	@DisplayName("Should create new patent type")
	void createPatentType() {
		// Arrange
		when(patentTypeMapper.toPatentTypeFromRequest(patentTypeRequest)).thenReturn(patentType);
		when(patentTypeRepository.save(patentType)).thenReturn(patentType);
		when(patentTypeMapper.toPatentTypeDTO(patentType)).thenReturn(patentTypeDTO);
		
		// Act
		PatentTypeDTO result = patentTypeService.createPatentType(patentTypeRequest);
		
		// Assert
		assertNotNull(result);
		assertEquals(patentTypeDTO, result);
		verify(patentTypeMapper, times(1)).toPatentTypeFromRequest(patentTypeRequest);
		verify(patentTypeRepository, times(1)).save(patentType);
		verify(patentTypeMapper, times(1)).toPatentTypeDTO(patentType);
	}
	
	@Test
	@DisplayName("Should update patent type")
	void updatePatentType() {
		// Arrange
		Long id = 1L;
		PatentTypeRequest updateRequest = new PatentTypeRequest();
		updateRequest.setTypeCode("UPDATED_CODE");
		updateRequest.setTypeName("Updated Type Name");
		updateRequest.setDescription("Updated Description");
		
		PatentType updatedPatentType = PatentType.builder()
				.id(id)
				.typeCode("UPDATED_CODE")
				.typeName("Updated Type Name")
				.description("Updated Description")
				.build();
		
		PatentTypeDTO updatedDTO = PatentTypeDTO.builder()
				.id(id)
				.typeCode("UPDATED_CODE")
				.typeName("Updated Type Name")
				.description("Updated Description")
				.build();
		
		when(patentTypeRepository.findById(id)).thenReturn(Optional.of(patentType));
		when(patentTypeRepository.save(any(PatentType.class))).thenReturn(updatedPatentType);
		when(patentTypeMapper.toPatentTypeDTO(updatedPatentType)).thenReturn(updatedDTO);
		
		// Act
		PatentTypeDTO result = patentTypeService.updatePatentType(id, updateRequest);
		
		// Assert
		assertNotNull(result);
		assertEquals(updatedDTO, result);
		verify(patentTypeRepository, times(1)).findById(id);
		verify(patentTypeRepository, times(1)).save(any(PatentType.class));
		verify(patentTypeMapper, times(1)).toPatentTypeDTO(updatedPatentType);
	}
	
	@Test
	@DisplayName("Should throw exception when updating non-existent patent type")
	void updatePatentType_NotFound() {
		// Arrange
		Long id = 999L;
		when(patentTypeRepository.findById(id)).thenReturn(Optional.empty());
		
		// Act & Assert
		assertThrows(PatentTypeNotFoundException.class, () -> patentTypeService.updatePatentType(id, patentTypeRequest));
		verify(patentTypeRepository, times(1)).findById(id);
		verify(patentTypeRepository, never()).save(any(PatentType.class));
	}
	
	@Test
	@DisplayName("Should delete patent type")
	void deletePatentType() {
		// Arrange
		Long id = 1L;
		when(patentTypeRepository.existsById(id)).thenReturn(true);
		doNothing().when(patentTypeRepository).deleteById(id);
		
		// Act
		patentTypeService.deletePatentType(id);
		
		// Assert
		verify(patentTypeRepository, times(1)).existsById(id);
		verify(patentTypeRepository, times(1)).deleteById(id);
	}
	
	@Test
	@DisplayName("Should throw exception when deleting non-existent patent type")
	void deletePatentType_NotFound() {
		// Arrange
		Long id = 999L;
		when(patentTypeRepository.existsById(id)).thenReturn(false);
		
		// Act & Assert
		assertThrows(PatentTypeNotFoundException.class, () -> patentTypeService.deletePatentType(id));
		verify(patentTypeRepository, times(1)).existsById(id);
		verify(patentTypeRepository, never()).deleteById(id);
	}
}