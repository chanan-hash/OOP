package Q7;

/**
 * Practicing threading from the drive
 * https://drive.google.com/drive/folders/1DeYxca6VC8jIw_SSVz2NhnLY6OQ0f3rN
 */
public class Storage {

    // Variables
    private int number = 0;
    private boolean isNumber = false;

    // Getters and Setters
    public synchronized void setNumber(int num) {
        while (isNumber) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.number = num;
        isNumber = true;
        notify();
    }

    public synchronized int getNumber() {
        while (!isNumber) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isNumber = false;
        notify();
        return this.number;
    }
}
