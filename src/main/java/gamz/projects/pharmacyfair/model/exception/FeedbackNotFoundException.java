package gamz.projects.pharmacyfair.model.exception;

public class FeedbackNotFoundException extends RuntimeException {

    public FeedbackNotFoundException() {}

    public FeedbackNotFoundException(String message) {
        super(message);
    }
}
