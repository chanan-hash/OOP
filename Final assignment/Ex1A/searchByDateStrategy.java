package Ex1A;

import java.util.List;

public class searchByDateStrategy implements FlightSearchStrategy {
    /**
     * Search for flights by date, such as "25/12/2021"
     *
     * @param flights
     * @param searchRange
     */
    @Override
    public void search(List<Flight> flights, String searchRange) {
        String[] dateRange = searchRange.split(","); // [dd/mm/yyyy, dd/mm/yyyy]
        String[] date1 = dateRange[0].split("/"); // [dd, mm, yyyy]
        String[] date2 = dateRange[1].split("/"); // [dd, mm, yyyy]

        for (Flight flight : flights) {
            String[] flightDate = flight.getDate().split("/"); // [dd, mm, yyyy]
            if (isBetween(date1, date2, flightDate)) {
                System.out.println(flight);
            }
        }
    }

    public boolean isBetween(String[] date1, String[] date2, String[] date) {
        // first date
        int day1 = Integer.parseInt(date1[0]);
        int month1 = Integer.parseInt(date1[1]);
        int year1 = Integer.parseInt(date1[2]);

        // second date
        int day2 = Integer.parseInt(date2[0]);
        int month2 = Integer.parseInt(date2[1]);
        int year2 = Integer.parseInt(date2[2]);

        // flight date
        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);

        if (year >= year1 && year <= year2) {
            if (month >= month1 && month <= month2) {
                if (day >= day1 && day <= day2) {
                    return true;
                }
            }
        }
        return false;
    }

}
