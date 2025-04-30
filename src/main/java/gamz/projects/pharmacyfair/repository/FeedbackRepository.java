package gamz.projects.pharmacyfair.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import gamz.projects.pharmacyfair.model.entity.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback,Long> {
    List<Feedback> findAllByIsProcessed(Boolean isProcessed);
}