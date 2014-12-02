package com.example.jozsef.myweekend.javaCode.Objects;

import com.example.jozsef.myweekend.javaCode.Objects.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angela on 10/22/2014.
 * The static event list to contain all the information of our events.
 * I have worked the date initial organization out but these areas also need attention:
 * 1.)  Creating a list of Quality organized events that can be easily accessed:
 *          -Since most events will have multiple Qualities this is a complex structure that needs
 *          -to be able to find events based on any one of these qualities.
 *          -(So an effective search menu can be created)
 * 2.) Inserting a new event in the proper lists in the proper location.
 *
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
