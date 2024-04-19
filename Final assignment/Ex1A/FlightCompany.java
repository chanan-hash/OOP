package Ex1A;

import Ex1A.FlightManegers.FlightObserverManager;
import Ex1A.FlightsExceptions.NotCrewFlightException;
import Ex1A.FlightsExceptions.NotWorkingHereException;
import Ex1A.PatternsInterfaces.FlightComponent;
import Ex1A.PatternsInterfaces.FlightObserver;
import Ex1A.PatternsInterfaces.FlightSearchStrategy;
import Ex1A.PatternsInterfaces.FlightSubject;
import Ex1A.WorkerEnums.CompanyWorkers;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class FlightCompany implements FlightComponent, FlightSubject {
    private String companyName;
    private FlightSearchStrategy searchStrategy;

    private final List<FlightComponent> subCompanies;
    private final List<Flight> flights;
    private final List<CompWorker> workers;

    private final List<FlightObserver> ComFlightObservers;  // The observers looking on the company updates
    private final FlightObserverManager flightObserverManager; // An observer manager to manage the observers

    public FlightCompany(String companyName) {
        this.subCompanies = new ArrayList<>();
        this.flights = new ArrayList<>();
        this.workers = new ArrayList<>();
        this.ComFlightObservers = new ArrayList<>();
        this.flightObserverManager = new FlightObserverManager();
    }

    public boolean bookFlight(Flight flight, Passengers passenger, boolean subscribe) {
        if (flight.getPassengers().size() < flight.getNumPassengers()) {
            flight.getPassengers().add(passenger);
            if (subscribe) {
               addObserver((FlightObserver) passenger,this.ComFlightObservers); // TODO check the casting
            }
            return true;
        }
        return false;
    }

    // TODO maybe to go over the whole subcompenies and check if the flight is there
    // Only someone that was one flight cna cancel it
    public boolean cancelFlight(Flight flight, Passengers passengers, boolean subscribe) {
        if (!flight.getPassengers().contains(passengers)) {
            flight.getPassengers().remove(passengers);
        }
        if (subscribe) {
            removeObserver((FlightObserver) passengers, this.ComFlightObservers); // TODO check the casting
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


    // The composite pattern function
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


    /**
     * Strategy pattern for searching the flights.
     * in the beginning we are setting the strategy type
     * then we are searching the flights by the strategy while running the program
     */
    public void setStrategy(FlightSearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    /**
     * Acorrding to user input we'll search the flights
     * Input: Price/Destination/Date
     * for each one we'll have a different strategy amd range to search
     *
     * @throws InterruptedException
     */
    public void search() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the search criteria: Price/Destination/Date");
        String search = scanner.nextLine();
        String searchRange = "";
        if (search.equalsIgnoreCase("Price")) {
            setStrategy(new searchByPriceStrategy());
            System.out.println("Enter the price range: start,end");
            searchRange = scanner.nextLine();
            if (!searchRange.equalsIgnoreCase("(\\d+),(\\d+)")) {
                throw new InterruptedException("The price range is not in the correct format");
            }
        } else if (search.equalsIgnoreCase("Destination")) {
            setStrategy(new searchByDestinationStrategy());
            System.out.println("Enter the destination: ");
            searchRange = scanner.nextLine();
        } else if (search.equalsIgnoreCase("Date")) {
            setStrategy(new searchByDateStrategy());
            System.out.println("Enter the date in dd/mm/yyyy,dd/mm/yyyy , format: ");
            searchRange = scanner.nextLine();
            if (searchRange.equalsIgnoreCase("\\d{2}/\\d{2}/\\d{4},\\d{2}/\\d{2}/\\d{4}")) {
                throw new InterruptedException("The date is not in the correct format");
            }
        } else {
            throw new InterruptedException("The search criteria is not in the correct format");
        }

        searchStrategy.search(flights, searchRange); // Because we've done set strategy we know which one to chose/go
    }


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

    public FlightSearchStrategy getSearchStrategy() {
        return searchStrategy;
    }

    public void setSearchStrategy(FlightSearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
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

