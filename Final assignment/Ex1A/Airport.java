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
}