package Ex1A;

// Idea for flight table in the database
// https://www.geeksforgeeks.org/how-to-design-database-for-flight-reservation-system/

import Ex1A.FlightManegers.FlightManager;
import Ex1A.FlightManegers.FlightObserverManager;
import Ex1A.FlightManegers.SearchFlightManager;
import Ex1A.FlightsExceptions.*;
import Ex1A.PatternsInterfaces.FlightComponent;
import Ex1A.PatternsInterfaces.FlightObserver;
import Ex1A.PatternsInterfaces.FlightSubject;

import java.util.List;
import java.util.ArrayList;

public class FlightCompany implements FlightComponent, FlightSubject {
    private String companyName;

    private List<FlightComponent> subCompanies;
    private List<Flight> flights;
    private List<CompWorker> workers;

    private List<FlightObserver> ComFlightObservers;  // The observers looking on the company updates
    private FlightObserverManager flightObserverManager; // An observer manager to manage the observers

    private SearchFlightManager searchMangers; // An manager object to manage the flight search strategy

    private FlightManager flightManager;


    // Constructor
    public FlightCompany(String companyName) {
        this.companyName = companyName;
        this.subCompanies = new ArrayList<>();
        this.flights = new ArrayList<>();
        this.workers = new ArrayList<>();
        this.ComFlightObservers = new ArrayList<>();
        this.flightObserverManager = new FlightObserverManager();
        this.searchMangers = new SearchFlightManager();
        this.flightManager = new FlightManager(flights);
    }

    // Methods

    /**
     * Add a worker to the company
     * After it when we are adding a crewmate to a flight we are checking if he's working in this company,
     * and if his type is CREW_FLIGHT
     *
     * @param worker
     * @param subscribe - if the worker wants get updated on sales for the company
     * @return
     */

    public boolean addWorker(CompWorker worker, boolean subscribe) {
        if (!workers.contains(worker)) {
            workers.add(worker);
            if (subscribe) {
                addObserver((FlightObserver) worker, this.ComFlightObservers); // TODO check the casting
            }
            return true;
        }
        return false;
    }


    /**
     * We are assumings that we know which crewmate suppose to be in which flight, is already decided or on a database
     * and getting the info from there, and we are just adding the crewmate to the flight
     * but only if he's working in that flight company and his type is CREW_FLIGHT
     *
     * @param flight
     * @param crewmate
     * @return
     */
    public boolean addCrewmate(Flight flight, CompWorker crewmate) throws NotWorkingHereException, NotCrewFlightException {
        return this.flightManager.addCrewmate(flight, workers, crewmate);
    }

    /********************************   DELEGATION   ******************************************/

    /**
     * This will be by flight manager to show delegation pattern
     */

    // Creating a flight by the manager and adding it to the list of flights
    public Flight createFlights(String source, String destination, double price, double duration, String date, int numPassengers, int numCrewmates, int flightNumber) {
        return this.flightManager.createFlight(source, destination, price, duration, date, numPassengers, numCrewmates, flightNumber);
    }

    public boolean bookFlight(Flight flight, Passengers passenger, boolean subscribe) {
        if (subscribe) {
            addObserver(passenger, this.ComFlightObservers);
        }
        return this.flightManager.bookFlight(flight, passenger);
    }

    // TODO maybe to go over the whole sub-companies and check if the flight is there
    // Only someone that was one flight can cancel it
    public boolean cancelFlight(Flight flight, Passengers passengers, boolean subscribe) {
        if (subscribe) { // And this will also remove the observer from the list
            removeObserver(passengers, this.ComFlightObservers);
        }
        return this.flightManager.cancelFlight(flight, passengers);
    }

    public void flightCancellation(Flight flight) throws FlightNotExistsException {
        this.flightManager.flightCancellation(flight);
        this.notifyCancel(flight);
    }

    public void flightDelay(Flight flight, double delay) {
        this.flightManager.flightDelay(flight, delay);
        this.notifyDelay(flight, delay);
    }

    public void flightSale(Flight flight, double discount) {
        this.flightManager.flightSale(flight, discount);
        this.notifySale(this.ComFlightObservers, flight, discount);
    }

    /********************************   STRATEGY   ******************************************/

    /**
     * Search for a flight by the search strategy
     *
     * @throws InCorrectInputException
     */
    public void searchFlight() throws InCorrectInputException {
        searchMangers.searchFlights(flights);
    }

    /********************************   COMPOSITE   ******************************************/

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

    public void removeSubCompany(FlightComponent subCompany) {
        subCompanies.remove(subCompany);
    }

    // The toString function will print the flight company data, and if there are sub companies, it will print them too
    @Override
    public String toString() {
        return "FlightCompany{" +
                "companyName='" + companyName + '\'' +
                ", subCompanies=" + subCompanies +
                ", flights=" + flights +
                '}';
    }

    /**
     * This method is for the composite pattern
     */
    // We can play with the numbers for the spaces after it print the data
    @Override
    public void printData() {
        // Print the company name
        System.out.println("Company Name: " + this.companyName);

        // Print the table header
        System.out.format("%-10s %-15s %-15s %-12s %-19s %-15s %-15s %-15s%n", "Flight Nu.", "Source", "Destination", "Price ($)", "Duration (hours)", "Date", "Passengers", "Crewmates");

        // Loop through the list of flights
        for (Flight flight : this.flights) {
            // Print the flight data in a new row of the table
            System.out.format("%-10d %-15s %-15s %-12.2f %-19.2f %-15s %-15d %-17d%n",
                    flight.getFlightNumber(),
                    flight.getSource(),
                    flight.getDest(),
                    flight.getPrice(),
                    flight.getDuration(),
                    flight.getDate(),
                    flight.getNumPassengers(),
                    flight.getNumCrewmates());
        }

        // If there are sub-companies, print their data as well
        if (subCompanies.size() > 0) {
            System.out.println("\nSub Companies: ");
            for (FlightComponent subCompany : subCompanies) {
                System.out.println();
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

    /********************************   OBSERVER   ******************************************/
    // Observer pattern methods by FlightObserverManager
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
    public void notifySale(List<FlightObserver> ComFlightObservers, Flight flight, double discount) {
        this.flightObserverManager.notifySale(ComFlightObservers, flight, discount);
    }

    @Override
    public void removeObserver(FlightObserver observer, List<FlightObserver> ComFlightObservers) {
        this.flightObserverManager.removeObserver(observer, ComFlightObservers);
    }

    /********************************* Getters and Setters *****************************************/

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<FlightComponent> getSubCompanies() {
        return subCompanies;
    }

    public void setSubCompanies(List<FlightComponent> subCompanies) {
        this.subCompanies = subCompanies;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<CompWorker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<CompWorker> workers) {
        this.workers = workers;
    }

    public List<FlightObserver> getComFlightObservers() {
        return ComFlightObservers;
    }

    public void setComFlightObservers(List<FlightObserver> comFlightObservers) {
        ComFlightObservers = comFlightObservers;
    }

    public FlightObserverManager getFlightObserverManager() {
        return flightObserverManager;
    }

    public void setFlightObserverManager(FlightObserverManager flightObserverManager) {
        this.flightObserverManager = flightObserverManager;
    }

    public SearchFlightManager getSearchMangers() {
        return searchMangers;
    }

    public void setSearchMangers(SearchFlightManager searchMangers) {
        this.searchMangers = searchMangers;
    }

    public FlightManager getFlightManager() {
        return flightManager;
    }

    public void setFlightManager(FlightManager flightManager) {
        this.flightManager = flightManager;
    }
}

