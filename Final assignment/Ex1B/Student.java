package Ex1B;

import java.util.ArrayList;
import java.util.List;

public class Student extends UniversityPerson {

    private List<Course> courses; // courses that student registered

    public Student(String name, int id) {
        super(name, id);
        List<Course> courses = new ArrayList<>();
    }

    public boolean registerCourse(Course course) {
        // Check if the course is full
        if (course.addStudent()) {
            courses.add(course);
            System.out.println(this.getName() + " registered to " + course.getName());
            return true;
        } else {
            // TODO add to observer to check when there is place available
            System.out.println("Course is full, " + this.getName() + " could not register to " + course.getName());
            return false;
        }
    }
    public void unsignCourse(Course course) {
        courses.remove(course);
        course.removeStudent();
        System.out.println(this.getName() + " unregistered from " + course.getName());
        // TODO add to observer to check when there is place available
    }

    @Override
    public void printInfo() {
        System.out.println("Student: " + this.getName() + " with id: " + this.getId());
    }

    /**
     * Observer pattern, printing the courses that student registered
     */
}