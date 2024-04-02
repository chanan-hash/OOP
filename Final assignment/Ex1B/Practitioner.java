package Ex1B;

public class Practitioner extends Teacher{

        public Practitioner(String name, int id,int workHours) {
            super(name, id, workHours);
        }

        @Override
        public Course defineCourse(String name, CourseType type, int courseNumber, int courseCapacity) {
            Course course = new Course(name, type, courseNumber, courseCapacity);
            System.out.println("Course " + course.getName() + " defined by " + this.getName());
            return course; // return the course so we know it hase been created
        }
}
