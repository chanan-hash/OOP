package Ex1A;

import Ex1A.PatternsInterfaces.FlightSearchStrategy;

import java.util.List;
import java.time.LocalDate;

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

    // By converting the input date strings into LocalDate objects,
    // we can use the isBefore() and isAfter() methods to check if the given date is within the range
    public boolean isBetween(String[] date1, String[] date2, String[] date) {
        // Convert the input date strings into LocalDate objects
        LocalDate startDate = LocalDate.of(Integer.parseInt(date1[2]), Integer.parseInt(date1[1]), Integer.parseInt(date1[0]));
        LocalDate endDate = LocalDate.of(Integer.parseInt(date2[2]), Integer.parseInt(date2[1]), Integer.parseInt(date2[0]));
        LocalDate givenDate = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));

        // Check if the given date is within the range
        return !givenDate.isBefore(startDate) && !givenDate.isAfter(endDate);
    }
//    public boolean isBetween(String[] date1, String[] date2, String[] date) {
//        // first date
//        int day1 = Integer.parseInt(date1[0]);
//        int month1 = Integer.parseInt(date1[1]);
//        int year1 = Integer.parseInt(date1[2]);
//
//        // second date
//        int day2 = Integer.parseInt(date2[0]);
//        int month2 = Integer.parseInt(date2[1]);
//        int year2 = Integer.parseInt(date2[2]);
//
//        // flight date
//        int day = Integer.parseInt(date[0]);
//        int month = Integer.parseInt(date[1]);
//        int year = Integer.parseInt(date[2]);
//
//        if (year >= year1 && year <= year2) {
//            if (month >= month1 && month <= month2) {
//                if (day >= day1 && day <= day2) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

}
