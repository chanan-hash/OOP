package Ex1A;

import Ex1A.FlightManegers.FlightObserverManager;
import Ex1A.FlightManegers.SearchFlightManager;
import Ex1A.FlightsExceptions.*;
import Ex1A.PatternsInterfaces.FlightComponent;
import Ex1A.PatternsInterfaces.FlightObserver;
import Ex1A.PatternsInterfaces.FlightSearchStrategy;
import Ex1A.PatternsInterfaces.FlightSubject;
import Ex1A.WorkerEnums.CompanyWorkers;

import java.util.List;
import java.util.ArrayList;

public class FlightCompany implements FlightComponent, FlightSubject {
    private String companyName;

    private final List<FlightComponent> subCompanies;
    private final List<Flight> flights;
    private final List<CompWorker> workers;

    private final List<FlightObserver> ComFlightObservers;  // The observers looking on the company updates
    private final FlightObserverManager flightObserverManager; // An observer manager to manage the observers

    private final SearchFlightManager searchMangers; // An manager object to manage the flight search strategy

    // Constructor
    public FlightCompany(String companyName) {
        this.subCompanies = new ArrayList<>();
        this.flights = new ArrayList<>();
        this.workers = new ArrayList<>();
        this.ComFlightObservers = new ArrayList<>();
        this.flightObserverManager = new FlightObserverManager();
        this.searchMangers = new SearchFlightManager();
    }


    // Flight company can create a flight
    public Flight createFlight(String source, String destination, double price, double duration, String date, int numPassengers, int numCrewmates, int flightNumber) {
        Flight flight = new Flight(source, destination, price, duration, date, numPassengers, numCrewmates, flightNumber);
        flights.add(flight);
        return flight;
    }

    // Methods

    /**
     * this will be by another manager to show delegation pattern
     */
    public boolean bookFlight(Flight flight, Passengers passenger, boolean subscribe) {
        if (flight.getPassengers().size() < flight.getNumPassengers()) {
            flight.getPassengers().add(passenger);
            if (subscribe) {
                addObserver((FlightObserver) passenger, this.ComFlightObservers); // TODO check the casting
            }
            return true;
        }
        return false;
    }

    // TODO maybe to go over the whole subcompenies and check if the flight is there
    // Only someone that was one flight can cancel it
    public boolean cancelFlight(Flight flight, Passengers passengers, boolean subscribe) {
        if (!flight.getPassengers().contains(passengers)) {
            flight.getPassengers().remove(passengers);
        }
        if (subscribe) {
            removeObserver((FlightObserver) passengers, this.ComFlightObservers); // TODO check the casting
        }
        return false;
    }

    public void cancelFlight(Flight flight) {
        flights.remove(flight);
        this.notifyCancel(flight);
    }

    /**
     * Add a worker to the company
     * After it when we are adding a crewmate to a flight we are checking if he's working in this company,
     * and if his type is CREW_FLIGHT
     *
     * @param worker
     * @return
     */

    public boolean addWorker(CompWorker worker) {
        if (!workers.contains(worker)) {
            workers.add(worker);
            return true;
        }
        return false;
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
    // TODO check the type of the worker
    public boolean addCrewmate(Flight flight, CompWorker crewmate) throws NotWorkingHereException, NotCrewFlightException {
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

    /**
     * Search for a flight by the search strategy
     *
     * @param flights
     * @throws InCorrectInputException
     */
    public void searchFlight(List<Flight> flights) throws InCorrectInputException {
        searchMangers.searchFlights(flights);
    }


    /**
     * This method is for the composite pattern
     * Add a sub company to the company
     *
     * @param subCompany
     * @return
     */
    public boolean addSubCompany(FlightComponent subCompany) {
        if (!subCompanies.contains(subCompany)) {
            subCompanies.add(subCompany);
            return true;
        }
        return false;
    }


    /**
     * This method is for the composite pattern
     */
    @Override
    public void printData() {
        this.toString(); // print the data of the curr company
        System.out.println("My sub companies are: ");
        if (subCompanies.size() > 0) { // going over the sub companies and printing them
            for (FlightComponent subCompany : subCompanies) {
                subCompany.printData();
            }
        }
    }

    @Override
    public String toString() {
        return "FlightCompany{" +
                "companyName='" + companyName + '\'' +
                ", subCompanies=" + subCompanies +
                ", flights=" + flights +
                '}';
    }

    /*
        print the data of the curr company

        if we have sub companies:
            for each sub_company
                print the data of each sub company
     */

    @Override
    public void addObserver(FlightObserver observer, List<FlightObserver> ComFlightObservers) {
        this.flightObserverManager.addObserver(observer, ComFlightObservers);
    }

    @Override
    public void notifyDelay(Flight flight, double delay) {
        this.flightObserverManager.notifyDelay(flight, delay);
    }

    @Override
    public void notifyCancel(Flight flight) {
        this.flightObserverManager.notifyCancel(flight);
    }

    @Override
    public void notifySale(List<FlightObserver> ComFlightObservers, Flight flight, int discount) {
        this.flightObserverManager.notifySale(ComFlightObservers, flight, discount);
    }

    @Override
    public void removeObserver(FlightObserver observer, List<FlightObserver> ComFlightObservers) {
        this.flightObserverManager.removeObserver(observer, ComFlightObservers);
    }

    // Getters and Setters
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public SearchFlightManager getSearchMangers() {
        return searchMangers;
    }

    public List<FlightComponent> getSubCompanies() {
        return subCompanies;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public List<CompWorker> getWorkers() {
        return workers;
    }

    public List<FlightObserver> getComFlightObservers() {
        return ComFlightObservers;
    }

    public FlightObserverManager getFlightObserverManager() {
        return flightObserverManager;
    }
}

