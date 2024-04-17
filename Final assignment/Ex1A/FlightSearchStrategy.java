package Ex1A;

import java.util.List;

public interface FlightSearchStrategy {
    public void search(List<Flight> flights);
    // TODO allow to search ways for flights, such as price and destination
    // The main idea is to go over the list and to sort according to the strategy and print to the user
}
