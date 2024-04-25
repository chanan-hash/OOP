package Ex1B.Exceptions;

/**
 * This exception is thrown when a user tries to register the system with an id that is already taken.
 */
public class IdTakenException extends RuntimeException {

    public IdTakenException(String msg) {
        super(msg);
    }
}
