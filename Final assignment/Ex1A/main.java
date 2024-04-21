package Ex1A;

public class main {
    public static void main(String[] args) {
        // Creating the airport
        Airport airport = Airport.getInstace("Ben Gurion");

        // Creating the flight companies
        FlightCompany elAl = new FlightCompany("El Al");
        FlightCompany arkia = new FlightCompany("Arkia");
        FlightCompany israir = new FlightCompany("Israir");

        // Creating the sub companies
        FlightCompany elAlCargo = new FlightCompany("El Al Cargo");
        FlightCompany elAlPassenger = new FlightCompany("El Al Passenger");

        System.out.println("elAl bought 2 sub companies: El Al Cargo and El Al Passenger.");
        elAl.addSubCompany(elAlCargo);
        elAl.addSubCompany(elAlPassenger);

        FlightCompany arkiaCargo = new FlightCompany("Arkia Cargo");
        FlightCompany arkiaPassenger = new FlightCompany("Arkia Passenger");

        System.out.println("Arkia bought 2 sub companies: Arkia Cargo and Arkia Passenger.");
        arkia.addSubCompany(arkiaCargo);
        arkia.addSubCompany(arkiaPassenger);

        FlightCompany israirCargo = new FlightCompany("Israir Cargo");
        FlightCompany israirPassenger = new FlightCompany("Israir Passenger");

        System.out.println("Israir bought 2 sub companies: Israir Cargo and Israir Passenger.");
        israir.addSubCompany(israirCargo);
        israir.addSubCompany(israirPassenger);

        airport.addFlightCompany(elAl);
        airport.addFlightCompany(arkia);
        airport.addFlightCompany(israir);

        // Printing the airport data
        System.out.println("The airport data:");
        System.out.println(airport);

        // Printing the incoming and outgoing flights
        airport.printIncomingFlights();
        airport.printOutgoingFlights();

        // Printing the companies and sub companies flights data by the composite pattern
        elAl.printData();
        arkia.printData();
        israir.printData();

    }
}
