/**
 * Created by Angela on 10/22/2014.
 */

import com.example.jozsef.myweekend.Event;

import java.util.ArrayList;
import java.util.List;
public class EventList {
    private List<Event> list;
    public EventList(){
        list = new ArrayList<Event>();
    }
    public List<Event> getEventList(){
        return list;
    }
    public void setEventList(EventList e){
        this.list = e.getEventList();
    }
}
