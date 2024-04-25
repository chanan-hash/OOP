package Ex1B;

/**
 * Subject interface, This interface is implemented by the Course class.
 */
public interface Subject {

    void addObserver(CourseObserver observer); // Adding an observer to the list of observers

    void notifyStudents(); // Notify all the observers, we'll use update function in the observer.
    void removeObserver(CourseObserver observer); // Remove an observer from the list of observers
}
