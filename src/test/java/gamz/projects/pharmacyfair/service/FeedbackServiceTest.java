package gamz.projects.pharmacyfair.service;

import gamz.projects.pharmacyfair.model.dto.FeedbackDTO;
import gamz.projects.pharmacyfair.model.entity.Feedback;
import gamz.projects.pharmacyfair.model.entity.User;
import gamz.projects.pharmacyfair.model.exception.FeedbackNotFoundException;
import gamz.projects.pharmacyfair.model.exception.UserNotFoundException;
import gamz.projects.pharmacyfair.model.mapper.FeedbackMapper;
import gamz.projects.pharmacyfair.model.request.FeedbackRequest;
import gamz.projects.pharmacyfair.repository.FeedbackRepository;
import gamz.projects.pharmacyfair.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FeedbackServiceTest {
    @Mock
    private FeedbackRepository feedbackRepository;

    @Mock
    private FeedbackMapper feedbackMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private FeedbackService feedbackService;

    private Feedback feedback;
    private FeedbackDTO feedbackDTO;
    private FeedbackRequest feedbackRequest;
    private User user;

    @BeforeEach
    void setUp() {
        // set up all data
        user = User.builder()
                .id(1L)
                .firstName("Test")
                .lastName("User")
                .email("test-admin@test.com")
                .build();

        feedback = Feedback.builder()
                .id(user.getId())
                .email("client@test.com")
                .message("Test message")
                .name("Test")
                .createdAt(LocalDateTime.now())
                .processedBy(user)
                .isProcessed(true)
                .processedAt(LocalDateTime.now())
                .build();

        feedbackDTO = FeedbackDTO
                .builder()
                .email("client@test.com")
                .message("Test message")
                .name("Test")
                .createdAt(LocalDate.of(2030, 1, 1))
                .processedBy(1L)
                .isProcessed(true)
                .processedAt(LocalDate.of(2030, 1, 1))
                .build();

        feedbackRequest = FeedbackRequest
                .builder()
                .email("client@test.com")
                .message("Test message")
                .name("Test")
                .processedBy(1L)
                .isProcessed(true)
                .build();
    }

    @Test
    @DisplayName("Should return all feedback")
    void testGetAllFeedback() {
        // Arrange
        List<Feedback> feedbackList = Collections.singletonList(feedback);
        when(feedbackRepository.findAll()).thenReturn(feedbackList);
        when(feedbackMapper.toFeedbackDTO(any(Feedback.class))).thenReturn(feedbackDTO);

        // Act
        List<FeedbackDTO> result = feedbackService.getAllFeedback(Optional.empty());

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(feedbackDTO, result.getFirst());
        verify(feedbackRepository, times(1)).findAll();
        verify(feedbackMapper, times(1)).toFeedbackDTO(any(Feedback.class));
    }

    @Test
    @DisplayName("Should return all processed feedback")
    void testGetAllFeedback_FilterProcessed() {
        // Arrange
        Feedback processedFeedback = Feedback.builder().id(1).isProcessed(true).build();
        FeedbackDTO processedFeedbackDTO = FeedbackDTO.builder().id(1).isProcessed(true).build();
        List<Feedback> feedbackList = Collections.singletonList(processedFeedback);
        when(feedbackRepository.findAllByIsProcessed(true)).thenReturn(feedbackList);
        when(feedbackMapper.toFeedbackDTO(any(Feedback.class))).thenReturn(processedFeedbackDTO);

        // Act
        List<FeedbackDTO> result = feedbackService.getAllFeedback(Optional.of(true));

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(processedFeedbackDTO, result.getFirst());
        verify(feedbackRepository, times(1)).findAllByIsProcessed(true);
        verify(feedbackMapper, times(1)).toFeedbackDTO(any(Feedback.class));
        verify(feedbackRepository, never()).findAll(); // verify that findAll never used while filtered
    }

    @Test
    @DisplayName("Should return feedback by ID")
    void testGetFeedbackById() {
        // Arrange
        when(feedbackRepository.findById(1L)).thenReturn(Optional.of(feedback));
        when(feedbackMapper.toFeedbackDTO(feedback)).thenReturn(feedbackDTO);

        // Act
        FeedbackDTO result = feedbackService.getFeedbackById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(feedbackDTO, result);
        verify(feedbackRepository, times(1)).findById(1L);
        verify(feedbackMapper, times(1)).toFeedbackDTO(feedback);
    }

    @Test
    @DisplayName("Should throw exception when feedback ID not found")
    void testGetFeedbackById_FeedbackNotFound() {
        // Arrange
        when(feedbackRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(FeedbackNotFoundException.class, () -> feedbackService.getFeedbackById(1L));
        verify(feedbackRepository, times(1)).findById(1L);
        verify(feedbackMapper, never()).toFeedbackDTO(any(Feedback.class));
    }

    @Test
    @DisplayName("Should create new feedback")
    void testCreateFeedback() {
        // Arrange
        Long userId = feedbackRequest.getProcessedBy();
        when(feedbackMapper.toFeedbackFromRequest(feedbackRequest)).thenReturn(feedback);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(feedbackRepository.save(any(Feedback.class))).thenReturn(feedback);
        when(feedbackMapper.toFeedbackDTO(feedback)).thenReturn(feedbackDTO);

        // Act
        FeedbackDTO result = feedbackService.createFeedback(feedbackRequest);

        // Assert
        assertNotNull(result);
        assertEquals(feedbackDTO, result);
        verify(feedbackRepository, times(1)).save(any(Feedback.class));
        verify(userRepository, times(1)).findById(userId);
        verify(feedbackMapper, times(1)).toFeedbackDTO(feedback);
    }

    @Test
    @DisplayName("Should throw exception when assigned user not found")
    void testCreateFeedback_UserNotFound() {
        // Arrange
        long userId = 999L; // non existent user
        feedbackRequest.setProcessedBy(userId);
        when(feedbackMapper.toFeedbackFromRequest(feedbackRequest)).thenReturn(feedback);
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> feedbackService.createFeedback(feedbackRequest));
        verify(userRepository, times(1)).findById(userId);
        verify(feedbackRepository, never()).save(any(Feedback.class));
    }

    @Test
    @DisplayName("Should update feedback")
    void testEditFeedback() {
        long id = 1L;
        User processedByUser = user;
        long processedByUserId = user.getId();
        String editedMessage = "Test message";
        String editedName = "Test name";
        String editedEmail = "test@updated.com";
        Boolean editedIsProcessed = true;

        FeedbackRequest feedbackEditRequest = FeedbackRequest
                .builder()
                .email(editedEmail)
                .message(editedMessage)
                .name(editedName)
                .processedBy(processedByUserId)
                .isProcessed(editedIsProcessed)
                .build();

        Feedback existingFeedback = feedback;

        Feedback updatedFeedback = Feedback.builder()
                .id(id)
                .email(editedEmail)
                .message(editedMessage)
                .name(editedName)
                .processedBy(processedByUser)
                .isProcessed(editedIsProcessed)
                .build();

        FeedbackDTO updatedFeedbackDTO = FeedbackDTO.builder()
                .id(id)
                .email(editedEmail)
                .message(editedMessage)
                .name(editedName)
                .processedBy(processedByUserId)
                .isProcessed(editedIsProcessed)
                .build();

        when(feedbackRepository.findById(id)).thenReturn(Optional.of(existingFeedback));
        when(feedbackRepository.save(any(Feedback.class))).thenReturn(updatedFeedback);
        when(userRepository.findById(processedByUserId)).thenReturn(Optional.of(user));
        when(feedbackMapper.toFeedbackDTO(updatedFeedback)).thenReturn(updatedFeedbackDTO);

        // Act
        FeedbackDTO result = feedbackService.editFeedback(id, feedbackEditRequest);

        // Assert
        assertNotNull(result);
        assertEquals(updatedFeedbackDTO, result);
        verify(feedbackRepository, times(1)).findById(id);
        verify(feedbackRepository, times(1)).save(any(Feedback.class));
        verify(feedbackMapper, times(1)).toFeedbackDTO(updatedFeedback);
    }

    @Test
    @DisplayName("Should throw exception when updating non-existing feedback")
    void testEditFeedback_FeedbackNotFound() {
        // Arrange
        Long id = 999L;
        when(feedbackRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(FeedbackNotFoundException.class, () -> feedbackService.editFeedback(id, feedbackRequest));
        verify(feedbackRepository, times(1)).findById(id);
        verify(feedbackRepository, never()).save(any(Feedback.class));
    }

    @Test
    @DisplayName("Should throw exception when updating non-existing user")
    void testEditFeedback_UserNotFound() {
        // Arrange
        Long feedbackId = 1L;
        long userId = 999L;
        FeedbackRequest feedbackEditRequest_NonExistingUser = feedbackRequest;
        feedbackEditRequest_NonExistingUser.setProcessedBy(userId);
        when(feedbackRepository.findById(feedbackId)).thenReturn(Optional.of(feedback));
        when(userRepository.findById( userId )).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> feedbackService.editFeedback(feedbackId, feedbackEditRequest_NonExistingUser));
        verify(feedbackRepository, times(1)).findById(feedbackId);
        verify(userRepository, times(1)).findById(userId);
        verify(feedbackRepository, never()).save(any(Feedback.class));
    }

    @Test
    void testDeleteFeedback() {
        // Arrange
        Long id = 1L;
        when(feedbackRepository.existsById(id)).thenReturn(true);
        doNothing().when(feedbackRepository).deleteById(id);

        // Act
        feedbackService.deleteFeedback(id);

        // Assert
        verify(feedbackRepository, times(1)).existsById(id);
        verify(feedbackRepository, times(1)).deleteById(id);
    }

    @Test
    @DisplayName("Should throw exception when updating non-existing feedback")
    void testDeleteFeedback_FeedbackNotFound() {
        // Arrange
        Long id = 999L;
        when(feedbackRepository.existsById(id)).thenReturn(false);

        // Act & Assert
        assertThrows(FeedbackNotFoundException.class, () -> feedbackService.deleteFeedback(id));
        verify(feedbackRepository, times(1)).existsById(id);
        verify(feedbackRepository, never()).deleteById(id);
    }
}
