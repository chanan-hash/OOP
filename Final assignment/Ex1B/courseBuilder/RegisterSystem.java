package Ex1B.courseBuilder;

import Ex1B.*;
import Ex1B.Exceptions.IncorrectPasswordException;
import Ex1B.Exceptions.NotATeacherException;
import Ex1B.Exceptions.NotLoggedInException;
import Ex1B.Exceptions.SystemIsFullException;

import java.util.*;

/**
 * This will implement the singleton pattern, to make sure that there is only one register system
 */
public class RegisterSystem {
    private static final RegisterSystem instance = new RegisterSystem();
    private static final int MAX_ACTIVE = 100; // Maximum number of active people
    private static final Map<Integer, UniversityPerson> REGISTER_SYSTEM = new HashMap<>(MAX_ACTIVE);

    private static final Map<Integer, Course> COURSES_LIST = Course.getCourseMap();
    //    private static final Set<UniversityPerson> REGISTER_SYSTEM = new HashSet<>(MAX_ACTIVE);
    //    private static final ArrayList<UniversityPerson> REGISTER_SYSTEM = new ArrayList<>(MAX_ACTIVE);
    // private static final Set<Course> COURSES_LIST = new HashSet<>();
    //    private static final ArrayList<Course> COURSES_LIST = new ArrayList<>();


    //******* singleton pattern ********
    public static RegisterSystem getInstance() { // for the singleton pattern
        return instance; // This will always return the same instance
    }


    /**
     * University person registration system
     * return true if there is place in the system, else throws exception
     */
    public void singIn(int id, String password) throws SystemIsFullException, IncorrectPasswordException {
        if (REGISTER_SYSTEM.size() == MAX_ACTIVE) {
            throw new SystemIsFullException("System is full. There is no place right now");
        }
        UniversityPerson person = UniversityPerson.getIdMap().get(id);
        if (person == null) {
            throw new IllegalArgumentException("The person is not in the system");
        }
        if (!person.getPassword().equals(password)) {
            throw new IncorrectPasswordException("Incorrect password");
        }
        REGISTER_SYSTEM.put(id, person);
    }

    /**
     * singing out form the system, if his not logged in he wouldn't be able to register for the course
     * If the student trying to log out when he is not in the system it'll throw exception
     */
    public boolean singOut(UniversityPerson person) throws NotLoggedInException {
        if (REGISTER_SYSTEM.get(person.getId()) == null) {
            throw new NotLoggedInException("You're already not in the system");
        }
        REGISTER_SYSTEM.remove(person.getId());
        return true;
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
        if (REGISTER_SYSTEM.get(student.getId()) == null) {
            throw new NotLoggedInException("Try to login to continue...");
        } else if (course.addStudent(student)) {
            student.getCourses().add(course);
            return true;
        } else {
            if (subscribe) {
                course.addObserver(student);

                // Strategy design pattern for how to send notification

                Scanner scanner = new Scanner(System.in);
                System.out.println(student.getName() + " how would you like to get the notification ? (Email/Sms/Phone)");
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
        if (REGISTER_SYSTEM.get(student.getId()) == null) {
            throw new NotLoggedInException("Try to login to continue...");
        } else if (student.getCourses().contains(course)) {
            student.getCourses().remove(course);
            course.removeStudent(student);
            System.out.println(student.getName() + " unregistered from " + course.getName());
        }
        System.out.println("The student is not registered to this course");
        course.notifyStudents(); // Notifying all the students that observing the course
    }

    /**
     * Only the admin aka Teacher can add courses to the system.
     * We want to enable only for them, so for creating a course we need to check if the person is a teacher, pass this argument
     */
    // package private function, only the package can use it
    Course createCourse(String name, int courseID, Lecturer lecturer, Practitioner practitioner, CourseType type, int courseCapacity, UniversityPerson person) throws NotLoggedInException, NotATeacherException {
        if (REGISTER_SYSTEM.get(person.getId()) == null) {
            throw new NotLoggedInException("Try to login to continue...");
        }
        if (!(person instanceof Teacher)) {
            throw new NotATeacherException("Only teachers can create courses");
        }
        Course course = Course.getCourse(name, courseID, lecturer, practitioner, type, courseCapacity);
        return course;
    }

}
