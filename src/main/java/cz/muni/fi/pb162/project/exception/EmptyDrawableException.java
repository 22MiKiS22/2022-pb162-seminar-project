package cz.muni.fi.pb162.project.exception;

/**
 * @author Michael Skor
 */
public class EmptyDrawableException extends Exception {
    /**
     * Constructor of exception
     */
    public EmptyDrawableException(){
        super();
    }

    /**
     * Constructor of exception
     * @param message message
     */
    public EmptyDrawableException(String message) {
        super(message);
    }

    /**
     * Constructor of exception
     * @param message message
     * @param cause cause
     */
    public EmptyDrawableException(String message, Throwable cause) {
        super(message, cause);
    }
}
