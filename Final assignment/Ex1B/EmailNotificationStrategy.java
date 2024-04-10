package Ex1B;

public class EmailNotificationStrategy implements NotificationStrategy{
    @Override
    public void notifyStudents(Course course, Student student) {
        System.out.println("Sending to " + student.getName() + " email notification, " + course.getName() + " has place available");
    }
}
