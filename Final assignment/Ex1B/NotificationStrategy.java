package Ex1B;

/**
 * NotificationStrategy interface that has a method to notify students.
 * We can implement different strategies to notify students.
 * When there is no place in the course and the student want to get notified when there is a place,
 * he will be able to chose in which way he wants to get notified.
 */
public interface NotificationStrategy {
    void notifyStudents(Course course, Student student);
}
