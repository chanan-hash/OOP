package Ex1B.Exceptions;

/**
 * Exception thrown when a user tries to perform a teacher-only operation, like creating a course.
 */
public class NotATeacherException extends Exception {
    public NotATeacherException(String message) {
        super(message);
    }
}
