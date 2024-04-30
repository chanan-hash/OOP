package Ex1A;

import Ex1A.FlightsExceptions.*;
import Ex1A.WorkerEnums.CompanyWorkers;
import Ex1A.WorkerEnums.CrewRoll;

public class main {
    public static void main(String[] args) throws NotWorkingHereException, NotCrewFlightException, InCorrectInputException, FlightNotExistsException {

        // Creating the airport - singleton
        Airport airport = Airport.getInstace("Ben Gurion");

        // Creating the flight companies
        FlightCompany elAl = new FlightCompany("El Al");
        FlightCompany arkia = new FlightCompany("Arkia");

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

        // Adding the companies to the airport's company list
        airport.addFlightCompany(elAl);
        airport.addFlightCompany(arkia);

        // Creating flights 2 for each company, and 2 for each sub-company

        // Creating 2 flights for each main company
        Flight elAlFlight1 = elAl.createFlights("Tel Aviv", "New York", 1000, 12, "01/01/2023", 200, 10, 101);
        Flight elAlFlight2 = elAl.createFlights("Tel Aviv", "London", 500, 5, "02/02/2023", 200, 10, 102);

        Flight arkiaFlight1 = arkia.createFlights("Tel Aviv", "Eilat", 100, 1, "04/04/2023", 100, 5, 201);
        Flight arkiaFlight2 = arkia.createFlights("Tel Aviv", "Haifa", 50, 0.5, "05/05/2023", 100, 5, 202);

        // Creating 2 flights for each subcompany
        Flight elAlCargoFlight1 = elAlCargo.createFlights("Tel Aviv", "New York", 2000, 12, "10/10/2023", 0, 5, 104);
        Flight elAlCargoFlight2 = elAlCargo.createFlights("Tel Aviv", "London", 1000, 5, "11/11/2023", 0, 5, 105);

        Flight elAlPassengerFlight1 = elAlPassenger.createFlights("Tel Aviv", "Paris", 400, 4, "12/12/2023", 200, 10, 106);
        Flight elAlPassengerFlight2 = elAlPassenger.createFlights("Tel Aviv", "Berlin", 500, 5, "01/01/2024", 200, 10, 107);

        Flight arkiaCargoFlight1 = arkiaCargo.createFlights("Tel Aviv", "Eilat", 200, 1, "02/02/2024", 0, 3, 204);
        Flight arkiaCargoFlight2 = arkiaCargo.createFlights("Tel Aviv", "Haifa", 100, 0.5, "03/03/2024", 0, 3, 205);

        Flight arkiaPassengerFlight1 = arkiaPassenger.createFlights("Tel Aviv", "Jerusalem", 50, 0.5, "04/04/2024", 100, 5, 206);
        Flight arkiaPassengerFlight2 = arkiaPassenger.createFlights("Tel Aviv", "Eilat", 100, 1, "05/05/2024", 100, 5, 207);

        // Printing the incoming and outgoing flights'
        airport.addIncomingFlight(elAlFlight1);
        airport.addIncomingFlight(elAlFlight2);
        airport.printIncomingFlights();

        airport.addOutgoingFlight(arkiaFlight1);
        airport.addOutgoingFlight(arkiaFlight2);
        airport.printOutgoingFlights();
        System.out.println();
        // Printing the companies and sub companies flights data by the composite pattern, we can print only one company data
        elAl.printData();

        airport.printCompaniesData(); // Using the composite pattern to print all companies and sub companies data

        /**
         * In the following code we will focus on one flight for convenience.
         */

        // Creating 5 CompWorkers
        CompWorker worker1 = new CompWorker("John Doe", "johndoe@gmail.com", 30, 1234567890, CompanyWorkers.CREW_FLIGHT, CrewRoll.PILOT, 1);
        CompWorker worker2 = new CompWorker("Jane Doe", "janedoe@gmail.com", 28, 1234567891, CompanyWorkers.CREW_FLIGHT, CrewRoll.COPILOT, 2);
        CompWorker worker3 = new CompWorker("Bob Smith", "bobsmith@gmail.com", 32, 1234567892, CompanyWorkers.CREW_FLIGHT, CrewRoll.FLIGHT_ATTENDANT, 3);

        // We can put null at crew roll, like in sql database that we can put null in the table in some attributes
        CompWorker worker4 = new CompWorker("Alice Johnson", "alicejohnson@gmail.com", 29, 1234567893, CompanyWorkers.SIMPLE_WORKER, null, 4);
        CompWorker worker5 = new CompWorker("Charlie Brown", "charliebrown@gmail.com", 35, 1234567894, CompanyWorkers.SIMPLE_WORKER, null, 5);

        // Checking an exception for adding simple worker to a flight
        elAl.addWorker(worker4, true);
        elAl.addWorker(worker5, true);

        try {
            elAl.addCrewmate(elAlFlight1, worker4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Showing the exceptions.
        try {
            elAl.addCrewmate(elAlFlight1, worker2); // NotWorkingHereException
        } catch (NotWorkingHereException e) {
            System.out.println(e.getMessage());
        }

        // Creating passengers
        Passengers passenger1 = new Passengers("John Doe", "johndoe@gmail.com", 30, 1234567890, 1);
        Passengers passenger2 = new Passengers("Jane Doe", "janedoe@gmail.com", 28, 1234567891, 2);
        Passengers passenger3 = new Passengers("Bob Smith", "bobsmith@gmail.com", 32, 1234567892, 3);

        // Booking a flight
        elAl.bookFlight(elAlFlight1, passenger1, true);
        elAl.bookFlight(elAlFlight1, passenger2, true);
        elAl.bookFlight(elAlFlight1, passenger3, false);

        System.out.println("\nCreating the passengers");

        /**
         * Searching flights according to the strategy pattern
         */

//        System.out.println("Searching for a flight:");
//        try {
//            elAl.searchFlight();
//        } catch (InCorrectInputException e) {
//            System.out.println(e.getMessage());
//        }

        System.out.println("\nChecking the observer pattern:\n");

        // Adding passengers and crewmate to a flight
        elAl.addWorker(worker1, true);
        elAl.addWorker(worker2, true);
        elAl.addWorker(worker3, false);


        // Adding the crewmates to the flight
        elAl.addCrewmate(elAlFlight1, worker1);
        elAl.addCrewmate(elAlFlight1, worker2);
        elAl.addCrewmate(elAlFlight1, worker3);
//         Checking delay notification
        System.out.println("Checking the delay notification:\n");
        elAl.notifyDelay(elAlFlight1, 2); // Should notify all the crewmates and passengers
//         Need to print 3 + 3 = 6 notifications for each passenger and crewmate on the flight

        // Checking cancel notification
        System.out.println("Checking the cancel notification:\n");
        elAl.flightCancellation(elAlFlight1); // Should notify all the crewmates and passengers
        // Need to print 3 + 3 = 6 notifications for each passenger and crewmate on the flight
        try {
            elAl.flightCancellation(elAlFlight1); // Should be an exception
        }catch (FlightNotExistsException e){
            System.out.println(e.getMessage());
        }

        // Checking sale notification
        System.out.println("Checking the sale notification:\n");
        System.out.println("Before the sale: " + elAlFlight1.getPrice());
        elAl.flightSale(elAlFlight1, 10); // Should notify all the passengers that are subscribed (2 + 4 = 6)
        System.out.println("\nAfter the sale: " + elAlFlight1.getPrice());
    }
}
