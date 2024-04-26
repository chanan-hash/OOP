package Ex1B;

import Ex1B.Exceptions.*;
import Ex1B.courseBuilder.*;

/**
 * This main class for to show how does the program work
 */

public class Main {
    public static void main(String[] args) throws NotATeacherException, IncorrectPasswordException {
        // First creating the register-system;
        RegisterSystem registerSystem = RegisterSystem.getInstance();
        System.out.println("RegisterSystem created" + registerSystem);

        // Singleton pattern - they'll have the same address in the memory
        RegisterSystem registerSystem2 = RegisterSystem.getInstance();
        System.out.println("RegisterSystem created" + registerSystem2);

        // Creating 3 students
        Student student1 = Student.createStudent("John", 123, "123");
        Student student2 = Student.createStudent("Jane", 124, "124");
        Student student3 = Student.createStudent("Jack", 125, "125");

        System.out.println("Student1: " + student1);
        System.out.println("Student2: " + student2);
        System.out.println("Student3: " + student3);

        try {
            // Trying to create a student with the same ID
            Student student4 = Student.createStudent("Tom", 123, "123");
        } catch (IdTakenException e) {
            System.out.println(e.getMessage());
        }

        // Creating 2 Lecturers
        Lecturer lecturer1 = Lecturer.createLecturer("Yossi", 1, "1", 7);
        Lecturer lecturer2 = Lecturer.createLecturer("Dani", 2, "2", 8);

        try { // Trying to create a lecturer with the same ID
            Lecturer lecturer3 = Lecturer.createLecturer("Noam", 2, "5", 4);
        } catch (IdTakenException e) {
            System.out.println(e.getMessage());
        }

        // Creating 2 practitioners
        Practitioner practitioner1 = Practitioner.createPractitioner("Moshe", 3, "33", 5);
        Practitioner practitioner2 = Practitioner.createPractitioner("David", 4, "44", 6);

        try { // Trying to create a practitioner with the same ID
            Practitioner practitioner3 = Practitioner.createPractitioner("Moshe", 4, "55", 9);
        } catch (IdTakenException e) {
            System.out.println(e.getMessage());
        }

        // Adding everyone to the register system
        // Adding the students
        registerSystem.singIn(123, "123");
        registerSystem.singIn(124, "124");
        registerSystem2.singIn(125, "125"); // showing the singleton pattern

        // Adding the lecturers
        registerSystem.singIn(1, "1");
        registerSystem2.singIn(2, "2"); // showing the singleton pattern

        // Adding the practitioners
        registerSystem.singIn(3, "33");
        registerSystem2.singIn(4, "44"); // showing the singleton pattern


        // Creating 3 courses, only kind of Teacher class can create courses
        Course course1 = lecturer1.defineCourse("Math", 1, lecturer1, practitioner1, CourseType.REQUIRED, 10, lecturer1);
        Course course2 = lecturer2.defineCourse("History", 2, lecturer2, practitioner2, CourseType.CHOICE, 1, lecturer2);

        System.out.println("Two courses created!");

        // sign-out one the practitioner, and try to create a course, should throw an exception
        registerSystem.singOut(practitioner1);
        try {
            practitioner1.defineCourse("Science", 3, lecturer1, practitioner1, CourseType.REQUIRED, 10, practitioner1);
        } catch (NotLoggedInException e) {
            System.out.println(e.getMessage());
        }

        // Registering the students to the courses, only who is logged in can register for a course
        registerSystem.singOut(student3);
        try {
            registerSystem.registerCourse(course1, student1, true);
            registerSystem.registerCourse(course1, student2, true);
            registerSystem.registerCourse(course1, student3, true);
        } catch (NotLoggedInException e) {
            System.out.println(e.getMessage());
        }

        // Student 3 trying to register the system with wrong password
        try {
            registerSystem.singIn(125, "123");
        } catch (IncorrectPasswordException e) {
            System.out.println(e.getMessage());
        }

        registerSystem.singIn(125, "125");

        // Strategy and observer design patterns
        registerSystem.registerCourse(course2, student1, false);
        registerSystem.registerCourse(course2, student2, true);
        registerSystem.registerCourse(course2, student3, false);

        // Student 1 un-registering from the course 2, so the observer pattern will be triggered notifying only student 2 and not student 3
        registerSystem.unsignedCourse(course2, student1);

    }
}


