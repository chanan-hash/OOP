package Ex1A;

import java.util.List;

// TODO need to get the price range
public class searchByPriceStrategy implements FlightSearchStrategy{
    @Override
    public void search(List<Flight> flights) {
        // go over the list and sort according to the strategy and print to the user, and printing it to the user
        flights.sort((f1, f2) -> Double.compare(f1.getPrice(), f2.getPrice()));
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
}
