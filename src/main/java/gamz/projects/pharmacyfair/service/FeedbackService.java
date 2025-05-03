package gamz.projects.pharmacyfair.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import gamz.projects.pharmacyfair.model.dto.FeedbackDTO;
import gamz.projects.pharmacyfair.model.entity.Feedback;
import gamz.projects.pharmacyfair.model.entity.User;
import gamz.projects.pharmacyfair.model.exception.FeedbackNotFoundException;
import gamz.projects.pharmacyfair.model.exception.UserNotFoundException;
import gamz.projects.pharmacyfair.model.mapper.FeedbackMapper;
import gamz.projects.pharmacyfair.model.request.FeedbackRequest;
import gamz.projects.pharmacyfair.repository.FeedbackRepository;
import gamz.projects.pharmacyfair.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final UserRepository userRepository;
    private final FeedbackMapper feedbackMapper;

    public List<FeedbackDTO> getAllFeedback(Optional<Boolean> isProcessed) {
        Spliterator<Feedback> feedbackList;

        // if filtered by param
        if (isProcessed.isPresent()) {
            feedbackList = feedbackRepository.findAllByIsProcessed(isProcessed.get()).spliterator();
        // default (all)
        } else {
            feedbackList = feedbackRepository.findAll().spliterator();
        }
        return StreamSupport.stream(feedbackList, false)
                .map(feedbackMapper::toFeedbackDTO)
                .collect(Collectors.toList());
    }

    public FeedbackDTO getFeedbackById (Long id) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new FeedbackNotFoundException("Feedback with id " + id + " not found"));
        return feedbackMapper.toFeedbackDTO(feedback);
    }

    public FeedbackDTO createFeedback(FeedbackRequest feedbackRequest) {
        Feedback feedback = feedbackMapper.toFeedbackFromRequest(feedbackRequest);

        if (feedbackRequest.getProcessedBy() != null) {
            User user = userRepository.findById(Math.toIntExact(feedbackRequest.getProcessedBy()))
                    .orElseThrow(() -> new UserNotFoundException("User with id " + feedbackRequest.getProcessedBy() + " not found"));
            feedback.setProcessedBy(user);
        } else {
            feedback.setProcessedBy(null);
        }

        feedback.setCreatedAt(LocalDateTime.now());
        if (feedback.getIsProcessed() == true) {
            feedback.setProcessedAt(LocalDateTime.now());
        }

        Feedback savedFeedback = feedbackRepository.save(feedback);
        return feedbackMapper.toFeedbackDTO(savedFeedback);
    }

    public FeedbackDTO editFeedback(Long id, FeedbackRequest feedbackRequest) {
        Feedback existingFeedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new FeedbackNotFoundException("Feedback with id " + id + " not found"));

        if (feedbackRequest.getEmail() != null) {
            existingFeedback.setEmail(feedbackRequest.getEmail());
        }

        if (feedbackRequest.getName() != null) {
            existingFeedback.setName(feedbackRequest.getName());
        }

        if (feedbackRequest.getMessage() != null) {
            existingFeedback.setMessage(feedbackRequest.getMessage());
        }

        if (feedbackRequest.getProcessedBy() != null) {
            User userProcessedBy = userRepository.findById( Math.toIntExact(feedbackRequest.getProcessedBy()) )
                    .orElseThrow(() -> new UserNotFoundException("Пользователь с id " + feedbackRequest.getProcessedBy() + " не существует"));
            existingFeedback.setProcessedBy(userProcessedBy);
        }

        if (feedbackRequest.getIsProcessed() != null) {
            existingFeedback.setIsProcessed(feedbackRequest.getIsProcessed());
            existingFeedback.setProcessedAt(LocalDateTime.now());
        }

        Feedback savedFeedback = feedbackRepository.save(existingFeedback);
        return feedbackMapper.toFeedbackDTO(savedFeedback);
    }

    public void deleteFeedback(Long id) {
        if (! feedbackRepository.existsById(id)) {
            throw new FeedbackNotFoundException("Feedback with id " + id + " not found");
        }
        feedbackRepository.deleteById(id);
    }
}
