package Ex1A;

/**
 * This class represents a person that is on a flight can be either a crewmate or a passenger.
 */
public abstract class PersonFlight {
    private String name;
    private String role;

    /**
     * Constructor for a person on a flight.
     * @param name The name of the person.
     * @param role The role of the person.
     */
    public PersonFlight(String name, String role) {
        this.name = name;
        this.role = role;
    }

    /**
     * Get the name of the person.
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the role of the person.
     * @return The role of the person.
     */
    public String getRole() {
        return role;
    }

    /**
     * Set the name of the person.
     * @param name The name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the role of the person.
     * @param role The role of the person.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Get the string representation of the person.
     * @return The string representation of the person.
     */
    @Override
    public String toString() {
        return "PersonFlight{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
