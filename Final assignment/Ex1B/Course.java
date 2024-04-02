package Ex1B;

import java.util.HashMap;
import java.util.Map;

public class Course {
    private static final Map<String, Course> courseMap = new HashMap<>(); // for saving defined courses, this is an kind of flyweight pattern
    private final String name; // to be immutable

    private CourseType type; // An enum for type

    private int courseNumber;

    private final int courseCapacity;

    private int placeAvailable = 0;

    // Constructor
    public Course(String name, CourseType type, int courseNumber, int courseCapacity) {
        this.name = name;
        this.type = type;
        this.courseNumber = courseNumber;
        this.courseCapacity = courseCapacity;
    }

    // For flyweight design pattern, creating only one instance if exists
    public static Course getInstance(String name, CourseType type, int courseNumber, int courseCapacity) {
        // Check if the course with the given name already exists
        if (!courseMap.containsKey(name)) {
            // If it doesn't exist, create a new instance and put it into the map
            Course course = new Course(name, type, courseNumber, courseCapacity);
            courseMap.put(name, course);
        }
        // Return the existing instance
        return courseMap.get(name);
    }

    public String getName() {
        return this.name;
    }

    public int getCourseNumber() {
        return this.courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getCourseCapacity() {
        return this.courseCapacity;
    }

    /***
     * Incrementing course place available by 1
     */
    public boolean addStudent() {
        if (this.placeAvailable < this.courseCapacity) {
            this.placeAvailable++;
            return true;
        }
        return false; // No place available in the course
    }

    public void removeStudent() {
        if (this.placeAvailable > 0) {
            this.placeAvailable--;
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", courseNumber=" + courseNumber +
                '}';
    }
}