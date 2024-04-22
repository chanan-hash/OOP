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
//        flights.sort((f1, f2) -> f1.getDest().compareTo(f2.getDest()));
        for (Flight flight : flights) {
            if (flight.getDest().equalsIgnoreCase(searchRange)) {
                System.out.println(flight);
            }
        }
    }
}
