package Ex1A;

public class Passengers extends PersonFlight implements FlightObserver{

    private int passengerID;
    /**
     * Constructor for a person on a flight.
     *
     * @param name        The name of the person.
     * @param email       The email of the person.
     * @param age         The age of the person.
     * @param phoneNumber The phone number of the person.
     */
    public Passengers(String name, String email, int age, int phoneNumber, int passengerID) {
        super(name, email, age, phoneNumber);
        this.passengerID = passengerID;
    }

    // Getters and Setters
    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    @Override
    public String toString() {
        return "Passengers{" + super.toString() +
                "passengerID=" + passengerID +
                '}';
    }

    @Override
    public void update(String msg) {
        System.out.println(msg);
    }

}
