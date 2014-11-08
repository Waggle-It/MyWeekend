package com.example.jozsef.myweekend.javaCode.Objects;

import com.example.jozsef.myweekend.javaCode.Objects.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angela on 10/22/2014.
 */
//Creates an array of list event.
public class EventList {
    private static List<Event> eventArray= new ArrayList<Event>();
    public EventList(List<Event> eventList)
    {
        eventArray = eventList;
    }
    public EventList() {}
    public static List<Event> getEventList(){
        return eventArray;
    }
}
