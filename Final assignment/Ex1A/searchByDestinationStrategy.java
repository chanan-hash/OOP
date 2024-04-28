package Ex1A;

import Ex1A.PatternsInterfaces.FlightSearchStrategy;

import java.util.List;

/**
 * This class is an implementation of the FlightSearchStrategy interface.
 * By getting a list of flight and string we'll search all the flights according to destination range.
 */

public class searchByDestinationStrategy implements FlightSearchStrategy {
    /**
     * Search for flights by destination, such as "Thailand"
     *
     * @param flights
     * @param searchRange
     */
    @Override
    public void search(List<Flight> flights, String searchRange) {
        for (Flight flight : flights) {
            if (flight.getDest().equalsIgnoreCase(searchRange)) { // print all the flights that have the same destination as the user input
                System.out.println(flight);
            }
        }
    }
}
