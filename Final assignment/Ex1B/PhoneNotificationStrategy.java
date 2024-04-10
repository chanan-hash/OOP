package Ex1B;

public class PhoneNotificationStrategy implements NotificationStrategy{
    @Override
    public void notifyStudents() {
        System.out.println("We'll notify you by phone call...");
    }
}
