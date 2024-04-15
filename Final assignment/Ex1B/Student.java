package Ex1B;

import Ex1B.Exceptions.IdTakenException;

import java.util.*;

public class Student extends UniversityPerson implements CourseObserver {

//    private Set<Course> courses; // courses that student have registered
//    private static Set<Integer> idSet = new HashSet<>(); //  This is a set for keeping all the registered
    private static ArrayList<Integer> idSet = new ArrayList<>(); //  This is a set for keeping all the registered
    private ArrayList<Course> courses; // courses that student have registered
    private NotificationStrategy notificationStrategy = null;

    private Student(String name, int id) {
        super(name, id);
//        this.courses = new HashSet<>();
        this.courses = new ArrayList<>();
    }

    public static Student createStudent(String name, int id) throws IdTakenException {
        if (idSet.contains(id)) {
            throw new IdTakenException("This ID is already taken");
        } else {
            idSet.add(id); // adding to the id set the student id
            return new Student(name, id);
        }
    }

//    public Set<Course> getCourses() {
//        return this.courses;
//    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void setNotificationStrategy(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    @Override
    public void update(Course course) {
//        System.out.println("Course: " + course.getName() + ", number: " + course.getCourseID() + " has place available");
        notificationStrategy.notifyStudents(course,this);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return Objects.equals(courses, student.courses);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(courses);
//    }
}