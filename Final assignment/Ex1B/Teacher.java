package Ex1B;

/**
 * This abstract class is for the teacherable classes aka lecturer and practitioner .
 * They will have to implement the option to define the course
 */
public abstract class Teacher {
    private String name;
    private int id;

    private int workHours;

    // Constructor for Teacher class
    public Teacher(String name, int id, int workHours) {
        this.name = name;
        this.id = id;
        this.workHours = workHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    // The method to define the course
    abstract public Course defineCourse(String name, CourseType type, int courseNumber, int courseCapacity);
}
