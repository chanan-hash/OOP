package Ex1B.Exceptions;

public class SystemIsFullException extends RuntimeException {
    public SystemIsFullException(String msg) {
        super(msg);
    }
}
