package Ex1A;

import Ex1A.PatternsInterfaces.FlightSearchStrategy;

import java.util.List;

// TODO need to get the price range
public class searchByPriceStrategy implements FlightSearchStrategy {
    /**
     * This method sorts the list of flights by price and prints it to the user
     * The input string will be in this format to get the price range: (start, end)
     * @param flights
     * @param searchRange
     */
    @Override
    public void search(List<Flight> flights, String searchRange) {
        String [] priceRange = searchRange.split(",");
        double start = Double.parseDouble(priceRange[0]);
        double end = Double.parseDouble(priceRange[1]);
        flights.sort((f1, f2) -> Double.compare(f1.getPrice(), f2.getPrice()));
        // We can add List to sort according to the price
        for (Flight flight : flights) {
            if (flight.getPrice() >= start && flight.getPrice() <= end) {
                System.out.println(flight);
            }
        }
    }
}
