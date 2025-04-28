package gamz.projects.pharmacyfair.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import gamz.projects.pharmacyfair.model.entity.Feedback;
import gamz.projects.pharmacyfair.model.entity.User;
import gamz.projects.pharmacyfair.model.mapper.FeedbackMapper;
import gamz.projects.pharmacyfair.model.request.FeedbackCreateRequest;
import gamz.projects.pharmacyfair.model.request.FeedbackProcessRequest;
import gamz.projects.pharmacyfair.model.response.ErrorNotFoundResponse;
import gamz.projects.pharmacyfair.model.response.FeedbackCreateResponse;
import gamz.projects.pharmacyfair.model.response.FeedbackProcessResponse;
import gamz.projects.pharmacyfair.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final FeedbackMapper feedbackMapper;

    public FeedbackCreateResponse create(FeedbackCreateRequest request) {
        Feedback feedback = feedbackMapper.toFeedbackFromCreateRequest(request);
        Feedback feedbackSaved = feedbackRepository.save(feedback);
        return FeedbackCreateResponse.builder().feedbackNumber(feedbackSaved.getId()).build();
    }

    public FeedbackProcessResponse process(FeedbackProcessRequest request, User user) {
        Feedback feedback = feedbackRepository.findById(request.getFeedbackId()).get();
        feedback.processedBy = user;
        feedbackRepository.save(feedback);
        return FeedbackProcessResponse.builder().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ErrorNotFoundResponse handleNonFoundException(NoSuchElementException ex) {
        return ErrorNotFoundResponse.builder().message("Feedback с таким id не существует").build();
    }
}
