package Ex1B.courseBuilder;

import Ex1B.*;
import Ex1B.Exceptions.NotATeacherException;

import java.util.HashSet;
import java.util.Set;

/**
 * This abstract class is for the teacherable classes aka lecturer and practitioner .
 * They will have to implement the option to define the course
 */
public abstract class Teacher extends UniversityPerson {
    private static Set<Integer> idTeacher = new HashSet<>();
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

    public static Set<Integer> getIdTeacher() {
        return idTeacher;
    }

    // The method to define the course
    // non-private or public function it package private, so only Teacher instances can use it
    public Course defineCourse(String name, int courseID, Lecturer lecturer, Practitioner practitioner, CourseType type, int courseCapacity, UniversityPerson person) throws NotATeacherException {
        Course course = RegisterSystem.getInstance().createCourse(name, courseID, lecturer, practitioner, type, courseCapacity, this);
        System.out.println("Course " + course.getName() + " defined by " + this.getName());
        return course; // return the course so we know it hase been created
    }
}