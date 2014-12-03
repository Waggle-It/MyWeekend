package com.example.jozsef.myweekend.androidCode;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jozsef.myweekend.javaCode.Objects.Event;
import com.example.jozsef.myweekend.javaCode.Objects.EventList;
import com.example.jozsef.myweekend.R;

import java.text.SimpleDateFormat;

/**
 * Created by Jozsef on 10/15/2014.
 * This class inflates the parameters of the event_page xml and inputs information unique to a single
 * event based on user selection.
 * Links and options that need to be added:
 *      like
 *      attend
 *      website url
 *      contact button functional
 *      website url button functional
 */


public class EventPage extends Activity {

    public static int eventLocation;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater x = getLayoutInflater();
        view = x.inflate(R.layout.event_page, null);

        modifyView();

        setContentView(view);

    }
    public Event findEvent(){
        for(int i = 0; i<EventList.getEventList().size(); i++)
            if(eventLocation == EventList.getEventList().get(i).idNumber)
                return EventList.getEventList().get(i);
        return null;
    }


    public View modifyView() {
        SimpleDateFormat monthDay = new SimpleDateFormat("MMMMMMMMMMMM dd, HH:MM");
        SimpleDateFormat year = new SimpleDateFormat("yyyy");

        TextView title = (TextView) view.findViewById(R.id.textView);
        TextView dates = (TextView) view.findViewById(R.id.textView6);
        TextView location = (TextView) view.findViewById(R.id.textView8);
        ImageView image = (ImageView) view.findViewById(R.id.imageView);
        TextView description = (TextView) view.findViewById(R.id.textView10);

        Event event = findEvent();

        title.setText(event.getTitle());
        dates.setText(monthDay.format(event.getDate()) + "\n" + year.format(event.getDate()));
        location.setText(event.getLocation());
        image.setImageResource(event.getImage());
        description.setText(event.getDescription());

        return view;
    }
}


