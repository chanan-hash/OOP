import java.util.ArrayList;

/**
 * This class is part of practice exercise of inheritance.
 * This class of manager inherits Worker class, and has in addition 2 method:
 * list of worker that he can add and delete workers from there
 */

public class Manager extends Worker {
    // Variables
    private ArrayList<Worker> workers;

    // Constructor
    public Manager(String name, int id, double salary) {
        super(name, id, salary);
        this.workers = new ArrayList<Worker>();
    }

    // Copy constructor
    public Manager(Manager m) {
        super(m.getWorker());
        this.workers = new ArrayList<Worker>(m.workers); // Copying the arraylist of the manager
    }

    public void addWorker(Worker w) {
        this.workers.add(w);
    }

    public void removeWorker(Worker w) {
        this.workers.remove(w);
    }

    @Override
    public String toString() {
        return "Manager{" +
                super.toString() +
                "workers=" + workers.toString() +
                '}';
    }

    // Explanation in Worker class
    public Manager getManager() {
        return this;
    }
}