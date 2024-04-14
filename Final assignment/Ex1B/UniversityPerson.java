package Ex1B;

import java.util.Objects;

/**
 * It will be an abstract class, because we just want to union the students lecturers and the practitioners, under one title
 */
public abstract class UniversityPerson {
    private String name;
    private int id;

    public UniversityPerson(String name, int id) {
        this.name = name;
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversityPerson that = (UniversityPerson) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
