package Ex1B;

import java.util.ArrayList;
import java.util.List;

public class Student implements Active{
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
            // TODO add to observer to check when there is place available
            System.out.println("Course is full, " + this.name + " could not register to " + course.getName());
            return false;
        }
    }
    public void unsignCourse(Course course) {
        courses.remove(course);
        course.removeStudent();
        System.out.println(this.name + " unregistered from " + course.getName());
        // TODO add to observer to check when there is place available
    }


    /**
     * Observer pattern, printing the courses that student registered
     */
}