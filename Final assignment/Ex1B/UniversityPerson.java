package Ex1B;

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

    public abstract void printInfo();
}
