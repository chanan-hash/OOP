package Ex1B;

public class SmsNotificationStrategy implements NotificationStrategy{
    @Override
    public void notifyStudents() {
        System.out.println("Sending SMS to your phone...");
    }
}
