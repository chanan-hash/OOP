package Ex1B;

/**
 * This class represents the SmsNotificationStrategy, One of the ways to notify students about available places in a course
 */
public class SmsNotificationStrategy implements NotificationStrategy{
    @Override
    public void notifyStudents(Course course, Student student) {
        System.out.println("Sending to " + student.getName() + " SMS notification, " + course.getName() + " has place available");
    }
}
