package Ex1A;

public interface FlightSubject {

    void addObserver(FilghtObserver observer);

    void notifyPassenger();
    void removeObserver(FilghtObserver observer);

}
