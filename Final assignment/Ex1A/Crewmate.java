package Ex1A;

public class Crewmate extends PersonFlight {
    CrewRoll crewRoll;
    private int crewID;

    // TODO maybe list of flights like for month?
    /**
     * Constructor for a person on a flight.
     *
     * @param name        The name of the person.
     * @param email       The email of the person.
     * @param age         The age of the person.
     * @param phoneNumber The phone number of the person.
     * @param crewRoll    The role of the crewmate.
     * @param crewID      The ID of the crewmate.
     */
    public Crewmate(String name, String email, int age, int phoneNumber, CrewRoll crewRoll, int crewID) {
        super(name, email, age, phoneNumber);
        this.crewRoll = crewRoll;
        this.crewID = crewID;
    }


    // Getters and Setters
    public CrewRoll getCrewRoll() {
        return crewRoll;
    }

    public void setCrewRoll(CrewRoll crewRoll) {
        this.crewRoll = crewRoll;
    }

    public int getCrewID() {
        return crewID;
    }

    public void setCrewID(int crewID) {
        this.crewID = crewID;
    }

    @Override
    public String toString() {
        return "Crewmate{" + super.toString() +
                "crewRoll=" + crewRoll +
                ", crewID=" + crewID +
                '}';
    }
}
