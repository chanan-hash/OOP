package Q7;

class PrintNums {
    public static void print(int num) {

    }

    class Thr_1 extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {
                System.out.println("Thr_1: " + i);
            }
        }
    }

    class Thr_2 extends Thread {
        private Thr_1 t1;

        public Thr_2(Thr_1 t) {
            this.t1 = t; // Points to the same place
        }

        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) { // so we'll know the differences here, we are starting form 0
                if (i == 100) {
                    try {
                        t1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thr_2: " + i);
            }
        }
    }

    public class OneAfterOther {
        public static void main(String[] args) {
            Thr_1 t1 = new Thr_1();
            Thr_2 t2 = new Thr_2(t1);
            t2.start();
            t1.start();
        }
    }
}
