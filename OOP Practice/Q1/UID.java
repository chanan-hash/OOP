package Q1;

/**
 * This class is an object counter that help to be a counter for another classes,
 * It gives Id for each Object we are creating, so we can number them.
 * See an exam[le in Point class in this package
 */
public class UID {
    // Static variable
    private static int uid = 0; // Unique id
    // Variable
    private int objid;

    // Constructors
    public UID() {
        this.objid = ++uid; // incrementing first the static variable
    }

    public int getID() {
        return this.objid;
    }

    @Override
    public String toString() {
        return "" + getID();
    }
}
