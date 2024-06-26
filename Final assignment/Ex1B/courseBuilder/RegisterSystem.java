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
    private static int MAX_ACTIVE = 100; // Maximum number of active people
    private static RegisterSystem instance = null; // Singleton pattern
    private Map<Integer, UniversityPerson> REGISTER_SYSTEM;// = new HashMap<>(MAX_ACTIVE); // HashMap to hold the registered people  id -> person
    private Map<Integer, Course> COURSES_LIST; // = Course.getCourseMap(); // HashMap to hold the courses that were created courseID -> course

    //    private static final Set<UniversityPerson> REGISTER_SYSTEM = new HashSet<>(MAX_ACTIVE);
    //    private static final ArrayList<UniversityPerson> REGISTER_SYSTEM = new ArrayList<>(MAX_ACTIVE);
    // private static final Set<Course> COURSES_LIST = new HashSet<>();
    //    private static final ArrayList<Course> COURSES_LIST = new ArrayList<>();

    //******* singleton pattern ********//
    // private empty constructor, so no one can create an instance of this class by "new RegisterSystem()"
    private RegisterSystem() {
        REGISTER_SYSTEM = new HashMap<>(MAX_ACTIVE);
        COURSES_LIST = Course.getCourseMap();
    }

    public static RegisterSystem getInstance() { // for the singleton pattern
        if (instance == null) {
            instance = new RegisterSystem();
        }
        return instance; // This will always return the same instance
    }

    /**
     * University person registration system, getting id and password
     * If there is no place in the system or password isn't correct throws exception
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
        REGISTER_SYSTEM.put(id, person); // Adding the person to the system
    }

    /**
     * Signing out form the system, if his not logged-in, he wouldn't be able to register for courses.
     * If the student trying to log out when he is not in the system it'll throw exception.
     */
    public void singOut(UniversityPerson person) throws NotLoggedInException {
        if (REGISTER_SYSTEM.get(person.getId()) == null) {
            throw new NotLoggedInException("You're already not in the system");
        }
        REGISTER_SYSTEM.remove(person.getId());
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
     * For un-registering from the course, the student need to be logged in to get access to register the course
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
     * For that we've put Teacher and RegisterSystem in the same package, for the package private access.
     * Student won't be able to have this kind of function, because he is not in the same package.
     */
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
