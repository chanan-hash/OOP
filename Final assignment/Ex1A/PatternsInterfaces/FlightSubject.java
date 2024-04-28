package Ex1A.PatternsInterfaces;
import java.util.List;
import Ex1A.Flight;

/**
 * The subject interface that will be implemented by the flight-company
 * The flight-company will notify all the observers about the delay, cancel, and sales of the flights
 */
public interface FlightSubject {

    public void addObserver(FlightObserver observer, List<FlightObserver> ComFlightObservers);

    public void notifyDelay(Flight flight, double delay); // Notify all observers about the delay of a flight

    public void notifyCancel(Flight flight); // Notify all observers about the cancellation of a flight

    public void notifySale(List<FlightObserver> ComFlightObservers,Flight flight, double discount); // Notify all observers about special sales on flights

    public void removeObserver(FlightObserver observer,List<FlightObserver> ComFlightObservers);

}
