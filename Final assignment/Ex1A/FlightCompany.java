package Ex1A;

import Ex1A.FlightsExceptions.NotWorkingHereException;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FlightCompany implements FlightComponent{
    private String companyName;

    private final List<FlightCompany> subCompanies;
    private final List<Flight> flights;
    private final List<Crewmate> workers;
//    private final Map<Flight, ArrayList<FilghtObserver>> flightObservers;


    public FlightCompany(String companyName) {
        this.subCompanies = new ArrayList<>();
        this.flights = new ArrayList<>();
        this.workers = new ArrayList<>();
//        this.flightObservers = new HashMap<>();
    }

    public boolean bookFlight(Flight flight, Passengers passengers, boolean subscribe) {
        if (flight.getPassengers().size() < flight.getNumPassengers()) {
            flight.getPassengers().add(passengers);
            if (subscribe) {
                flight.addObserver((FilghtObserver) passengers); // TODO check the casting
            }
            return true;
        }
        return false;
    }

    // TODO Notify the observer
    public boolean cancelFlight(Flight flight, Passengers passengers) {
        if (flight.getPassengers().contains(passengers)) {
            flight.getPassengers().remove(passengers);
            flight.removeObserver((FilghtObserver) passengers);
            // Notify the observer
//            flightObservers.get(flight).remove(passengers);
            flight.notifyPassenger(); //TODO add message of canceling
            return true;
        }
        return false;
    }

    public boolean addWorker(Crewmate crewmate) {
        if (!workers.contains(crewmate)) {
            workers.add(crewmate);
            return true;
        }
        return false;
    }

    // Flight company can create a flight
    public Flight createFlight(String source, String destination, double price, double duration, String date, int numPassengers, int numCrewmates, int flightNumber) {
        Flight flight = new Flight(source, destination, price, duration, date, numPassengers, numCrewmates, flightNumber);
        flights.add(flight);
        return flight;
    }

    /**
     * We are assumings that which crewmate suppose to be in which flight is already decided or on a database
     * and getting the info from there, and we are just adding the crewmate to the flight
     * but only if he's working in that flight company
     *
     * @param flight
     * @param crewmate
     * @return
     */
    public boolean addCrewmate(Flight flight, Crewmate crewmate) throws NotWorkingHereException {
        if (!workers.contains(crewmate)) {
            throw new NotWorkingHereException("The crewmate is not working in this company");
        }
        if (flight.getCrewmates().size() < flight.getNumCrewmates()) {
            flight.getCrewmates().add(crewmate);
            return true;
        }
        return false;
    }

    public boolean addSubCompany(FlightCompany subCompany) {
        if (!subCompanies.contains(subCompany)) {
            subCompanies.add(subCompany);
            return true;
        }
        return false;
    }


    // The composite pattern
    public void printData() {
        if (subCompanies.size() > 0) {
            for (FlightCompany subCompany : subCompanies) {
                // TODO need to prints all flights data for each sub company
                subCompany.printData();
            }
        }
    }

    /*
        print the data of the curr company

        if we have sub companies:
            for each sub_company
                print the data of each sub company
     */


}
