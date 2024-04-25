package Ex1B;

import java.util.HashMap;
import java.util.Map;

/**
 * This class will be the parent class for the students, lecturers and practitioners.
 * It's union the classes for the registration system.
 */
public abstract class UniversityPerson {
    private static final Map<Integer, UniversityPerson> ID_MAP = new HashMap<>();

    // Attributes, every person has a name and an id to identify by them.
    private String name;
    private int id;

    private String password;

    public UniversityPerson(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Map<Integer, UniversityPerson> getIdMap() {
        return ID_MAP;
    }

    @Override
    public String toString() {
        return "UniversityPerson{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                '}';
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UniversityPerson that = (UniversityPerson) o;
//        return id == that.id && Objects.equals(name, that.name);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, id);
//    }
}
