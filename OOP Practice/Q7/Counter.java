package Q7;

public class Counter extends Thread {

    // Variables
    private Storage st;

    // Constructor
    public Counter(Storage s) {
        this.st = s; // Points to the same place in the memory
    }

    @Override
    public void run() {
        int num = 0;
        while (true) {
            try {
                sleep(100); // in milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            st.setNumber(num++); // Incrementing the number
        }
    }
}
