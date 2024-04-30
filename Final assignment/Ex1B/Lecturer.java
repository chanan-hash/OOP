package Ex1B;

import Ex1B.Exceptions.IdTakenException;
import Ex1B.courseBuilder.Teacher;

/**
 * Lecturer class, extends Teacher abstract class.
 * We can add here more attributes and methods if needed depends on what he can do.
 * For now, we're keeping it simple.
 */

public class Lecturer extends Teacher {

    private Lecturer(String name, int id, String password, int workHours) {
        super(name, id, password, workHours);
    }

    // This method is used to create a lecturer and add it to the id set, if id is taken throws an exception
    public static Lecturer createLecturer(String name, int id, String password, int workHours) throws IdTakenException {
        if (UniversityPerson.getIdMap().get(id) != null) {
            throw new IdTakenException("This ID is already taken");
        } else {
            Lecturer lecturer = new Lecturer(name, id, password, workHours);
            UniversityPerson.getIdMap().put(id, lecturer); // adding to the id to ID map
            return lecturer;
        }
    }
}
