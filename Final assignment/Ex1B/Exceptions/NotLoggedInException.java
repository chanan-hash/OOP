package Ex1B.Exceptions;

/**
 * Exception thrown when a user tries to perform an operation and is not logged in to the system.
 */
public class NotLoggedInException extends RuntimeException {
    public NotLoggedInException(String msg) {
        super(msg);
    }
}
