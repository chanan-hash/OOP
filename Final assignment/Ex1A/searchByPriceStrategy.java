package Ex1A;

import java.util.List;

// TODO need to get the price range
public class searchByPriceStrategy implements FlightSearchStrategy{
    /**
     * This method sorts the list of flights by price and prints it to the user
     * The input string will be in this format to get the price range: (start, end)
     * @param flights
     * @param searchRange
     */
    @Override
    public void search(List<Flight> flights, String searchRange) {
        String [] priceRange = searchRange.split(",");
        double start = Double.parseDouble(priceRange[0].substring(1));
        double end = Double.parseDouble(priceRange[1].substring(0, priceRange[1].length()-1));

        // TODO can add List to sort according to the price
        for (Flight flight : flights) {
            if (flight.getPrice() >= start && flight.getPrice() <= end) {
                System.out.println(flight);
            }
        }
    }
}
