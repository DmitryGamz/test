package gamz.projects.pharmacyfair.model.exception;

public class LicenseTypeNotFoundException extends RuntimeException {
    public LicenseTypeNotFoundException() {}
    public LicenseTypeNotFoundException(String message) {
        super(message);
    }
}
