package Ex1B.Exceptions;

public class NotLoggedInException extends RuntimeException {
    public NotLoggedInException(String msg) {
        super(msg);
    }
}
