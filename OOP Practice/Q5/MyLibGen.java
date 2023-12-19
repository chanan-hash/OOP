package Q5;

import java.util.Arrays;

/**
 * The <T> or <T,V> means A generic object from kind T or V or both (it can be any letter, but those are agreed upon
 */
public class MyLibGen {


    public static <T,V> boolean eq (T x, V y){ // This static function, is getting tow generic objects, and doing equals on them
        return x.equals(y); // Depends on how it has been implemented on T objects 'x'
    }

    public static <T> void printArr(T[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static <T extends Comparable <T>> T max (T x, T y){ // based that T object has compareTo function (returning 1 , 0 , -1 )
        return x.compareTo(y) > 0 ? x : y; // if the compare function bigger than 0, return x, else return y --> short condition
    }
}
