package Ex1B;

import java.util.*;

public class Course implements Subject {
    private static final Map<Integer, Course> courseMap = new HashMap<>(); // for saving defined courses, this is an kind of flyweight pattern
    private final String name; // to be immutable

    private Lecturer lecturer;


    private Practitioner practitioner;

    private final CourseType type; // An enum for type

    private int courseID;

    private final int courseCapacity;

//        private final Set<Student> students; // set of registered student
    private final ArrayList<Student> students;
//        private final Set<CourseObserver> courseObservers;
    private final ArrayList<CourseObserver> courseObservers;

    private Course(String name, int courseID, Lecturer lecturer, Practitioner practitioner, CourseType type, int courseCapacity) {
        this.name = name;
        this.courseID = courseID;
        this.lecturer = lecturer;
        this.practitioner = practitioner;
        this.courseCapacity = courseCapacity;
        this.type = type;
//        this.students = new HashSet<>(courseCapacity);
//        this.courseObservers = new HashSet<>();
        this.students = new ArrayList<>(courseCapacity);
        this.courseObservers = new ArrayList<>();
    }

    // For flyweight design pattern, creating only one instance if exists
    public static Course getInstance(String name, int courseID, Lecturer lecturer, Practitioner practitioner, CourseType type, int courseCapacity) {
        // Check if the course with the given name already exists
        if (!courseMap.containsKey(courseID)) {
            // If it doesn't exist, create a new instance and put it into the map
            Course course = new Course(name, courseID, lecturer, practitioner, type, courseCapacity);
            courseMap.put(courseID, course);
        }
        // Return the existing instance
        return courseMap.get(courseID);
    }

    public String getName() {
        return this.name;
    }

    public int getCourseID() {
        return this.courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getCourseCapacity() {
        return this.courseCapacity;
    }

    public boolean addStudent(Student student) {
        if (this.students.size() == courseCapacity) {
            return false;
        }
        // if we're using ArrayList
        if (!students.contains(student)) {
            this.students.add(student);
        }
        if (courseObservers.contains(student)) {
            removeObserver(student);
        }
        return true;
    }

    public void removeStudent(Student student) {
        if (students.contains(student)) {
            this.students.remove(student);
//            notifyStudents();
        }
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Practitioner getPractitioner() {
        return practitioner;
    }

    public void setPractitioner(Practitioner practitioner) {
        this.practitioner = practitioner;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", lecturer=" + lecturer +
                ", practitioner=" + practitioner +
                ", type=" + type +
                ", courseID=" + courseID +
                ", courseCapacity=" + courseCapacity +
                ", students=" + students +
                ", courseObservers=" + courseObservers +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Course course = (Course) o;
//        return courseID == course.courseID && courseCapacity == course.courseCapacity && Objects.equals(name, course.name) && Objects.equals(lecturer, course.lecturer) && Objects.equals(practitioner, course.practitioner) && type == course.type && Objects.equals(students, course.students);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, lecturer, practitioner, type, courseID, courseCapacity, students);
//    }

    @Override
    public void addObserver(CourseObserver observer) {
        if (!this.courseObservers.contains(observer)) {
            this.courseObservers.add(observer);
        }
    }

    @Override
    public void notifyStudents() {
        for (CourseObserver observer : courseObservers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(CourseObserver observer) {
        this.courseObservers.remove(observer);
    }
}