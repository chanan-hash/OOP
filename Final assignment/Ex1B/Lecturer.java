package Ex1B;

public class Lecturer extends Teacher implements Active{

    public Lecturer(String name, int id,int workHours) {
        super(name, id, workHours);
    }

    @Override
    public Course defineCourse(String name, CourseType type, int courseNumber, int courseCapacity) {
        Course course = Course.getInstance(name, type, courseNumber, courseCapacity);
        System.out.println("Course " + course.getName() + " defined by " + this.getName());
        return course; // return the course so we know it hase been created
    }
}
