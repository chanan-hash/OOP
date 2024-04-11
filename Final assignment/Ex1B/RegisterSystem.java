package Ex1B;

import Ex1B.Exceptions.NotATeacherException;
import Ex1B.Exceptions.NotLoggedInException;
import Ex1B.Exceptions.SystemIsFullException;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

/**
 * This will implement the singleton pattern, to make sure that there is only one register system
 */
public class RegisterSystem {

    private static final RegisterSystem instance = new RegisterSystem();
    private static final int MAX_ACTIVE = 100; // Maximum number of active people
    private static final Set<UniversityPerson> REGISTER_SYSTEM = new HashSet<>(MAX_ACTIVE);
    private static final Set<Course> COURSES_LIST = new HashSet<>();

    // This is for singleton pattern
    public static RegisterSystem getInstance() { // for the singleton pattern
        return instance; // This will always return the same instance
    }


    /**
     * University person registration system
     * return true if there is place in the system, else throws exception
     */
    public boolean singIn(UniversityPerson person) throws SystemIsFullException {
        if (REGISTER_SYSTEM.size() == MAX_ACTIVE) {
            throw new SystemIsFullException("System is full. There is no place right now");
        }
        return REGISTER_SYSTEM.add(person);
    }

    /**
     * singing out form the system, if his not logged in he wouldn't be able to register for the course
     * If the student trying to log out when he is not in the system it'll throw exception
     */
    public boolean singOut(UniversityPerson person) throws NotLoggedInException {
        if (!REGISTER_SYSTEM.contains(person)) {
            throw new NotLoggedInException("You're already not in the system");
        }
        return REGISTER_SYSTEM.remove(person);
    }

    /**
     * For faced we're going to do course registration in the registration system here
     * The student need to be logged in to get access to register the course
     *
     * @param course    to register
     * @param student   the student who wants to register
     * @param subscribe boolean parameter if the student wants to get notification if there's no place in the course
     * @return true/false if it had succeeded.
     */
    public boolean registerCourse(Course course, Student student, boolean subscribe) throws NotLoggedInException {
        if (!REGISTER_SYSTEM.contains(student)) {
            throw new NotLoggedInException("Try to login to register the course");
        } else if (!COURSES_LIST.contains(course)) { // if trying to register to a course that is not in the system
            throw new IllegalArgumentException("The course is not in the system");
        } else if (course.addStudent(student)) {
            student.getCourses().add(course);
            return true;
        } else {
            if (subscribe) {
                course.addObserver(student);

                // Strategy design pattern for how to send notification
                // TODO add to strategy to get course for notification
                Scanner scanner = new Scanner(System.in);
                System.out.println("How would you like to get the notification ? (Email/Sms/Phone)");
                String notificationMethod = scanner.nextLine();
                if (notificationMethod.equalsIgnoreCase("Email")) {
                    student.setNotificationStrategy(new EmailNotificationStrategy());
                } else if (notificationMethod.equalsIgnoreCase("Sms")) {
                    student.setNotificationStrategy(new SmsNotificationStrategy());
                } else if (notificationMethod.equalsIgnoreCase("Phone")) {
                    student.setNotificationStrategy(new PhoneNotificationStrategy());
                }
            }
            return false;
        }
    }

    /**
     * For unregister from the course, we have a function to handle it
     */

    public void unsignedCourse(Course course, Student student) throws NotLoggedInException {
        if (!REGISTER_SYSTEM.contains(student)) {
            throw new NotLoggedInException("Try to login to continue...");
        } else if (student.getCourses().contains(course)) {
            student.getCourses().remove(course);
            course.removeStudent(student);
            course.notifyStudents(); // Notifying all the students that observing the course
            System.out.println(student.getName() + " unregistered from " + course.getName());
        }
        System.out.println("The student is not registered to this course");
    }

    /**
     * Only the admin aka Teacher can add courses to the system.
     * We want to enable only for them, so for creating a course we need to check if the person is a teacher, pass this argument
     */

    public Course createCourse(String name, int courseID, Lecturer lecturer, Practitioner practitioner, CourseType type, int courseNumber, int courseCapacity, UniversityPerson person) throws NotLoggedInException, NotATeacherException {
        if (!REGISTER_SYSTEM.contains(person)) {
            throw new NotLoggedInException("Try to login to continue...");
        }
        if (!(person instanceof Teacher)) {
            throw new NotATeacherException("Only teachers can create courses");
        }
        Course course = Course.getInstance(name, courseID, lecturer, practitioner, type, courseNumber, courseCapacity);
        COURSES_LIST.add(course);
        return course;
    }


    //    public void addCourse(Course course, Teacher teacher) throws NotLoggedInException {
//        if (!REGISTER_SYSTEM.contains(teacher)) {
//            throw new NotLoggedInException("Try to login to continue...");
//        }
//        COURSES_LIST.add(course);
//    }

}
