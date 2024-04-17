package Ex1A;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Flight implements FlightSubject {
    // Variables
    private String source;
    private String dest;
    private double price; // in dollars
    private String date; // in format "dd/mm/yyyy"
    private int numPassengers; // maximum number of passengers to be allowed
    private int numCrewmates;

    // Lists of flights data, each flight has a list of passengers and crewmates
    private final List<Passengers> passengers; // for each flight, we have a list of passengers
    private final List<Crewmate> crewmates; // for each flight, we have a list of crewmates
    private final List<FilghtObserver> flightObservers = new ArrayList<FilghtObserver>();

    // Constructor
    public Flight(String source, String dest, double price, String date, int numPassengers, int numCrewmates) {
        this.source = source;
        this.dest = dest;
        this.price = price;
        this.date = date;
        this.numPassengers = numPassengers;
        this.numCrewmates = numCrewmates;
        this.passengers = new ArrayList<Passengers>();
        this.crewmates = new ArrayList<Crewmate>();
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

    public List<Crewmate> getCrewmates() {
        return crewmates;
    }

    public List<FilghtObserver> getFlightObservers() {
        return flightObservers;
    }

    // Implementing the methods of the interface
    @Override
    public void addObserver(FilghtObserver observer) {
        if (!this.flightObservers.contains(observer)) {
            this.flightObservers.add(observer);
        }
    }

    @Override
    public void notifyPassenger() {
        for (FilghtObserver observer : flightObservers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(FilghtObserver observer) {
        this.flightObservers.remove(observer);
    }
}
