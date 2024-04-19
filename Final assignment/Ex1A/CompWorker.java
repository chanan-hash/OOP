package Ex1A;

import Ex1A.WorkerEnums.CompanyWorkers;
import Ex1A.WorkerEnums.CrewRoll;

public class CompWorker extends PersonFlight{
    private CompanyWorkers compWorker;
    private CrewRoll crewRoll; // The role of the crewmate.
    private int crewID;

    // TODO maybe list of flights like for month?

    /**
     * Constructor for a person on a flight.
     *
     * @param name        The name of the person.
     * @param email       The email of the person.
     * @param age         The age of the person.
     * @param phoneNumber The phone number of the person.
     * @param compWorker  The role in the company.
     * @param crewRoll    The role of the crewmate.
     * @param crewID      The ID of the crewmate.
     */
    public CompWorker(String name, String email, int age, int phoneNumber, CompanyWorkers compWorker, CrewRoll crewRoll, int crewID) {
        super(name, email, age, phoneNumber);
        this.compWorker = compWorker;
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

    public CompanyWorkers getCompanyWorker() {
        return compWorker;
    }

    public void setCompanyWorkers(CompanyWorkers compWorker) {
        this.compWorker = compWorker;
    }

    @Override
    public String toString() {
        return "Crewmate{" + super.toString() +
                "crewRoll=" + crewRoll +
                ", crewID=" + crewID +
                '}';
    }
}
