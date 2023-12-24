package Q6;

import java.util.Arrays;

/**
 * This class for static function for Arrays
 */
public class ArraysCalc {
    public static void main(String[] args) {
        // Checking the functions
        int[] arr = {6,3,856,3,7,9,44,100,99,57,5839};
        int[] arr2 = new int[0];
        // min and max Array
        int min = minArray(arr);
        int max = maxArray(arr);
        System.out.println("Min value: " + min);
        System.out.println("Max value: " + max);
        System.out.println(minArray(arr2)); // Checking if it is empty

        // Checking sum and avg Array
        System.out.println("Sum array: " + sumArray(arr));
        System.out.println("Average array: " + avgArray(arr));

          // Checking the exception
//        System.out.println(sumArray(arr2));
//        System.out.println(avgArray(arr2));

        int[] arr3 = {1,2,3,4,5,6,7,8,9,10,11};
        int[] arr4 = {99,100};
        int[] arr5 = sumOfArrays(arr,arr3);
        System.out.println("Sum of to arrays: " + Arrays.toString(arr5));
        // Checking the exception
//        System.out.println("Sum of to arrays: " + Arrays.toString(sumOfArrays(arr,arr4)));

    }

    /**
     * All of those functions are static functions, because they aren't depends on creating an instance of the class or an object.
     * They are self-depended
     */

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


    public static int[] sumOfArrays(int[] arr1, int[] arr2) {
        // first we will check if the two arrays in the same length, else throw exception
        if (arr1.length != arr2.length) {
            throw new ArrayIndexOutOfBoundsException("Arrays not in the same length");
        }
        int[] arr3 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i] + arr2[i];
        }

        return arr3;
    }
}