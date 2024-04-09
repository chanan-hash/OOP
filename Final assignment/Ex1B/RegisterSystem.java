package Ex1B;

import java.util.ArrayList;
import java.util.List;

/**
 * This will implement the singleton pattern, to make sure that there is only one register system
 */
public class RegisterSystem {
    private static final RegisterSystem instance = new RegisterSystem();
    private static final int MAX_ACTIVE = 100; // Maximum number of active people
    List<UniversityPerson> active = new ArrayList<UniversityPerson>(MAX_ACTIVE);

    public static RegisterSystem getInstance() { // for the singleton pattern
        return instance; // This will always return the same instance
    }


}
