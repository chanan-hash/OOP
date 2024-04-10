package Ex1B;

import java.util.HashSet;
import java.util.Set;

/**
 * This abstract class is for the teacherable classes aka lecturer and practitioner .
 * They will have to implement the option to define the course
 */
// TODO maybe add like in the Students Creeating only by single ID
public abstract class Teacher extends UniversityPerson {
    //    private static Set<Integer> idTeacher = new HashSet<>();
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
    public Course defineCourse(String name, int courseID, Lecturer lecturer, Practitioner practitioner, CourseType type, int courseNumber, int courseCapacity) {
        Course course = Course.getInstance(name, courseID, lecturer, practitioner, type, courseNumber, courseCapacity);
        System.out.println("Course " + course.getName() + " defined by " + this.getName());
        return course; // return the course so we know it hase been created
    }
}