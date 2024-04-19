package Ex1A;

import Ex1A.PatternsInterfaces.FlightSearchStrategy;

import java.util.List;

public class searchByDestinationStrategy implements FlightSearchStrategy {
    /**
     * Search for flights by destination, such as "Thailand"
     * @param flights
     * @param searchRange
     */
    @Override
    public void search(List<Flight> flights, String searchRange) {
        for (Flight flight : flights) {
            if (flight.getDest().equalsIgnoreCase(searchRange)) {
                System.out.println(flight);
            }
        }
    }
}
