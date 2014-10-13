package com.example.jozsef.myweekend;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Jozsef on 10/9/2014.
 */
public class EventList extends Activity {

    ListView events;
    String[] eventList = {"event0", "event1", "event2", "event3", "event4", "event5", "event6", "event7", "event8", "event9", "event0", "event1", "event2", "event3", "event4", "event5", "event6", "event7", "event8", "event9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventselector);
        events = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, eventList);
        events.setAdapter(adapter);





            }







    public void pageSubmission(){


    }


}
