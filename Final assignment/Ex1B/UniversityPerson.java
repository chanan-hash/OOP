package Ex1B;

/**
 * This class will be the parent class for the students, lecturers and practitioners.
 * It's union the classes for the registration system.
 */
public abstract class UniversityPerson {
    // Attributes, every person has a name and an id to identify by them.
    private String name;
    private int id;

    public UniversityPerson(String name, int id) {
        this.name = name;
        this.id = id;
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

    @Override
    public String toString() {
        return "UniversityPerson {" +
                "name= '" + name + '\'' +
                ", id= " + id +
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
