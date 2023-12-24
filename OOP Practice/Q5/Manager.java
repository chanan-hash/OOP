package Q5;

import java.util.ArrayList;

public class Manager extends Worker {
    private ArrayList<Worker> workers;

    public Manager(String name, int id, int salary) {
        super(name, id, salary);
        this.workers = new ArrayList<Worker>();
    }

    public Manager(Manager m) {
        super(m.getWorker());
        this.workers = new ArrayList<Worker>(m.workers);
    }

    public void addWorker(Worker w) {
        workers.add(w);
    }

    public void removeWorker(Worker w) {
        workers.remove(w);
    }

    @Override
    public String toString() {
        return super.toString() + " workers: " + workers.toString();
    }

    public Manager getManager() {
        return this;
    }
}
