package Ex1B;

public class SmsNotificationStrategy implements NotificationStrategy{
    @Override
    public void notifyStudents(Course course, Student student) {
        System.out.println("Sending to " + student.getName() + " SMS notification, " + course.getName() + " has place available");
    }
}
