package Ex1B;

public class PhoneNotificationStrategy implements NotificationStrategy{
    @Override
    public void notifyStudents(Course course, Student student) {
        System.out.println("Calling to " + student.getName() + " to notify that " + course.getName() + " has place available");
    }
}
