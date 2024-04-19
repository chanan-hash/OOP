package Ex1A;

import java.util.ArrayList;
import java.util.List;

/**
 * Like the Register system class ans we can use here the faced pattern, and singelton pattern
 */

public class Airport {
    private static Airport instance;

    private String name;

    private static List<FlightCompany> flightCompanies = new ArrayList<>();

    private static List<Flight> incomingFlights = new ArrayList<>();
    private static List<Flight> outgoingFlights = new ArrayList<>();

    private Airport(String name) {
        this.name = name;
    }

    public static Airport getInstace(String name) {
        if (instance == null) {
            instance = new Airport(name);
        }
        return instance;
    }

    public void addFlightCompany(FlightCompany flightCompany) {
        flightCompanies.add(flightCompany);
    }

    public void addIncomingFlight(Flight flight) {
        incomingFlights.add(flight);
    }

    public void addOutgoingFlight(Flight flight) {
        outgoingFlights.add(flight);
    }

    public static Airport getInstance() {
        return instance;
    }

    public static void setInstance(Airport instance) {
        Airport.instance = instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<FlightCompany> getFlightCompanies() {
        return flightCompanies;
    }

    public static void setFlightCompanies(List<FlightCompany> flightCompanies) {
        Airport.flightCompanies = flightCompanies;
    }

    public static List<Flight> getIncomingFlights() {
        return incomingFlights;
    }

    public static void setIncomingFlights(List<Flight> incomingFlights) {
        Airport.incomingFlights = incomingFlights;
    }

    public static List<Flight> getOutgoingFlights() {
        return outgoingFlights;
    }

    public static void setOutgoingFlights(List<Flight> outgoingFlights) {
        Airport.outgoingFlights = outgoingFlights;
    }
}