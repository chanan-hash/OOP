package Ex1B;

import Ex1B.Exceptions.NotLoggedInException;
import Ex1B.Exceptions.SystemIsFullException;

import java.util.Set;
import java.util.HashSet;

/**
 * This will implement the singleton pattern, to make sure that there is only one register system
 */
public class RegisterSystem {

    // TODO add the course register here and the observers


    private static final RegisterSystem instance = new RegisterSystem();
    private static final int MAX_ACTIVE = 100; // Maximum number of active people
    private static final Set<UniversityPerson> REGISTER_SYSTEM = new HashSet<>(MAX_ACTIVE);

    // This is for singleton pattern
    public static RegisterSystem getInstance() { // for the singleton pattern
        return instance; // This will always return the same instance
    }


    /**
     * Student registration system
     * return true if there is place in the system, else throws exception
     */
    public boolean singIn(Student student) throws SystemIsFullException {
        if (REGISTER_SYSTEM.size() == MAX_ACTIVE) {
            throw new SystemIsFullException("System is full. There is no place right now");
        }
        return REGISTER_SYSTEM.add(student);
    }

    /**
     * singing out form the system, if his not logged in he wouldn't be able to register for the course
     * If the student trying to log out when he is not in the system it'll throw exception
     *
     */
    public boolean singOut(Student student) throws NotLoggedInException {
        if (!REGISTER_SYSTEM.contains(student)){
         throw new NotLoggedInException("You're already not in the system");
        }
        return REGISTER_SYSTEM.remove(student);
    }

}
