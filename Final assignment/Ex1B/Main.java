package Ex1B;

import Ex1B.Exceptions.IdTakenException;
import Ex1B.Exceptions.NotATeacherException;
import Ex1B.Exceptions.NotLoggedInException;
import Ex1B.Exceptions.SystemIsFullException;

/**
 * This class will be the main program, it will implement the faced pattern, by simplify the usage fot the students
 */

public class Main {
    public static void main(String[] args) {
        RegisterSystem registerSystem = RegisterSystem.getInstance(); // singleton
        Student chanan = Student.createStudent("chanan", 1234);
        System.out.println(chanan);
        Student yossi = Student.createStudent("yossi", 1235);
        System.out.println(yossi);

//        Student tom = Student.createStudent("Tom", 1234); // will be an Exception
        Student dana = Student.createStudent("Dana", 1236);
        Student yael = Student.createStudent("Yael", 1237);
        Student yuval = Student.createStudent("Yuval", 1238);

    }
}


//public class Main {
//    public static void main(String[] args) {
//        RegisterSystem registerSystem = RegisterSystem.getInstance(); // singleton
//
//        // Create students
//        Student chanan = Student.createStudent("chanan",1234);
//        Student yossi = Student.createStudent("yossi",1235);
//
//        // Create teachers
//        Lecturer lecturer = new Lecturer("Lecturer1", 1111,5);
//        Practitioner practitioner = new Practitioner("Practitioner1", 2222,8);
//
//        // Create a course
//        Course course = null;
//        try {
//            course = Course.getInstance("Course1", 1, lecturer, practitioner, CourseType.CHOICE, 1, 30);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Register students to the system
//        try {
//            registerSystem.singIn(chanan);
//            registerSystem.singIn(yossi);
//        } catch (SystemIsFullException e) {
//            e.printStackTrace();
//        }
//
//        // Register students to the course
//        try {
//            registerSystem.registerCourse(course, chanan, true);
//            registerSystem.registerCourse(course, yossi, true);
//        } catch (NotLoggedInException e) {
//            e.printStackTrace();
//        }
//
//        // Print out the course details
//        System.out.println(course.toString());
//    }
//}
