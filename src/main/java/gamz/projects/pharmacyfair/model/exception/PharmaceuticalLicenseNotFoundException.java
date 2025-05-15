package gamz.projects.pharmacyfair.model.exception;

public class PharmaceuticalLicenseNotFoundException extends RuntimeException {
    public PharmaceuticalLicenseNotFoundException() {}

    public PharmaceuticalLicenseNotFoundException(String message) {
        super(message);
    }
}
