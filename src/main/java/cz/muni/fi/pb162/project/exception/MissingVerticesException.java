package cz.muni.fi.pb162.project.exception;

/**
 * @author Michael Skor
 */
public class MissingVerticesException extends RuntimeException {
    /**
     * Constructor of exception
     */
    public MissingVerticesException(){
        super();
    }

    /**
     * Constructor of exception
     * @param message message
     */
    public MissingVerticesException(String message) {
        super(message);
    }

    /**
     * Constructor of exception
     * @param message message
     * @param cause cause
     */
    public MissingVerticesException(String message, Throwable cause) {
        super(message, cause);
    }
}
