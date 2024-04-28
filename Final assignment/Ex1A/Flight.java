package Ex1A;

import java.util.List;
import java.util.ArrayList;

/**
 * This class represents a simple flight.
 */
public class Flight {

    // Attributes
    private String source;
    private String dest;
    private String date; // in format "dd/mm/yyyy"
    private double price; // in dollars
    private double duration; // in hours
    private int numPassengers; // maximum number of passengers to be allowed
    private int numCrewmates; // maximum number of crewmates to be allowed
    private int flightNumber;

    // Lists of flights data, each flight has a list of passengers and crewmates
    private final List<Passengers> passengers; // for each flight, we have a list of passengers
    private final List<CompWorker> crewmates; // for each flight, we have a list of crewmates

    // Constructor
    public Flight(String source, String dest, double price ,double duration , String date, int numPassengers, int numCrewmates, int flightNumber) {
        this.source = source;
        this.dest = dest;
        this.price = price;
        this.date = date;
        this.duration = duration;
        this.numPassengers = numPassengers;
        this.numCrewmates = numCrewmates;
        this.flightNumber = flightNumber;
        this.passengers = new ArrayList<Passengers>();
        this.crewmates = new ArrayList<CompWorker>();
    }

    // Getters and Setters
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    public int getNumCrewmates() {
        return numCrewmates;
    }

    public void setNumCrewmates(int numCrewmates) {
        this.numCrewmates = numCrewmates;
    }

    // Getters for the lists
    public List<Passengers> getPassengers() {
        return passengers;
    }

    public List<CompWorker> getCrewmates() {
        return crewmates;
    }

    // printing simple data on the flight
    @Override
    public String toString() {
        return "Flight info:" +
                "source='" + source + '\'' +
                ", dest='" + dest + '\'' +
                ", date='" + date + '\'' +
                ", numPassengers=" + numPassengers;
    }
}
