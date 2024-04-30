package Ex1A.PatternsInterfaces;

import Ex1A.Flight;

import java.util.List;

/**
 * This interface is used to implement the Strategy Pattern.
 * Each class that implements this interface will have a different search strategy, by filtering the flights according to users input.
 * This method will search,will set the strategy search according to the search criteria Price/Destination/Date
 */
public interface FlightSearchStrategy {
    void search(List<Flight> flights, String searchRange);
}
