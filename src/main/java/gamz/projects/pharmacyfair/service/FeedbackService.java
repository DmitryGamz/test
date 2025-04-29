package gamz.projects.pharmacyfair.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import gamz.projects.pharmacyfair.model.dto.FeedbackDTO;
import gamz.projects.pharmacyfair.model.entity.Feedback;
import gamz.projects.pharmacyfair.model.entity.User;
import gamz.projects.pharmacyfair.model.exception.FeedbackNotFoundException;
import gamz.projects.pharmacyfair.model.mapper.FeedbackMapper;
import gamz.projects.pharmacyfair.model.request.FeedbackCreateRequest;
import gamz.projects.pharmacyfair.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final FeedbackMapper feedbackMapper;

    public List<FeedbackDTO> getAllFeedback() {
        return StreamSupport.stream(feedbackRepository.findAll().spliterator(), false)
                .map(feedbackMapper::toFeedbackDTO)
                .collect(Collectors.toList());
    }

    public FeedbackDTO getFeedbackById (Long id) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new FeedbackNotFoundException("Feedback with id " + id + " not found"));
        return feedbackMapper.toFeedbackDTO(feedback);
    }

    public FeedbackDTO createFeedback(FeedbackCreateRequest request) {
        Feedback feedback = feedbackMapper.toFeedbackFromRequest(request);

        feedback.setCreatedAt(LocalDateTime.now());

        Feedback savedFeedback = feedbackRepository.save(feedback);
        return feedbackMapper.toFeedbackDTO(savedFeedback);
    }

    public FeedbackDTO processFeedback(Long id, User user) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new FeedbackNotFoundException("Feedback with id " + id + " not found"));
        feedback.processedBy = user;
        Feedback savedFeedback = feedbackRepository.save(feedback);
        return feedbackMapper.toFeedbackDTO(savedFeedback);
    }
}
