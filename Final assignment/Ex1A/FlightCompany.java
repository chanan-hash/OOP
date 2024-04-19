package Ex1A;

import Ex1A.FlightsExceptions.NotWorkingHereException;

import java.util.*;

public class FlightCompany implements FlightComponent, FlightSubject {
    private String companyName;
    private FlightSearchStrategy searchStrategy;

    private final List<FlightComponent> subCompanies;
    private final List<Flight> flights;
    private final List<CompWorker> workers;
//    private final Map<Flight, ArrayList<FilghtObserver>> flightObservers;

    private final List<FilghtObserver> flightObservers = new ArrayList<FilghtObserver>(); // The observers looking on the company updates

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

    public boolean addWorker(CompWorker crewmate) {
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
    public boolean addCrewmate(Flight flight, CompWorker crewmate) throws NotWorkingHereException {
        if (!workers.contains(crewmate)) {
            throw new NotWorkingHereException("The crewmate is not working in this company");
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
     * Startegy pattern for searching the flights
     */
    public void setStrategy(FlightSearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

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


    /**
     * Observer pattern
     *
     * @param observer
     */
    @Override
    public void addObserver(FilghtObserver observer) {
        if (!this.flightObservers.contains(observer)) {
            this.flightObservers.add(observer);
        }
    }

    @Override
    public void notifyPassenger() {
        for (FilghtObserver observer : flightObservers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(FilghtObserver observer) {
        this.flightObservers.remove(observer);
    }


}
