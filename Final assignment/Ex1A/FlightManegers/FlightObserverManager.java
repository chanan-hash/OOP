package Ex1A.FlightManegers;

import Ex1A.CompWorker;
import Ex1A.Flight;
import Ex1A.PatternsInterfaces.FlightObserver;
import Ex1A.PatternsInterfaces.FlightSubject;
import Ex1A.Passengers;

import java.util.List;

public class FlightObserverManager implements FlightSubject {

    /**
     * Observer pattern
     *
     * @param observer
     */
    @Override
    public void addObserver(FlightObserver observer, List<FlightObserver> ComFlightObservers) {
        if (!ComFlightObservers.contains(observer)) {
            ComFlightObservers.add(observer);
        }
    }

    @Override
    public void removeObserver(FlightObserver observer, List<FlightObserver> ComFlightObservers) {
        if (ComFlightObservers.contains(observer)) {
            ComFlightObservers.remove(observer);
        }
    }

    /**
     * Because the subject is not the flight, rather than the company,
     * we need to notify all the observers by going overs all the flight's Passengers and Crewmates
     * We don't want to notify only the one that did subscribe to get updates,
     * because we want to notify all the passengers and crewmates if the flight is delayed or canceled even if they didn't subscribe
     *
     * @param flight
     * @param delay
     */

    @Override
    public void notifyDelay(Flight flight, double delay) {
        for (Passengers passengers : flight.getPassengers()) {
            passengers.update("The flight " + flight.getFlightNumber() + " has been delayed by " + delay + " hours");
        }
        for (CompWorker crewmate : flight.getCrewmates()) {
            crewmate.update("The flight " + flight.getFlightNumber() + " has been delayed by " + delay + " hours");
        }
    }

    @Override
    public void notifyCancel(Flight flight) {
        for (Passengers passengers : flight.getPassengers()) {
            passengers.update("The flight " + flight.getFlightNumber() + " has been canceled");
        }
        for (CompWorker crewmate : flight.getCrewmates()) {
            crewmate.update("The flight " + flight.getFlightNumber() + " has been canceled");
        }
    }


    /**
     * Notify all observers about special sales on flights according to the destination
     */
    @Override
    public void notifySale(List<FlightObserver> ComFlightObservers, Flight flight, double discount) {
        for (FlightObserver observer : ComFlightObservers) {
            observer.update("New sale on flight from " + flight.getSource() + " to " + flight.getDest() + " has a special sale of " + discount + "%");
        }
    }
}
