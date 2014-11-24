package com.example.jozsef.myweekend.javaCode.Objects;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Jozsef on 11/24/2014.
 */
public class Sort implements Comparator <Event> {


    @Override
    public int compare(Event event, Event event2) {
        if(event.getDate()<event2.getDate())
            return -1;
        if(event.getDate()>event2.getDate())
            return 1;

        return 0;
    }
}
