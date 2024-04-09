package Ex1B;

import java.util.*;

public class Student extends UniversityPerson implements CourseObserver {

    private Set<Course> courses; // courses that student have registered

    public Student(String name, int id) {
        super(name, id);
        courses = new HashSet<>();
    }

    // TODO maybe use flyweight for student

    // TODO can ask the student for input for asking for notification
    public boolean registerCourse(Course course, boolean subscribe) {
        if (course.addStudent(this)) {
            this.courses.add(course);
            return true;
        } else {
            if (subscribe) {
                course.addObserver(this);
            }
            return false;
        }
    }

    public void unsignedCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            course.removeStudent(this);
            System.out.println(this.getName() + " unregistered from " + course.getName());
        }
        System.out.println("The student is not registered to this course");
    }


    @Override
    public void update(Course course) {
        System.out.println("Course: " + course.getName() + ", number: " + course.getCourseID() + " has place available");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(courses, student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courses);
    }
}