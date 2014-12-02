package com.example.jozsef.myweekend;

import com.example.jozsef.myweekend.javaCode.Objects.Event;


public class mergeSort {
    public static Event[] mergeSort1(Event[] list) {
        if (list.length <= 1)
            return list;

        // splits the array in half.
        Event[] left = new Event[list.length / 2];
        Event[] right = new Event[list.length - left.length];

        System.arraycopy(list, 0, left, 0, left.length);

        System.arraycopy(list, left.length, right, 0, list.length - left.length);

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

