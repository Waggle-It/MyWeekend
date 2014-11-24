package com.example.jozsef.myweekend;

import com.example.jozsef.myweekend.javaCode.Objects.Event;

import java.util.Random;
import java.lang.Math;

public class mergeSort {
    public static Event[] mergeSort1(Event[] list) {
        if (list.length <= 1)
            return list;

        // splits the array in half.
        Event[] left = new Event[list.length / 2];
        Event[] right = new Event[list.length - left.length];

        for (int i = 0; i < left.length; i++) {
            left[i] = list[i];
        }

        for (int i = left.length; i < list.length; i++) {
            right[i - left.length] = list[i];
        }

        return merge(mergeSort1(left), mergeSort1(right));
    }

    public static Event[] merge(Event[] left, Event[] right) {
        Event[] result = new Event[left.length + right.length];

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

            if(cond){//left.getEventList().get(index).getDate()
                if (left[index].getDate() <= right[index2].getDate()) {
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
}

