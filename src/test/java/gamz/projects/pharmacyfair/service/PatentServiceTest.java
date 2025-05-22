package gamz.projects.pharmacyfair.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import gamz.projects.pharmacyfair.model.dto.PatentDTO;
import gamz.projects.pharmacyfair.model.entity.Patent;
import gamz.projects.pharmacyfair.model.entity.PatentType;
import gamz.projects.pharmacyfair.model.entity.projects.Project;
import gamz.projects.pharmacyfair.model.exception.PatentNotFoundException;
import gamz.projects.pharmacyfair.model.exception.PatentTypeNotFoundException;
import gamz.projects.pharmacyfair.model.mapper.PatentMapper;
import gamz.projects.pharmacyfair.model.request.PatentRequest;
import gamz.projects.pharmacyfair.repository.PatentRepository;
import gamz.projects.pharmacyfair.repository.PatentTypeRepository;
import gamz.projects.pharmacyfair.repository.ProjectRepository;
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
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PatentServiceTest {
	
	@Mock
	private PatentRepository patentRepository;
	
	@Mock
	private PatentTypeRepository patentTypeRepository;
	
	@Mock
	private ProjectRepository projectRepository;
	
	@Mock
	private PatentMapper patentMapper;
	
	@InjectMocks
	private PatentService patentService;
	
	private Patent patent;
	private PatentDTO patentDTO;
	private PatentRequest patentRequest;
	private Project project;
	private PatentType patentType;
	
	@BeforeEach
	void setUp() {
		// Set up test data
		project = Project.builder()
				.id(1L)
				.name("Test Project")
				.build();
		
		patentType = PatentType.builder()
				.id(1L)
				.typeCode("TEST_CODE")
				.typeName("Test Patent Type")
				.build();
		
		patent = Patent.builder()
				.id(1L)
				.project(project)
				.patentType(patentType)
				.patentNumber("TEST-12345")
				.expiryDate(LocalDate.of(2030, 1, 1))
				.patentOwnerId(1L)
				.applicationNumber("APP-12345")
				.filingDate(LocalDate.of(2020, 1, 1))
				.applicantId(1L)
				.createdAt(LocalDateTime.now())
				.updatedAt(LocalDateTime.now())
				.build();
		
		patentDTO = PatentDTO.builder()
				.id(1L)
				.projectId(1L)
				.patentTypeId(1L)
				.patentNumber("TEST-12345")
				.expiryDate(LocalDate.of(2030, 1, 1))
				.patentOwnerId(1L)
				.applicationNumber("APP-12345")
				.filingDate(LocalDate.of(2020, 1, 1))
				.applicantId(1L)
				.build();
		
		patentRequest = new PatentRequest();
		patentRequest.setProjectId(1L);
		patentRequest.setPatentTypeId(1L);
		patentRequest.setPatentNumber("TEST-12345");
		patentRequest.setExpiryDate(LocalDate.of(2030, 1, 1));
		patentRequest.setPatentOwnerId(1L);
		patentRequest.setApplicationNumber("APP-12345");
		patentRequest.setFilingDate(LocalDate.of(2020, 1, 1));
		patentRequest.setApplicantId(1L);
	}
	
	@Test
	@DisplayName("Should return all patents")
	void getAllPatents() {
		// Arrange
		List<Patent> patents = Collections.singletonList(patent);
		when(patentRepository.findAll()).thenReturn(patents);
		when(patentMapper.toPatentDTO(any(Patent.class))).thenReturn(patentDTO);
		
		// Act
		List<PatentDTO> result = patentService.getAllPatents();
		
		// Assert
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(patentDTO, result.getFirst());
		verify(patentRepository, times(1)).findAll();
		verify(patentMapper, times(1)).toPatentDTO(any(Patent.class));
	}
	
	@Test
	@DisplayName("Should return patent by ID")
	void getPatentById() {
		// Arrange
		when(patentRepository.findById(1L)).thenReturn(Optional.of(patent));
		when(patentMapper.toPatentDTO(patent)).thenReturn(patentDTO);
		
		// Act
		PatentDTO result = patentService.getPatentById(1L);
		
		// Assert
		assertNotNull(result);
		assertEquals(patentDTO, result);
		verify(patentRepository, times(1)).findById(1L);
		verify(patentMapper, times(1)).toPatentDTO(patent);
	}
	
	@Test
	@DisplayName("Should throw exception when patent ID not found")
	void getPatentById_NotFound() {
		// Arrange
		when(patentRepository.findById(1L)).thenReturn(Optional.empty());
		
		// Act & Assert
		assertThrows(PatentNotFoundException.class, () -> patentService.getPatentById(1L));
		verify(patentRepository, times(1)).findById(1L);
		verify(patentMapper, never()).toPatentDTO(any(Patent.class));
	}
	
	@Test
	@DisplayName("Should return patents by project ID")
	void getPatentsByProjectId() {
		// Arrange
		Long projectId = 1L;
		List<Patent> patents = Collections.singletonList(patent);
		when(patentRepository.findByProjectId(projectId)).thenReturn(patents);
		when(patentMapper.toPatentDTO(any(Patent.class))).thenReturn(patentDTO);
		
		// Act
		List<PatentDTO> result = patentService.getPatentsByProjectId(projectId);
		
		// Assert
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(patentDTO, result.getFirst());
		verify(patentRepository, times(1)).findByProjectId(projectId);
		verify(patentMapper, times(1)).toPatentDTO(any(Patent.class));
	}
	
	@Test
	@DisplayName("Should return patents by patent type ID")
	void getPatentsByPatentTypeId() {
		// Arrange
		Long patentTypeId = 1L;
		List<Patent> patents = Collections.singletonList(patent);
		when(patentRepository.findByPatentTypeId(patentTypeId)).thenReturn(patents);
		when(patentMapper.toPatentDTO(any(Patent.class))).thenReturn(patentDTO);
		
		// Act
		List<PatentDTO> result = patentService.getPatentsByPatentTypeId(patentTypeId);
		
		// Assert
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(patentDTO, result.getFirst());
		verify(patentRepository, times(1)).findByPatentTypeId(patentTypeId);
		verify(patentMapper, times(1)).toPatentDTO(any(Patent.class));
	}
	
	@Test
	@DisplayName("Should create new patent")
	void createPatent() {
		// Arrange
		when(patentMapper.toPatentFromRequest(patentRequest)).thenReturn(patent);
		when(projectRepository.findById(1L)).thenReturn(Optional.of(project));
		when(patentTypeRepository.findById(1L)).thenReturn(Optional.of(patentType));
		when(patentRepository.save(any(Patent.class))).thenReturn(patent);
		when(patentMapper.toPatentDTO(patent)).thenReturn(patentDTO);
		
		// Act
		PatentDTO result = patentService.createPatent(patentRequest);
		
		// Assert
		assertNotNull(result);
		assertEquals(patentDTO, result);
		verify(patentMapper, times(1)).toPatentFromRequest(patentRequest);
		verify(projectRepository, times(1)).findById(1L);
		verify(patentTypeRepository, times(1)).findById(1L);
		verify(patentRepository, times(1)).save(any(Patent.class));
		verify(patentMapper, times(1)).toPatentDTO(patent);
	}
	
	@Test
	@DisplayName("Should throw exception when creating patent with non-existent project")
	void createPatent_ProjectNotFound() {
		// Arrange
		when(patentMapper.toPatentFromRequest(patentRequest)).thenReturn(patent);
		when(projectRepository.findById(1L)).thenReturn(Optional.empty());
		
		// Act & Assert
		assertThrows(RuntimeException.class, () -> patentService.createPatent(patentRequest));
		verify(patentMapper, times(1)).toPatentFromRequest(patentRequest);
		verify(projectRepository, times(1)).findById(1L);
		verify(patentTypeRepository, never()).findById(anyLong());
		verify(patentRepository, never()).save(any(Patent.class));
	}
	
	@Test
	@DisplayName("Should throw exception when creating patent with non-existent patent type")
	void createPatent_PatentTypeNotFound() {
		// Arrange
		when(patentMapper.toPatentFromRequest(patentRequest)).thenReturn(patent);
		when(projectRepository.findById(1L)).thenReturn(Optional.of(project));
		when(patentTypeRepository.findById(1L)).thenReturn(Optional.empty());
		
		// Act & Assert
		assertThrows(PatentTypeNotFoundException.class, () -> patentService.createPatent(patentRequest));
		verify(patentMapper, times(1)).toPatentFromRequest(patentRequest);
		verify(projectRepository, times(1)).findById(1L);
		verify(patentTypeRepository, times(1)).findById(1L);
		verify(patentRepository, never()).save(any(Patent.class));
	}
	
	@Test
	@DisplayName("Should update patent")
	void updatePatent() {
		// Arrange
		Long id = 1L;
		PatentRequest updateRequest = new PatentRequest();
		updateRequest.setPatentNumber("UPDATED-12345");
		updateRequest.setExpiryDate(LocalDate.of(2035, 1, 1));
		
		Patent existingPatent = Patent.builder()
				.id(id)
				.project(project)
				.patentType(patentType)
				.patentNumber("TEST-12345")
				.expiryDate(LocalDate.of(2030, 1, 1))
				.build();
		
		Patent updatedPatent = Patent.builder()
				.id(id)
				.project(project)
				.patentType(patentType)
				.patentNumber("UPDATED-12345")
				.expiryDate(LocalDate.of(2035, 1, 1))
				.build();
		
		PatentDTO updatedDTO = PatentDTO.builder()
				.id(id)
				.projectId(1L)
				.patentTypeId(1L)
				.patentNumber("UPDATED-12345")
				.expiryDate(LocalDate.of(2035, 1, 1))
				.build();
		
		when(patentRepository.findById(id)).thenReturn(Optional.of(existingPatent));
		when(patentRepository.save(any(Patent.class))).thenReturn(updatedPatent);
		when(patentMapper.toPatentDTO(updatedPatent)).thenReturn(updatedDTO);
		
		// Act
		PatentDTO result = patentService.updatePatent(id, updateRequest);
		
		// Assert
		assertNotNull(result);
		assertEquals(updatedDTO, result);
		verify(patentRepository, times(1)).findById(id);
		verify(patentRepository, times(1)).save(any(Patent.class));
		verify(patentMapper, times(1)).toPatentDTO(updatedPatent);
	}
	
	@Test
	@DisplayName("Should throw exception when updating non-existent patent")
	void updatePatent_NotFound() {
		// Arrange
		Long id = 999L;
		when(patentRepository.findById(id)).thenReturn(Optional.empty());
		
		// Act & Assert
		assertThrows(PatentNotFoundException.class, () -> patentService.updatePatent(id, patentRequest));
		verify(patentRepository, times(1)).findById(id);
		verify(patentRepository, never()).save(any(Patent.class));
	}
	
	@Test
	@DisplayName("Should delete patent")
	void deletePatent() {
		// Arrange
		Long id = 1L;
		when(patentRepository.existsById(id)).thenReturn(true);
		doNothing().when(patentRepository).deleteById(id);
		
		// Act
		patentService.deletePatent(id);
		
		// Assert
		verify(patentRepository, times(1)).existsById(id);
		verify(patentRepository, times(1)).deleteById(id);
	}
	
	@Test
	@DisplayName("Should throw exception when deleting non-existent patent")
	void deletePatent_NotFound() {
		// Arrange
		Long id = 999L;
		when(patentRepository.existsById(id)).thenReturn(false);
		
		// Act & Assert
		assertThrows(PatentNotFoundException.class, () -> patentService.deletePatent(id));
		verify(patentRepository, times(1)).existsById(id);
		verify(patentRepository, never()).deleteById(id);
	}
}