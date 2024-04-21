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

        // Creating flights 3, for each company, and 2 for each sub-company

        // Creating 3 flights for each main company
        Flight elAlFlight1 = elAl.createFlights("Tel Aviv", "New York", 1000, 12, "01/01/2023", 200, 10, 101);
        Flight elAlFlight2 = elAl.createFlights("Tel Aviv", "London", 500, 5, "02/02/2023", 200, 10, 102);
        Flight elAlFlight3 = elAl.createFlights("Tel Aviv", "Paris", 400, 4, "03/03/2023", 200, 10, 103);

        Flight arkiaFlight1 = arkia.createFlights("Tel Aviv", "Eilat", 100, 1, "04/04/2023", 100, 5, 201);
        Flight arkiaFlight2 = arkia.createFlights("Tel Aviv", "Haifa", 50, 0.5, "05/05/2023", 100, 5, 202);
        Flight arkiaFlight3 = arkia.createFlights("Tel Aviv", "Jerusalem", 50, 0.5, "06/06/2023", 100, 5, 203);

        Flight israirFlight1 = israir.createFlights("Tel Aviv", "Berlin", 300, 4, "07/07/2023", 150, 7, 301);
        Flight israirFlight2 = israir.createFlights("Tel Aviv", "Rome", 300, 4, "08/08/2023", 150, 7, 302);
        Flight israirFlight3 = israir.createFlights("Tel Aviv", "Madrid", 350, 5, "09/09/2023", 150, 7, 303);

        // Creating 2 flights for each subcompany
        Flight elAlCargoFlight1 = elAlCargo.createFlights("Tel Aviv", "New York", 2000, 12, "10/10/2023", 0, 5, 104);
        Flight elAlCargoFlight2 = elAlCargo.createFlights("Tel Aviv", "London", 1000, 5, "11/11/2023", 0, 5, 105);

        Flight elAlPassengerFlight1 = elAlPassenger.createFlights("Tel Aviv", "Paris", 400, 4, "12/12/2023", 200, 10, 106);
        Flight elAlPassengerFlight2 = elAlPassenger.createFlights("Tel Aviv", "Berlin", 500, 5, "01/01/2024", 200, 10, 107);

        Flight arkiaCargoFlight1 = arkiaCargo.createFlights("Tel Aviv", "Eilat", 200, 1, "02/02/2024", 0, 3, 204);
        Flight arkiaCargoFlight2 = arkiaCargo.createFlights("Tel Aviv", "Haifa", 100, 0.5, "03/03/2024", 0, 3, 205);

        Flight arkiaPassengerFlight1 = arkiaPassenger.createFlights("Tel Aviv", "Jerusalem", 50, 0.5, "04/04/2024", 100, 5, 206);
        Flight arkiaPassengerFlight2 = arkiaPassenger.createFlights("Tel Aviv", "Eilat", 100, 1, "05/05/2024", 100, 5, 207);

        Flight israirCargoFlight1 = israirCargo.createFlights("Tel Aviv", "Berlin", 600, 4, "06/06/2024", 0, 4, 304);
        Flight israirCargoFlight2 = israirCargo.createFlights("Tel Aviv", "Rome", 600, 4, "07/07/2024", 0, 4, 305);

        Flight israirPassengerFlight1 = israirPassenger.createFlights("Tel Aviv", "Madrid", 350, 5, "08/08/2024", 150, 7, 306);
        Flight israirPassengerFlight2 = israirPassenger.createFlights("Tel Aviv", "Paris", 400, 4, "09/09/2024", 150, 7, 307);

        // Printing the airport data
        System.out.println("The airport data:");
        System.out.println(airport);

        // Printing the incoming and outgoing flights
//        airport.printIncomingFlights();
//        airport.printOutgoingFlights();

        // Printing the companies and sub companies flights data by the composite pattern
        elAl.printData();
        arkia.printData();
        israir.printData();

        System.out.println("\nTill here every thing is working fine. Now we will try to add a sub company to a sub company, and it should throw an exception.");

    }
}
