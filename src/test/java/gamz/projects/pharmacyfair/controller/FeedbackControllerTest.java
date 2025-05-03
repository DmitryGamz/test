package gamz.projects.pharmacyfair.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import gamz.projects.pharmacyfair.configuration.TestSecurityConfig;
import gamz.projects.pharmacyfair.model.dto.FeedbackDTO;
import gamz.projects.pharmacyfair.model.exception.FeedbackNotFoundException;
import gamz.projects.pharmacyfair.model.request.FeedbackRequest;
import gamz.projects.pharmacyfair.service.FeedbackService;
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

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FeedbackController.class)
@Import({TestSecurityConfig.class, TestGlobalExceptionHandler.class})
class FeedbackControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private FeedbackService feedbackService;

    private FeedbackDTO feedbackDTO;
    private FeedbackRequest feedbackRequest;

    @BeforeEach
    void setUp() {
        feedbackDTO = FeedbackDTO.builder()
                .id(1)
                .email("client@test.com")
                .message("Test message")
                .name("Test")
                .createdAt(LocalDate.of(2030, 1, 1))
                .processedBy(1L)
                .isProcessed(true)
                .processedAt(LocalDate.of(2030, 1, 1))
                .build();

        feedbackRequest = FeedbackRequest.builder()
                .email("client@test.com")
                .message("Test message")
                .name("Test")
                .processedBy(1L)
                .isProcessed(true)
                .build();
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return all feedback")
    void getAllFeedback() throws Exception {
        // Arrange
        List<FeedbackDTO> feedbackDTOList = Collections.singletonList(feedbackDTO);
        when(feedbackService.getAllFeedback(Optional.empty())).thenReturn(feedbackDTOList);

        // Act & Assert
        mockMvc.perform(get("/api/v1/feedback").contentType(MediaType.APPLICATION_JSON))
                .andDo(print()) // Print request/response for debugging
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Test")))
                .andExpect(jsonPath("$[0].message", is("Test message")))
                .andExpect(jsonPath("$[0].email", is("client@test.com")))
                .andExpect(jsonPath("$[0].createdAt", is(LocalDate.of(2030, 1, 1).toString())))
                .andExpect(jsonPath("$[0].isProcessed", is(true)))
                .andExpect(jsonPath("$[0].processedBy", is(1)))
                .andExpect(jsonPath("$[0].processedAt", is(LocalDate.of(2030, 1, 1).toString())));

        verify(feedbackService, times(1)).getAllFeedback(Optional.empty());
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return feedback by ID")
    void getFeedbackById() throws Exception {
        // Arrange
        Long id = 1L;
        when(feedbackService.getFeedbackById(id)).thenReturn(feedbackDTO);

        // Act & Assert
        mockMvc.perform(get("/api/v1/feedback/" + id).contentType(MediaType.APPLICATION_JSON))
                .andDo(print()) // Print request/response for debugging
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Test")))
                .andExpect(jsonPath("$.message", is("Test message")))
                .andExpect(jsonPath("$.email", is("client@test.com")))
                .andExpect(jsonPath("$.createdAt", is(LocalDate.of(2030, 1, 1).toString())))
                .andExpect(jsonPath("$.isProcessed", is(true)))
                .andExpect(jsonPath("$.processedBy", is(1)))
                .andExpect(jsonPath("$.processedAt", is(LocalDate.of(2030, 1, 1).toString())));

        verify(feedbackService, times(1)).getFeedbackById(id);
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return 404 when feedback ID not found")
    void getFeedbackById_NotFound() throws Exception {
        // Arrange
        Long id = 999L;
        when(feedbackService.getFeedbackById(id)).thenThrow(new FeedbackNotFoundException("Feedback with id " + id + " not found"));

        // Act & Assert
        mockMvc.perform(get("/api/v1/feedback/" + id).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(feedbackService, times(1)).getFeedbackById(id);
    }

    @Test
    void createFeedback() throws Exception {
        // Arrange
        when(feedbackService.createFeedback(any(FeedbackRequest.class))).thenReturn(feedbackDTO);

        // Act & Assert
        mockMvc.perform(
                post("/api/v1/feedback")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(feedbackRequest)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Test")))
                .andExpect(jsonPath("$.message", is("Test message")))
                .andExpect(jsonPath("$.email", is("client@test.com")))
                .andExpect(jsonPath("$.createdAt", is(LocalDate.of(2030, 1, 1).toString())))
                .andExpect(jsonPath("$.isProcessed", is(true)))
                .andExpect(jsonPath("$.processedBy", is(1)))
                .andExpect(jsonPath("$.processedAt", is(LocalDate.of(2030, 1, 1).toString())));

        verify(feedbackService, times(1)).createFeedback(any(FeedbackRequest.class));
    }

    @Test
    @DisplayName("Should edit feedback")
    void editFeedback() throws Exception {
        // Arrange
        long id = 1L;
        String editedName = "Edited test editedName";
        String editedEmail = "edited.editedEmail@test.com";
        String editedMessage = "Edited test editedMessage";

        FeedbackDTO updatedDTO = FeedbackDTO.builder()
                .id(id)
                .name(editedName)
                .email(editedEmail)
                .message(editedMessage)
                .createdAt(LocalDate.of(2030, 1, 1))
                .processedBy(1L)
                .isProcessed(true)
                .processedAt(LocalDate.of(2030, 1, 1))
                .build();

        FeedbackRequest editFeedbackRequest = feedbackRequest;
        editFeedbackRequest.setEmail(editedEmail);
        editFeedbackRequest.setName(editedName);
        editFeedbackRequest.setName(editedMessage);

        when(feedbackService.editFeedback(eq(id), any(FeedbackRequest.class))).thenReturn(updatedDTO);

        // Act & Assert
        mockMvc.perform(
                put("/api/v1/feedback/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(feedbackRequest)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is(editedName)))
                .andExpect(jsonPath("$.message", is(editedMessage)))
                .andExpect(jsonPath("$.email", is(editedEmail)))
                .andExpect(jsonPath("$.createdAt", is(LocalDate.of(2030, 1, 1).toString())))
                .andExpect(jsonPath("$.isProcessed", is(true)))
                .andExpect(jsonPath("$.processedBy", is(1)))
                .andExpect(jsonPath("$.processedAt", is(LocalDate.of(2030, 1, 1).toString())));

        verify(feedbackService, times(1)).editFeedback(eq(id), any(FeedbackRequest.class));
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return 404 when edited feedback ID not found")
    void editFeedback_NotFound() throws Exception {
        // Arrange
        Long id = 999L;
        when(feedbackService.editFeedback(eq(id), any(FeedbackRequest.class))).thenThrow(new FeedbackNotFoundException("Feedback with id " + id + " not found"));

        // Act & Assert
        mockMvc.perform(put("/api/v1/feedback/" + id).contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(feedbackRequest)))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(feedbackService, times(1)).editFeedback(eq(id), any(FeedbackRequest.class));
    }

    @Test
    void deleteFeedback() throws Exception {
        long id = 1L;

        mockMvc.perform(delete("/api/v1/feedback/" + id).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());

        verify(feedbackService, times(1)).deleteFeedback(id);
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return 404 when deleted feedback ID not found")
    void deleteFeedback_NotFound() throws Exception {
        // Arrange
        Long id = 999L;
        doThrow(new FeedbackNotFoundException("Feedback with id " + id + " not found"))
                .when(feedbackService).deleteFeedback(id);

        // Act & Assert
        mockMvc.perform(delete("/api/v1/feedback/" + id).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(feedbackService, times(1)).deleteFeedback(id);
    }
}