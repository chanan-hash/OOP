package Ex1B;

/**
 * This will be for the observer pattern, to update if there is place in one of the courses
 */
public interface CourseObserver {
    void update(Course course); // This will tell us which course is available
}
