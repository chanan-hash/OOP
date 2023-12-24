package Q5;

public class Worker {
    private String name;
    private int id, salary;

    public Worker(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public Worker(Worker w) {
        this(w.name, w.id, w.salary);
    }

    @Override
    public String toString() {
        return "(" + name + ", " + id + ", " + salary + ")";
    }

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Worker getWorker() {
        return this;
    }

}
