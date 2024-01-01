package Q7;

public class AnonimThread {
    public static void threadAnonim() {
        new Thread() {
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    try {
                        sleep(100); // in millisecond, we can play with the time
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        threadAnonim();
    }
}
