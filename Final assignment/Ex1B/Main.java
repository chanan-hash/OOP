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

        // Creating the System
        RegisterSystem registerSystem = RegisterSystem.getInstance(); // singleton

        // Creating the students
        Student chanan = Student.createStudent("chanan", 1234);
        System.out.println(chanan);
        Student yossi = Student.createStudent("yossi", 1235);
        System.out.println(yossi);

//        Student tom = Student.createStudent("Tom", 1234); // will be an Exception
        Student dana = Student.createStudent("Dana", 1236);
        Student yael = Student.createStudent("Yael", 1237);
        Student yuval = Student.createStudent("Yuval", 1238);

        // Creating the teachers
        Lecturer lecturer1 = null;
        try {
            lecturer1 = Lecturer.createLecturer("Lecturer1", 1111, 5);
        } catch (IdTakenException e) {
            e.printStackTrace();
        }
        Lecturer lecturer2 = null;
        try {
            lecturer2 = Lecturer.createLecturer("Lecturer2", 1112, 6);
        } catch (IdTakenException e) {
            e.printStackTrace();
        }
        Lecturer lecturer3 = null;
        try {
            lecturer3 = Lecturer.createLecturer("Lecturer3", 1113, 7);
        } catch (IdTakenException e) {
            e.printStackTrace();
        }

        Practitioner practitioner1 = null;
        try {
            practitioner1 = Practitioner.createPractitioner("Practitioner1", 2222, 8);
        } catch (IdTakenException e) {
            e.printStackTrace();
        }
        Practitioner practitioner2 = null;
        try {
            practitioner2 = Practitioner.createPractitioner("Practitioner2", 2223, 9);
        } catch (IdTakenException e) {
            e.printStackTrace();
        }
        Practitioner practitioner3 = null;
        try {
            practitioner3 = Practitioner.createPractitioner("Practitioner3", 2224, 10);
        } catch (IdTakenException e) {
            e.printStackTrace();
        }

        // Register students to the system
        registerSystem.singIn(chanan);
        registerSystem.singIn(yossi);
        registerSystem.singIn(dana);
        registerSystem.singIn(yael);
        registerSystem.singIn(yuval);

        // To check if they're not logged in and try to register for a course
        registerSystem.singOut(yuval);
        registerSystem.singOut(yael);

        // register the teachers
        registerSystem.singIn(lecturer1);
        registerSystem.singIn(lecturer2);
        registerSystem.singIn(lecturer3);
        registerSystem.singIn(practitioner1);
        registerSystem.singIn(practitioner2);
        registerSystem.singIn(practitioner3);

        // To check if they're not logged in and try to register for a course
        registerSystem.singOut(lecturer3);
        registerSystem.singOut(practitioner3);
        // Creating the courses
        Course course1 = null;
        try {
            course1 = registerSystem.createCourse("Calculus", 1, lecturer1, practitioner1, CourseType.CHOICE, 1, 30, lecturer1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Course course2 = null;
        try {
            course2 = registerSystem.createCourse("Algebra", 2, lecturer2, practitioner2, CourseType.CHOICE, 2, 30, lecturer2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Trying to create a course when he is not a logged in
        Course course3 = null;
        try {
            course3 = registerSystem.createCourse("Geometry", 3, lecturer3, practitioner3, CourseType.CHOICE, 3, 30, practitioner3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Register students to the courses
        try {
            registerSystem.registerCourse(course1, chanan, true);
            registerSystem.registerCourse(course1, yossi, true);
            registerSystem.registerCourse(course2, dana, false);
            registerSystem.registerCourse(course2, yael, true);
            registerSystem.registerCourse(course3, yuval, false);
        } catch (NotLoggedInException e) {
            e.printStackTrace();
        }


    }
}


