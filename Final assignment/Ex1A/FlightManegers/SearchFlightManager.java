package Ex1A.FlightManegers;

import Ex1A.Flight;
import Ex1A.FlightsExceptions.InCorrectInputException;
import Ex1A.PatternsInterfaces.FlightSearchStrategy;
import Ex1A.searchByDateStrategy;
import Ex1A.searchByDestinationStrategy;
import Ex1A.searchByPriceStrategy;

import java.util.List;
import java.util.Scanner;

/**
 * This class will handle the search of flights strategy.
 * Instead of having a FlightCompany class that handles the search of flights,
 * we will have a manager that will handle the search of flights strategy.
 */
public class SearchFlightManager {
    private FlightSearchStrategy searchStrategy;

    public SearchFlightManager() {
        this.searchStrategy = null;
    }

    /**
     * Strategy pattern for searching the flights.
     * in the beginning we are setting the strategy type
     * then we are searching the flights by the strategy while running the program
     */
    public void setStrategy(FlightSearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    /**
     * According to user input we'll search the flights
     * Input: Price/Destination/Date
     * for each one we'll have a different strategy amd range to search
     *
     * @throws InterruptedException
     */
    public void searchFlights(List<Flight> flights) throws InCorrectInputException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the search criteria: Price/Destination/Date");
        String search = scanner.nextLine(); // for setting the flight search strategy
        String searchRange = ""; // after we'll have the strategy we need to know the range to search

        // Price
        if (search.equalsIgnoreCase("Price")) {
            setStrategy(new searchByPriceStrategy()); // setting the strategy
            System.out.println("Enter the price range: start,end");
            searchRange = scanner.nextLine();
            if (!searchRange.matches("(\\d+),(\\d+)")) { // allowing us to enter only numbers like 123,456
                throw new InCorrectInputException("The price range is not in the correct format");
            }
        }

        // Destination
        else if (search.equalsIgnoreCase("Destination")) {
            setStrategy(new searchByDestinationStrategy());
            System.out.println("Enter the destination: ");
            searchRange = scanner.nextLine();
        }

        // Date
        else if (search.equalsIgnoreCase("Date")) {
            setStrategy(new searchByDateStrategy());
            System.out.println("Enter the date in dd/mm/yyyy,dd/mm/yyyy , format: ");
            searchRange = scanner.nextLine();
            if (!searchRange.matches("\\d{2}/\\d{2}/\\d{4},\\d{2}/\\d{2}/\\d{4}")) { // allowing us to enter only dates like 01/01/2023,02/02/2023
                throw new InCorrectInputException("The date is not in the correct format");
            }
        }

        // Incorrect input
        else {
            throw new InCorrectInputException("The search criteria is not in the correct format");
        }

        searchStrategy.search(flights, searchRange); // Because we've done set strategy we know which one to chose/go
    }


    // Getters and Setters
    public FlightSearchStrategy getSearchStrategy() {
        return searchStrategy;
    }

    public void setSearchStrategy(FlightSearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }
}
