/**
 * This class is part of practice exercise of inheritance
 */
public class Worker {

    // Variables
    private String name;
    private int id;
    private double salary;

    // Constructor
    public Worker(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Copy constructor
    public Worker(Worker w) {
        this.name = w.name;
        this.id = w.id;
        this.salary = w.salary;
    }

    // Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Helps us for the inheritance that we can pass the whole worker qualities as a manager
    public Worker getWorker(){
        return this;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}
