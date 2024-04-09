package Ex1B;

public interface Subject {

    void addObserver(CourseObserver observer);

    void notifyStudents();
    void removeObserver(CourseObserver observer);
}
