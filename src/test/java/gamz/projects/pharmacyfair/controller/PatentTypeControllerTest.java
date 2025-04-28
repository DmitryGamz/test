package gamz.projects.pharmacyfair.controller;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import gamz.projects.pharmacyfair.configuration.TestSecurityConfig;
import gamz.projects.pharmacyfair.model.dto.PatentTypeDTO;
import gamz.projects.pharmacyfair.model.exception.PatentTypeNotFoundException;
import gamz.projects.pharmacyfair.model.request.PatentTypeRequest;
import gamz.projects.pharmacyfair.service.PatentTypeService;
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
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PatentTypeController.class)
@Import({TestSecurityConfig.class, TestGlobalExceptionHandler.class})
class PatentTypeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockitoBean
	private PatentTypeService patentTypeService;
	
	private PatentTypeDTO patentTypeDTO;
	private PatentTypeRequest patentTypeRequest;
	
	@BeforeEach
	void setUp() {
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
	@WithMockUser(roles = "USER")
	@DisplayName("Should return all patent types")
	void getAllPatentTypes() throws Exception {
		// Arrange
		List<PatentTypeDTO> patentTypes = Arrays.asList(patentTypeDTO);
		when(patentTypeService.getAllPatentTypes()).thenReturn(patentTypes);
		
		// Act & Assert
		mockMvc.perform(get("/api/v1/patent-types")
						.contentType(MediaType.APPLICATION_JSON))
				.andDo(print()) // Print request/response for debugging
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].typeCode", is("TEST_CODE")))
				.andExpect(jsonPath("$[0].typeName", is("Test Patent Type")))
				.andExpect(jsonPath("$[0].description", is("Test Description")));
		
		verify(patentTypeService, times(1)).getAllPatentTypes();
	}
	
	@Test
	@WithMockUser(roles = "USER")
	@DisplayName("Should return patent type by ID")
	void getPatentTypeById() throws Exception {
		// Arrange
		when(patentTypeService.getPatentTypeById(1L)).thenReturn(patentTypeDTO);
		
		// Act & Assert
		mockMvc.perform(get("/api/v1/patent-types/1")
						.contentType(MediaType.APPLICATION_JSON))
				.andDo(print()) // Print request/response for debugging
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.typeCode", is("TEST_CODE")))
				.andExpect(jsonPath("$.typeName", is("Test Patent Type")))
				.andExpect(jsonPath("$.description", is("Test Description")));
		
		verify(patentTypeService, times(1)).getPatentTypeById(1L);
	}
	
	@Test
	@WithMockUser(roles = "USER")
	@DisplayName("Should return 404 when patent type ID not found")
	void getPatentTypeById_NotFound() throws Exception {
		// Arrange
		when(patentTypeService.getPatentTypeById(999L))
				.thenThrow(new PatentTypeNotFoundException("Patent type not found"));
		
		// Act & Assert
		mockMvc.perform(get("/api/v1/patent-types/999")
						.contentType(MediaType.APPLICATION_JSON))
				.andDo(print()) // Print request/response for debugging
				.andExpect(status().isNotFound());
		
		verify(patentTypeService, times(1)).getPatentTypeById(999L);
	}
	
	@Test
	@WithMockUser(roles = "USER")
	@DisplayName("Should return patent type by code")
	void getPatentTypeByCode() throws Exception {
		// Arrange
		when(patentTypeService.getPatentTypeByTypeCode("TEST_CODE")).thenReturn(patentTypeDTO);
		
		// Act & Assert
		mockMvc.perform(get("/api/v1/patent-types/code/TEST_CODE")
						.contentType(MediaType.APPLICATION_JSON))
				.andDo(print()) // Print request/response for debugging
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.typeCode", is("TEST_CODE")))
				.andExpect(jsonPath("$.typeName", is("Test Patent Type")))
				.andExpect(jsonPath("$.description", is("Test Description")));
		
		verify(patentTypeService, times(1)).getPatentTypeByTypeCode("TEST_CODE");
	}
	
	@Test
	@WithMockUser(roles = "USER")
	@DisplayName("Should return patent type by name")
	void getPatentTypeByName() throws Exception {
		// Arrange
		when(patentTypeService.getPatentTypeByTypeName("Test Patent Type")).thenReturn(patentTypeDTO);
		
		// Act & Assert
		mockMvc.perform(get("/api/v1/patent-types/name/Test Patent Type")
						.contentType(MediaType.APPLICATION_JSON))
				.andDo(print()) // Print request/response for debugging
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.typeCode", is("TEST_CODE")))
				.andExpect(jsonPath("$.typeName", is("Test Patent Type")))
				.andExpect(jsonPath("$.description", is("Test Description")));
		
		verify(patentTypeService, times(1)).getPatentTypeByTypeName("Test Patent Type");
	}
	
	@Test
	@WithMockUser(roles = "USER")
	@DisplayName("Should create new patent type")
	void createPatentType() throws Exception {
		// Arrange
		when(patentTypeService.createPatentType(any(PatentTypeRequest.class))).thenReturn(patentTypeDTO);
		
		// Act & Assert
		mockMvc.perform(post("/api/v1/patent-types")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(patentTypeRequest)))
				.andDo(print()) // Print request/response for debugging
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.typeCode", is("TEST_CODE")))
				.andExpect(jsonPath("$.typeName", is("Test Patent Type")))
				.andExpect(jsonPath("$.description", is("Test Description")));
		
		verify(patentTypeService, times(1)).createPatentType(any(PatentTypeRequest.class));
	}
	
	@Test
	@WithMockUser(roles = "USER")
	@DisplayName("Should update patent type")
	void updatePatentType() throws Exception {
		// Arrange
		PatentTypeDTO updatedDTO = PatentTypeDTO.builder()
				.id(1L)
				.typeCode("UPDATED_CODE")
				.typeName("Updated Type Name")
				.description("Updated Description")
				.build();
		
		PatentTypeRequest updateRequest = new PatentTypeRequest();
		updateRequest.setTypeCode("UPDATED_CODE");
		updateRequest.setTypeName("Updated Type Name");
		updateRequest.setDescription("Updated Description");
		
		when(patentTypeService.updatePatentType(eq(1L), any(PatentTypeRequest.class))).thenReturn(updatedDTO);
		
		// Act & Assert
		mockMvc.perform(put("/api/v1/patent-types/1")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(updateRequest)))
				.andDo(print()) // Print request/response for debugging
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.typeCode", is("UPDATED_CODE")))
				.andExpect(jsonPath("$.typeName", is("Updated Type Name")))
				.andExpect(jsonPath("$.description", is("Updated Description")));
		
		verify(patentTypeService, times(1)).updatePatentType(eq(1L), any(PatentTypeRequest.class));
	}
	
	@Test
	@WithMockUser(roles = "USER")
	@DisplayName("Should return 404 when updating non-existent patent type")
	void updatePatentType_NotFound() throws Exception {
		// Arrange
		when(patentTypeService.updatePatentType(eq(999L), any(PatentTypeRequest.class)))
				.thenThrow(new PatentTypeNotFoundException("Patent type not found"));
		
		// Act & Assert
		mockMvc.perform(put("/api/v1/patent-types/999")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(patentTypeRequest)))
				.andDo(print()) // Print request/response for debugging
				.andExpect(status().isNotFound());
		
		verify(patentTypeService, times(1)).updatePatentType(eq(999L), any(PatentTypeRequest.class));
	}
	
	@Test
	@WithMockUser(roles = "USER")
	@DisplayName("Should delete patent type")
	void deletePatentType() throws Exception {
		// Arrange
		doNothing().when(patentTypeService).deletePatentType(1L);
		
		// Act & Assert
		mockMvc.perform(delete("/api/v1/patent-types/1")
						.contentType(MediaType.APPLICATION_JSON))
				.andDo(print()) // Print request/response for debugging
				.andExpect(status().isNoContent());
		
		verify(patentTypeService, times(1)).deletePatentType(1L);
	}
	
	@Test
	@WithMockUser(roles = "USER")
	@DisplayName("Should return 404 when deleting non-existent patent type")
	void deletePatentType_NotFound() throws Exception {
		// Arrange
		doThrow(new PatentTypeNotFoundException("Patent type not found"))
				.when(patentTypeService).deletePatentType(999L);
		
		// Act & Assert
		mockMvc.perform(delete("/api/v1/patent-types/999")
						.contentType(MediaType.APPLICATION_JSON))
				.andDo(print()) // Print request/response for debugging
				.andExpect(status().isNotFound());
		
		verify(patentTypeService, times(1)).deletePatentType(999L);
	}
}