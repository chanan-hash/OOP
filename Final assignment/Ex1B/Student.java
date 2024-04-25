package Ex1B;

import Ex1B.Exceptions.IdTakenException;

import java.util.ArrayList;

/**
 * This is the Student class that extends UniversityPerson and implements CourseObserver.
 * It has a private constructor to ensure that there's can't be two students with the same ID.
 */
public class Student extends UniversityPerson implements CourseObserver {

    //    private Set<Course> courses; // courses that student have registered
//    private static Set<Integer> idSet = new HashSet<>(); //  This is a set for keeping all the registered
    private static ArrayList<Integer> idSet = new ArrayList<>(); //  This is a set for keeping all the registered
    private ArrayList<Course> courses; // courses that student have registered
    private NotificationStrategy notificationStrategy = null; // helping us to chose the notification strategy

    private Student(String name, int id, String password) {
        super(name, id, password); // inherits from UniversityPerson
        this.courses = new ArrayList<>(); // course list the student is registered
        //        this.courses = new HashSet<>();

    }

    // This method is used to create a student and add it to the id set, if id is taken throws an exception
    public static Student createStudent(String name, int id, String password) throws IdTakenException {
        if (UniversityPerson.getIdMap().get(id) != null) {
            throw new IdTakenException("This ID is already taken");
        } else {
            Student student = new Student(name, id, password);
            UniversityPerson.getIdMap().put(id,student); // adding to the id set the student id
            return student;
        }
    }

//    public Set<Course> getCourses() {
//        return this.courses;
//    }

    // Getter
    public ArrayList<Course> getCourses() {
        return courses;
    }

    // Setting notification strategy, used for chose notification way
    public void setNotificationStrategy(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    // The way to update the student about available place course
    @Override
    public void update(Course course) {
//        System.out.println("Course: " + course.getName() + ", number: " + course.getCourseID() + " has place available");
        notificationStrategy.notifyStudents(course, this);
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