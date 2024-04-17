package Ex1A;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FlightCompany {
    private String companyName;

    private final List<FlightCompany> subCompanies;
    private final List<Flight> flights;
//    private final Map<Flight, ArrayList<FilghtObserver>> flightObservers;


    public FlightCompany(String companyName){
        this.subCompanies = new ArrayList<>();
        this.flights = new ArrayList<>();
//        this.flightObservers = new HashMap<>();
    }

    public boolean bookFlight(Flight flight, Passengers passengers ,boolean subscribe){
        if(flight.getPassengers().size() < flight.getNumPassengers()){
            flight.getPassengers().add(passengers);
            if (subscribe){
                flight.addObserver((FilghtObserver) passengers); // TODO check the casting
            }
            return true;
        }
        return false;
    }

    // TODO Notify the observer
    public boolean cancelFlight(Flight flight, Passengers passengers){
        if(flight.getPassengers().contains(passengers)){
            flight.getPassengers().remove(passengers);
            flight.removeObserver((FilghtObserver) passengers);
            // Notify the observer
//            flightObservers.get(flight).remove(passengers);
            flight.notifyPassenger(); //TODO add message of canceling
            return true;
        }
        return false;
    }

    // TODO add flight function
        /*
    printData(){
        print the data of the curr company

        if we have sub companies:
            for each sub_company
                print the data of each sub company
     */


}
