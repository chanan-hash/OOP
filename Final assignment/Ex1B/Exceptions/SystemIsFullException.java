package Ex1B.Exceptions;

/**
 * This exception is thrown when the system is full (more than 100) and cannot accept more university-person.
 */
public class SystemIsFullException extends RuntimeException {
    public SystemIsFullException(String msg) {
        super(msg);
    }
}
