package gamz.projects.pharmacyfair.model.exception;

public class FileNotAccessibleException extends RuntimeException{
    public FileNotAccessibleException(String message) {
        super(message);
    }
    public FileNotAccessibleException(String message, Throwable cause){
        super(message, cause);
    }
}
