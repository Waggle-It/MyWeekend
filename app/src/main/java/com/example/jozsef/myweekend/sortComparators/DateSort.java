package com.example.jozsef.myweekend.sortComparators;

import com.example.jozsef.myweekend.javaCode.Objects.Event;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Jozsef on 11/24/2014.
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
