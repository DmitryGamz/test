package gamz.projects.pharmacyfair.util;

public class ValidationUtils {
    public static void validateId(Long id) {
        if (id == null || id < 1) {
            throw new IllegalArgumentException("ID должен быть больше 0");
        }
    }
}
