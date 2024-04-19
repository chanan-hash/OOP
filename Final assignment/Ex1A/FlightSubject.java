package Ex1A;

public interface FlightSubject {

    public void addObserver(FlightObserver observer);

    public void notifyDelay(Flight flight, double delay); // Notify all observers about the delay of a flight

    public void notifyCancel(Flight flight); // Notify all observers about the cancellation of a flight

    public void notifySale(); // Notify all observers about special sales on flights

    public void removeObserver(FlightObserver observer);

}
