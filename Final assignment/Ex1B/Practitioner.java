package Ex1B;

import Ex1B.Exceptions.IdTakenException;
import Ex1B.courseBuilder.Teacher;

/**
 * Practitioner class, extends Teacher abstract class.
 * We can add here more attributes and methods if needed depends on what he can do.
 * For now, we're keeping it simple.
 */

public class Practitioner extends Teacher {

    public Practitioner(String name, int id, int workHours) { // inherits from the Teacher class
        super(name, id, workHours);
    }

    // TODO check it
    // Factory method to create a Practitioner
    public static Practitioner createPractitioner(String name, int id, int workHours) throws IdTakenException {
        if (Teacher.getIdTeacher().contains(id)) {
            throw new IdTakenException("This ID is already taken");
        } else {
            Teacher.getIdTeacher().add(id); // adding to the id set the student id
            return new Practitioner(name, id, workHours);
        }
    }
}
