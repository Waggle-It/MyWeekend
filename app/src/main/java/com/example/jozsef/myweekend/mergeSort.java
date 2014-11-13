import static java.lang.*;
import java.util.Random;
import java.lang.Math;
import java.lang;
import static java.lang.System.*;
import java.lang.*;

public class mergeSort {
    public static long[] mergeSort1(long[] list) {
        if (list.length <= 1)
            return list;

        // splits the array in half.
        long[] left = new long[list.length / 2];
        long[] right = new long[list.length - left.length];

        for (int i = 0; i < left.length; i++) {
            left[i] = list[i];
        }

        for (int i = left.length; i < list.length; i++) {
            right[i - left.length] = list[i];
        }

        return merge(mergeSort1(left), mergeSort1(right));
    }

    public static long[] merge(long[] left, long[] right) {
        long[] result = new long[left.length + right.length];

        int index = 0;
        int index2 = 0;
        for (int i = 0; i < result.length; i++) {

            boolean cond = true;

            if (index >= left.length) {
                result[i] = right[index2];
                index2++;
                cond = false;
            }

            if (cond) {
                if (index2 >= right.length) {
                    result[i] = left[index];
                    index++;
                    cond = false;
                }
            }

            if(cond){
                if (left[index] <= right[index2]) {
                    result[i] = left[index];
                    index++;
                }

                else {
                    result[i] = right[index2];
                    index2++;
                }
            }

        }

        return result;
    }
    // has array list & calls mergesort function
    public static void main(String[] args)  {
        // creates the array list that holds 20 random timestamps btwn halloween 2014 and new years2015 (the best time of year)*
        long[] dates = new long[20];
        for (int i = 0; i < dates.length; i++){
            dates[i] = 1414713600 + Math.abs(new Random().nextLong())%(1420113599 - 1414713600 );
            System.out.println(dates[i]);
        }
        // calles the mergsort function
        dates = mergeSort1(dates);
        System.out.print(dates[0]);
        for (int i = 1; i < dates.length; i++) {
            System.out.print("," + dates[i]);

        }
    }
}

