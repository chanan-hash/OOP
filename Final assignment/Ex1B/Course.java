package Ex1B;

import java.util.HashMap;
import java.util.Map;

public class Course {
    private static final Map<String, Course> courseMap = new HashMap<>(); // for saving defined courses, this is an kind of flyweight pattern
    private final String name; // to be immutable

    private CourseType type; // An enum for type

    private int courseNumber;

    private int courseCapacity;

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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getCourseCapacity() {
        return courseCapacity;
    }

    public void setCourseCapacity(int courseCapacity) {
        this.courseCapacity = courseCapacity;
    }

    /***
     * Incrementing course capacity by 1
     */
    public void addStudent() {
        courseCapacity++;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", courseNumber=" + courseNumber +
                '}';
    }
}