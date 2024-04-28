package Ex1A.PatternsInterfaces;

/**
 * Observer pattern, we'll have a subject that will notify all the observers.
 * The subject will be the flight, and the observers will be the passengers, crewmates and company-workers.
 */
public interface FlightObserver {
    void update(String msg);
}
