package Q6;

/**
 * This class for static function for Arrays
 */
public class ArraysCalc {
    public static void main(String[] args) {

    }


    // this function returning the min values in the array
    public static int minArray(int[] arr) {
        if (arr.length == 0) {
            return Integer.MIN_VALUE;
        }
        int min = arr[0]; // initializing with the first value in the array, just to start with something, or it will change or not.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) { // Or a short condition max = arr[i] < min ? arr[i] : min;
                min = arr[i];
            }
        }
        return min; // if it have returned the min value of Integer, means the array is empty
    }

    // The same for max value
    public static int maxArray(int[] arr) {
        if (arr.length == 0) {
            throw new ArrayIndexOutOfBoundsException("The array is empty");
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }

    // Sum of the array values
    public static int sumArray(int[] arr) {
        if (arr.length == 0) {
            throw new ArrayIndexOutOfBoundsException("The array is empty");
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // Average of array values
    public static int avgArray(int[] arr) {
        int sum = sumArray(arr); // if it's empty will get it here, so we don't need to repeat the exception
        //int avg = sum/arr.length;
        return (sum / arr.length);
    }
}