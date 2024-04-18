package Ex1A;

import java.util.List;

public interface FlightSearchStrategy {
    /**
     * This method will search for the flights according to the search criteria Price/Destination/Date
     * @param flights
     * @param searchRange
     */
    public void search(List<Flight> flights,String searchRange);
    // The main idea is to go over the list and to sort according to the strategy and print to the user
}
