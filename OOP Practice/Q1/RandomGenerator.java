package Q1;
/**
 * This whole file is from practice from the CS drive, and based also with the help and check from the answers
 * https://drive.google.com/drive/folders/1b-30fUjTSJSLvBiBIJ5P04lTR_PT2fsX
 */

import java.util.Calendar;

public class RandomGenerator {
    private int prev;

    public RandomGenerator() {
        this.prev = 1;
    }

    public RandomGenerator(int num) {
        this.prev = num;
    }

    // Another default constructor, a way to get at the beginning a random number
//    public RandomGenerator() {
//        this.prev = (int) Calendar.getInstance().getTime().getTime() % 65536;
//    }

    public int nextInt() {
        int res = prev; // saving the original number
        prev = ((prev * 25173) + 13849) % 65536; // A given formula for calculating the next number
        // res = ((prev * 25173) +  13849 ) % 65536; // A given formula for calculating the next number
        return res; // ? return prev;, the change is in the memory so 'prev' and 'res' are pointing to the same place here because it is a class so we are working by reference
                    // so 'prev' and 'res' are the same value even after the changes
    }


    @Override
    public String toString() {
        return "RandomGenerator{" +
                "prev=" + prev +
                '}';
    }

    public static void main(String[] args) {
        RandomGenerator num = new RandomGenerator(2);
        System.out.println(num);
        num.nextInt();
        System.out.println(num);
    }
}
