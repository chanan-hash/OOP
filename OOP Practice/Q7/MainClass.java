package Q7;

public class MainClass {
    public static void main(String[] args) {
        Storage st = new Storage();
        Counter c = new Counter(st);
        Printer p = new Printer(st);
        c.start();
        p.start();
    }
}
