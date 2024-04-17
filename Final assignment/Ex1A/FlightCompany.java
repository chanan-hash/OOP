package Ex1A;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FlightCompany {
    private String companyName;

    private final List<FlightCompany> subCompanies;
    private final List<Flight> flights;
    private final Map<Flight, ArrayList<FilghtObserver>> flightObservers;


    public FlightCompany(String companyName){
        this.subCompanies = new ArrayList<>();
        this.flights = new ArrayList<>();
        this.flightObservers = new HashMap<>();
    }
    /*
    @Override
    public boolean bookFlight(Flight flight, boolean subscribe){
        if(flight.getPassengers().size() < flight.getNumPassengers()){
            flight.getPassengers().add(this);
            if (subscribe){
                flight.addObserver(this);
            }
            return true;
        }
        return false;
    }
     */

        /*
    printData(){
        print the data of the curr company

        if we have sub companies:
            for each sub_company
                print the data of each sub company
     */


}
