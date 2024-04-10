package Ex1B.Exceptions;

public class IdTakenException extends RuntimeException {

    public IdTakenException(String msg) {
        super(msg);
    }
}
