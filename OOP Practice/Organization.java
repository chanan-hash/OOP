import java.util.Arrays;

public class Organization {
    // Variables
    private Worker[] marketing, engineering;
    private Manager[] managers;
    private CEO ceo;

    // Default constructor
    public Organization() {
        // Initializing the workers info
        marketing = new Worker[5];
        marketing[0] = new Worker("Market1", 1, 1000);
        marketing[1] = new Worker("Market2", 2, 2000);
        marketing[2] = new Worker("Market3", 3, 3000);
        marketing[3] = new Worker("Market4", 4, 4000);
        marketing[4] = new Worker("Market5", 5, 5 * 1000);

        engineering = new Worker[4];
        engineering[0] = new Worker("engine1", 6, 6000);
        engineering[1] = new Worker("engine2", 7, 7000);
        engineering[2] = new Worker("engine3", 8, 8000);
        engineering[3] = new Worker("engine4", 9, 9000);

        managers = new Manager[2];
        managers[0] = new Manager("Market manager", 10, 10000);
        managers[1] = new Manager("Engine manager", 11, 11000);

        // Adding to each manger his workers
        for (int i = 0; i < marketing.length; i++) {
            managers[0].addWorker(marketing[i]);
        }

        for (int i = 0; i < engineering.length; i++) {
            managers[1].addWorker(engineering[i]);
        }

        ceo = new CEO("CEO moshe", 12, 12 * 100);
        // Adding to the ceo his managers
        for (int i = 0; i < managers.length; i++) {
            ceo.addManager(managers[i]);
        }
    }

    public void printAllData() {
        System.out.println(Arrays.toString(marketing));
        System.out.println(Arrays.toString(engineering));
        System.out.println(Arrays.toString(managers));
        System.out.println(ceo);
    }

    public static void main(String[] args) {
        new Organization().printAllData(); // Short way instead of creating the object with a name and then print it all
    }
}
