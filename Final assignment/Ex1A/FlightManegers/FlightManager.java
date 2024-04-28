package Ex1A.FlightManegers;


import Ex1A.CompWorker;
import Ex1A.Flight;
import Ex1A.FlightsExceptions.FlightNotExistsException;
import Ex1A.FlightsExceptions.NotCrewFlightException;
import Ex1A.FlightsExceptions.NotWorkingHereException;
import Ex1A.Passengers;
import Ex1A.WorkerEnums.CompanyWorkers;

import java.util.List;

/**
 * This class is responsible for managing the flights and.
 * Like booking app, that can work with few flights companies according to flights.
 */

public class FlightManager {
    private List<Flight> flights;

    // Constructor
    public FlightManager(List<Flight> flights) {
        this.flights = flights;
    }

    /**
     * This whole method will help us in the company class to manage all kinds of flights methods.
     * In flight company will call the functions here, and will be abke to add more stuff such as the observer notification
     */

    // Methods
    // Creating a new flight
    public Flight createFlight(String source, String destination, double price, double duration, String date, int numPassengers, int numCrewmates, int flightNumber) {
        Flight flight = new Flight(source, destination, price, duration, date, numPassengers, numCrewmates, flightNumber);
        flights.add(flight);
        return flight;
    }

    // Putting a passenger on a flight
    public boolean bookFlight(Flight flight, Passengers passenger) {
        if (flight.getPassengers().size() < flight.getNumPassengers()) {
            flight.getPassengers().add(passenger);
            return true;
        }
        return false;
    }

    // Canceling a flight by a passenger
    public boolean cancelFlight(Flight flight, Passengers passengers) {
        if (!flight.getPassengers().contains(passengers)) {
            flight.getPassengers().remove(passengers);
            return true;
        }
        return false;
    }

    /**
     * Observer helper functions
     */
    // canceling the flight itself
    public void flightCancellation(Flight flight) throws FlightNotExistsException {
        if (!flights.contains(flight)) {
            throw new FlightNotExistsException("The flight is not in the company");
        }
        flights.remove(flight);
    }

    public void flightDelay(Flight flight, double delay) {
        flight.setDuration(flight.getDuration() + delay);
    }

    // The discount is in percentage
    public void flightSale(Flight flight, double discount) {
        double afterDiscount = (discount / 100) * flight.getPrice();
        flight.setPrice(flight.getPrice() - afterDiscount);
    }

    // To add a crewmate we need to check that he is working in the company first, and then to check that he's roll is from a crew flight
    public boolean addCrewmate(Flight flight, List<CompWorker> workers, CompWorker crewmate) throws NotWorkingHereException, NotCrewFlightException {
        if (!workers.contains(crewmate)) {
            throw new NotWorkingHereException("The crewmate is not working in this company");
        } else if (crewmate.getCompanyWorker() != CompanyWorkers.CREW_FLIGHT) {
            throw new NotCrewFlightException("The worker is not from a crew flight");
        }
        if (flight.getCrewmates().size() < flight.getNumCrewmates()) {
            flight.getCrewmates().add(crewmate);
            return true;
        }
        return false;
    }


    // Getters and Setters
    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
