package Ex1B.Exceptions;

/**
 * IncorrectPasswordException class, for login checkup .
 */
public class IncorrectPasswordException extends Exception {
    public IncorrectPasswordException(String message) {
        super(message);
    }
}
