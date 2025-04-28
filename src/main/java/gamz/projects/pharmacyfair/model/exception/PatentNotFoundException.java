package gamz.projects.pharmacyfair.model.exception;

public class PatentNotFoundException extends RuntimeException {

    public PatentNotFoundException() {
    }

    public PatentNotFoundException(String message) {
        super(message);
    }
} 