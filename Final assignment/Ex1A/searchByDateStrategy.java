package Ex1A;

import Ex1A.PatternsInterfaces.FlightSearchStrategy;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.time.LocalDate;

/**
 * This class is an implementation of the FlightSearchStrategy interface.
 * By getting a list of flight and string we'll search a flight according to date range in the format "dd/mm/yyyy, dd/mm/yyyy".
 * We're using LocalDate to compare the dates, and for convenience we're converting the input date strings into LocalDate objects.
 */
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

        // Sorting all the flights by date
        flights.sort((flight1, flight2) -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date3 = LocalDate.parse(flight1.getDate(), formatter);
            LocalDate date4 = LocalDate.parse(flight2.getDate(), formatter);
            return date3.compareTo(date4);
        });

        for (Flight flight : flights) { // printing all the flights between thw range
            String[] flightDate = flight.getDate().split("/"); // [dd, mm, yyyy]
            if (isBetween(date1, date2, flightDate)) {
                System.out.println(flight);
            }
        }
    }

    // By converting the input date strings into LocalDate objects,
    // we can use the isBefore() and isAfter() methods to check if the given date is within the range.
    public boolean isBetween(String[] date1, String[] date2, String[] date) {
        // Convert the input date strings into LocalDate objects
        LocalDate startDate = LocalDate.of(Integer.parseInt(date1[2]), Integer.parseInt(date1[1]), Integer.parseInt(date1[0]));
        LocalDate endDate = LocalDate.of(Integer.parseInt(date2[2]), Integer.parseInt(date2[1]), Integer.parseInt(date2[0]));
        LocalDate givenDate = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));

        // Check if the given date is within the range, by inbuilt methods isBefore() and isAfter()
        return !givenDate.isBefore(startDate) && !givenDate.isAfter(endDate);
    }

//    public void sortFlightsByDate(List<Flight> flights) {
//        Collections.sort(flights, (flight1, flight2) -> {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            LocalDate date1 = LocalDate.parse(flight1.getDate(), formatter);
//            LocalDate date2 = LocalDate.parse(flight2.getDate(), formatter);
//            return date1.compareTo(date2);
//        });
//    }

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
