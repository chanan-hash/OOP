package Ex1B;

public class EmailNotificationStrategy implements NotificationStrategy{
    @Override
    public void notifyStudents() {
        System.out.println("Sending your email notification");
    }
}
