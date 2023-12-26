package Q7;

public class Printer extends Thread {
    // Variables
    private Storage st;

    // Constructor
    public Printer(Storage s) {
        this.st = s;
    }

    // Methods
    @Override
    public void run() {
        while (true) {
            try {
                sleep(100); // In milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace(); // Where did it happen
            }
            System.out.println(st.getNumber());
        }
    }
}
