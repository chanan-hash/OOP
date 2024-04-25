package Ex1B;

/**
 * Interface for the observer pattern
 * Student will be the observers on the courses.
 * We want to notify them when a course has places available.
 */
public interface CourseObserver {
    void update(Course course); // This will tell us which course is available
}
