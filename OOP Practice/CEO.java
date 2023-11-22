import java.util.ArrayList;

public class CEO extends Manager {
    // Variables
    private ArrayList<Manager> managers;

    // Constructors
    public CEO(String name, int id, double salary) {
        super(name, id, salary);
        this.managers = new ArrayList<Manager>();
    }

    public CEO(CEO c) {
        super(c.getManager());
        this.managers = new ArrayList<Manager>(c.managers);
    }

    public void addManager(Manager m) {
        this.managers.add(m);
    }

    public void removeManager(Manager m) {
        this.managers.remove(m);
    }

    @Override
    public String toString() {
        return "CEO{" + super.toString() +
                "managers=" + managers.toString() +
                '}';
    }
}
