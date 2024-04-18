package Ex1A.FlightsExceptions;

public class InCorrectInputException extends RuntimeException {
    public InCorrectInputException(String message) {
        super(message);
    }
}
