package Ex1B;

/**
 * This abstract class is for the teacherable classes aka lecturer and practitioner .
 * They will have to implement the option to define the course
 */
public abstract class Teacher extends UniversityPerson {
    private String name;
    private int id;

    private int workHours;

    // Constructor for Teacher class
    public Teacher(String name, int id, int workHours) {
        super(name, id);
        this.workHours = workHours;
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
