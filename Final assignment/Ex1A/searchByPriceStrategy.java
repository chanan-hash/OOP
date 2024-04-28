package Ex1A;

import Ex1A.PatternsInterfaces.FlightSearchStrategy;

import java.util.List;

/**
 * This class is an implementation of the FlightSearchStrategy interface.
 * By getting a list of flight and string we'll search a flight according to price range.
 */

public class searchByPriceStrategy implements FlightSearchStrategy {
    /**
     * This method sorts the list of flights by price and prints it to the user
     * The input string will be in this format to get the price range: (start, end)
     *
     * @param flights
     * @param searchRange
     */
    @Override
    public void search(List<Flight> flights, String searchRange) {
        String[] priceRange = searchRange.split(","); // [start, end]
        double start = Double.parseDouble(priceRange[0]); // Convert the string to double
        double end = Double.parseDouble(priceRange[1]); // Convert the string to double
        flights.sort((f1, f2) -> Double.compare(f1.getPrice(), f2.getPrice())); // Sort the flights by price
        for (Flight flight : flights) {
            if (flight.getPrice() >= start && flight.getPrice() <= end) {
                System.out.println(flight);
            }
        }
    }
}
