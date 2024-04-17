package Ex1A;

/**
 * This class represents a person that is on a flight can be either a crewmate or a passenger.
 */
public abstract class PersonFlight implements FlightObserver {
    private String name;
    private String email;
    private int age;
    private int phoneNumber;

    /**
     * Constructor for a person on a flight.
     *
     * @param name        The name of the person.
     * @param email       The email of the person.
     * @param age         The age of the person.
     * @param phoneNumber The phone number of the person.
     */
    public PersonFlight(String name, String email, int age, int phoneNumber) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter and setter methods for the class attributes.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PersonFlight{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    @Override
    public void update(Flight flight) {
        flight.notifyPassenger();
    }
}