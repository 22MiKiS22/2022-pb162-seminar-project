package cz.muni.fi.pb162.project.exception;

/**
 * @author Michael Skor
 */
public class TransparentColorException extends Exception {
    /**
     * Constructor of exception
     */
    public TransparentColorException(){
        super();
    }

    /**
     * Constructor of exception
     * @param message message
     */
    public TransparentColorException(String message) {
        super(message);
    }

    /**
     * Constructor of exception
     * @param message message
     * @param cause cause
     */
    public TransparentColorException(String message, Throwable cause) {
        super(message, cause);
    }
}
