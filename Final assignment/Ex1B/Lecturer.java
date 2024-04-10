package Ex1B;

import Ex1B.Exceptions.IdTakenException;

public class Lecturer extends Teacher {

    private Lecturer(String name, int id, int workHours) {
        super(name, id, workHours);
    }
    public static Lecturer createLecturer(String name, int id, int workHours) throws IdTakenException {
        if (Teacher.getIdTeacher().contains(id)) {
            throw new IdTakenException("This ID is already taken");
        } else {
            Teacher.getIdTeacher(); // adding to the id set the student id
            return new Lecturer(name, id, workHours);
        }
    }
}
