package Ex1B;

/**
 *  This class represents the PhoneNotificationStrategy, One of the ways to notify students about available places in a course
 */
public class PhoneNotificationStrategy implements NotificationStrategy{
    @Override
    public void notifyStudents(Course course, Student student) {
        System.out.println("Calling to " + student.getName() + " to notify that " + course.getName() + " has place available");
    }
}
