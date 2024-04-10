package Ex1B;

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
     * Student registration system
     * return true if there is place in the system, else throws exception
     */
    public boolean singIn(Student student) throws SystemIsFullException {
        if (REGISTER_SYSTEM.size() == MAX_ACTIVE) {
            throw new SystemIsFullException("System is full. There is no place right now");
        }
        return REGISTER_SYSTEM.add(student);
    }

    /**
     * singing out form the system, if his not logged in he wouldn't be able to register for the course
     * If the student trying to log out when he is not in the system it'll throw exception
     */
    public boolean singOut(Student student) throws NotLoggedInException {
        if (!REGISTER_SYSTEM.contains(student)) {
            throw new NotLoggedInException("You're already not in the system");
        }
        return REGISTER_SYSTEM.remove(student);
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
        } else if (course.addStudent(student)) {
            student.getCourses().add(course);
            return true;
        } else {
            if (subscribe) {
                course.addObserver(student);

                // Strategy design pattern for how to send notification
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

    // TODO createCourse
    // TODO Teacher register


}
