package Ex1A.FlightsExceptions;

public class FlightNotExistsException extends Exception{
    public FlightNotExistsException(String message) {
        super(message);
    }
}
