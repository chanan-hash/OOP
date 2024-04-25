package Ex1B;

import Ex1B.Exceptions.IdTakenException;
import Ex1B.courseBuilder.Teacher;

/**
 * Practitioner class, extends Teacher abstract class.
 * We can add here more attributes and methods if needed depends on what he can do.
 * For now, we're keeping it simple.
 */

public class Practitioner extends Teacher {

    // This method is used to create a practitioner and add it to the id set, if id is taken throws an exception
    public static Practitioner createPractitioner(String name, int id, String password, int workHours) throws IdTakenException {
        if (UniversityPerson.getIdMap().get(id) != null) {
            throw new IdTakenException("This ID is already taken");
        } else {
            Practitioner practitioner = new Practitioner(name, id, password, workHours);
            UniversityPerson.getIdMap().put(id, practitioner); // adding to the id to ID map
            return practitioner;
        }
    }

    public Practitioner(String name, int id, String password, int workHours) { // inherits from the Teacher class
        super(name, id, password, workHours);
    }
}
