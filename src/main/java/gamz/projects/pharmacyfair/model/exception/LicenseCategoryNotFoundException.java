package gamz.projects.pharmacyfair.model.exception;

public class LicenseCategoryNotFoundException extends RuntimeException {
    public LicenseCategoryNotFoundException() {}

    public LicenseCategoryNotFoundException(String message) {
        super(message);
    }
}
