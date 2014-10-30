package com.example.jozsef.myweekend; /**
 * Created by Angela on 10/22/2014.
 */
//Creates an array of list event.
public class EventList {
    private Event[] eventArray= new Event[0];
    public EventList(){
    }
    public Event getEventList(int i){
        return eventArray[i] ;
    }
    public int getLength(){
        return eventArray.length;
    }

    public void addEvent(Event nEw){
        Event[] newList = new Event[this.eventArray.length+1];
        for(int i=0; i<this.eventArray.length; i++){
            newList[i]=eventArray[i];
        }
        newList[this.eventArray.length]=nEw;
        this.eventArray=newList;
    }
}
