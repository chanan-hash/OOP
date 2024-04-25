package Ex1B;

/**
 * This class represents the EmailNotificationStrategy, One of the ways to notify students about available places in a course
 */
public class EmailNotificationStrategy implements NotificationStrategy{
    @Override
    public void notifyStudents(Course course, Student student) {
        System.out.println("Sending to " + student.getName() + " email notification, " + course.getName() + " has place available");
    }
}
