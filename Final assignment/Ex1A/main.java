package Ex1A;

import Ex1A.FlightsExceptions.*;
import Ex1A.WorkerEnums.CompanyWorkers;
import Ex1A.WorkerEnums.CrewRoll;

public class main {
    public static void main(String[] args) throws NotWorkingHereException, NotCrewFlightException, InCorrectInputException {
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

        // Printing the incoming and outgoing flights'
//        airport.printIncomingFlights();
//        airport.printOutgoingFlights();
        System.out.println();
        // Printing the companies and sub companies flights data by the composite pattern
        elAl.printData();
        arkia.printData();
        israir.printData();

        System.out.println("\nTill here every thing is working fine. Now we will try to add a sub company to a sub company, and it should throw an exception.");

        /**
         * In the following code we will focus on one flight for convenience.
         */

        // Creating 10  CompWorkers
        // Creating 10 CompWorker objects
        CompWorker worker1 = new CompWorker("John Doe", "johndoe@gmail.com", 30, 1234567890, CompanyWorkers.CREW_FLIGHT, CrewRoll.PILOT, 1);
        CompWorker worker2 = new CompWorker("Jane Doe", "janedoe@gmail.com", 28, 1234567891, CompanyWorkers.CREW_FLIGHT, CrewRoll.COPILOT, 2);
        CompWorker worker3 = new CompWorker("Bob Smith", "bobsmith@gmail.com", 32, 1234567892, CompanyWorkers.CREW_FLIGHT, CrewRoll.FLIGHT_ATTENDANT, 3);
        CompWorker worker4 = new CompWorker("Alice Johnson", "alicejohnson@gmail.com", 29, 1234567893, CompanyWorkers.CREW_FLIGHT, CrewRoll.FLIGHT_ATTENDANT, 4);
        CompWorker worker5 = new CompWorker("Charlie Brown", "charliebrown@gmail.com", 35, 1234567894, CompanyWorkers.CREW_FLIGHT, CrewRoll.PILOT, 5);
        CompWorker worker6 = new CompWorker("Megan Davis", "megandavis@gmail.com", 27, 1234567895, CompanyWorkers.CREW_FLIGHT, CrewRoll.COPILOT, 6);
        CompWorker worker7 = new CompWorker("Tom Wilson", "tomwilson@gmail.com", 33, 1234567896, CompanyWorkers.CREW_FLIGHT, CrewRoll.FLIGHT_ATTENDANT, 7);
        CompWorker worker8 = new CompWorker("Emma White", "emmawhite@gmail.com", 31, 1234567897, CompanyWorkers.SIMPLE_WORKER, CrewRoll.FLIGHT_ATTENDANT, 8);
        CompWorker worker9 = new CompWorker("Sam Harris", "samharris@gmail.com", 34, 1234567898, CompanyWorkers.SIMPLE_WORKER, CrewRoll.NONE, 9);
        CompWorker worker10 = new CompWorker("Olivia Martin", "oliviamartin@gmail.com", 26, 1234567899, CompanyWorkers.SIMPLE_WORKER, CrewRoll.NONE, 10);

        // Checking an exception for adding simple worker to a flight
        elAl.addWorker(worker8);
        elAl.addWorker(worker10);
        try {
            elAl.addCrewmate(elAlFlight1, worker8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Showing the exceptions.
//        elAl.addCrewmate(elAlFlight1, worker9); // NotWorkingHereException
//        elAl.addCrewmate(elAlFlight1, worker10); // NotCrewFlightException
        System.out.println("Exception was thrown as expected.");

        // Creating passengers
        // Creating 10 Passengers objects
        Passengers passenger1 = new Passengers("John Doe", "johndoe@gmail.com", 30, 1234567890, 1);
        Passengers passenger2 = new Passengers("Jane Doe", "janedoe@gmail.com", 28, 1234567891, 2);
        Passengers passenger3 = new Passengers("Bob Smith", "bobsmith@gmail.com", 32, 1234567892, 3);
        Passengers passenger4 = new Passengers("Alice Johnson", "alicejohnson@gmail.com", 29, 1234567893, 4);
        Passengers passenger5 = new Passengers("Charlie Brown", "charliebrown@gmail.com", 35, 1234567894, 5);
        Passengers passenger6 = new Passengers("Megan Davis", "megandavis@gmail.com", 27, 1234567895, 6);
        Passengers passenger7 = new Passengers("Tom Wilson", "tomwilson@gmail.com", 33, 1234567896, 7);
        Passengers passenger8 = new Passengers("Emma White", "emmawhite@gmail.com", 31, 1234567897, 8);
        Passengers passenger9 = new Passengers("Sam Harris", "samharris@gmail.com", 34, 1234567898, 9);
        Passengers passenger10 = new Passengers("Olivia Martin", "oliviamartin@gmail.com", 26, 1234567899, 10);

        // Booking a flight
        elAl.bookFlight(elAlFlight1, passenger1, true);
        elAl.bookFlight(elAlFlight1, passenger2, true);
        elAl.bookFlight(elAlFlight1, passenger3, true);
        elAl.bookFlight(elAlFlight1, passenger4, true);
        elAl.bookFlight(elAlFlight1, passenger5, false);
        elAl.bookFlight(elAlFlight1, passenger6, false);

        System.out.println("\nCreating the passengers");

        // searching for a flight
        System.out.println("Searching for a flight:");
        try {
            elAl.searchFlight();
        } catch (InCorrectInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
