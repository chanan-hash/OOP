package Ex1B;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int id;

    private List<Course> courses; // courses that student registered

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        List<Course> courses = new ArrayList<>();
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

    public boolean registerCourse(Course course) {
        // Check if the course is full
        if (course.addStudent()) {
            courses.add(course);
            System.out.println(this.name + " registered to " + course.getName());
            return true;
        } else {
            // TODO add here observer for notification
            System.out.println("Course is full, " + this.name + " could not register to " + course.getName());
            return false;
        }
    }

    /**
     * Observer pattern, printing the courses that student registered
     */
}