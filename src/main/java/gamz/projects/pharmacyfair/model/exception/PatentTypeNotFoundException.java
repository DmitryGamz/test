package gamz.projects.pharmacyfair.model.exception;

public class PatentTypeNotFoundException extends RuntimeException {

    public PatentTypeNotFoundException() {
    }

    public PatentTypeNotFoundException(String message) {
        super(message);
    }
} 