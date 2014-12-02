package com.example.jozsef.myweekend.sortComparators;

import com.example.jozsef.myweekend.javaCode.Objects.Event;

import java.util.Comparator;

/**
 * Created by Jozsef on 11/24/2014.
 * This is a standard built in sort method that sorts objects by a specified parameter.
 * The parameter date has been specified in this comparator.
 */
public class DateSort implements Comparator <Event> {


    @Override
    public int compare(Event event, Event event2) {
        if(event.getDate()<event2.getDate())
            return -1;
        if(event.getDate()>event2.getDate())
            return 1;

        return 0;
    }
}
