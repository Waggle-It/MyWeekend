package com.example.jozsef.myweekend.androidCode;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jozsef.myweekend.javaCode.Objects.EventList;
import com.example.jozsef.myweekend.R;

/**
 * Created by Jozsef on 10/15/2014.
 * This class inflates the parameters of the event_page xml and inputs information unique to a single
 * event based on user selection.
 */


public class EventPage extends Activity {

    public static int eventLocation;
    public static EventList ccg;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater x = getLayoutInflater();
        view = x.inflate(R.layout.event_page, null);

        modifyView();

        setContentView(view);

    }

    public View modifyView() {

        TextView title = (TextView) view.findViewById(R.id.textView);
        TextView dates = (TextView) view.findViewById(R.id.textView6);
        TextView location = (TextView) view.findViewById(R.id.textView8);
        ImageView image = (ImageView) view.findViewById(R.id.imageView);
        TextView description = (TextView) view.findViewById(R.id.textView10);

        title.setText(ccg.getEventList().get(EventPage.eventLocation).getTitle());
        dates.setText(ccg.getEventList().get(EventPage.eventLocation).getDate());
        location.setText(ccg.getEventList().get(EventPage.eventLocation).getLocation());
        image.setImageResource(ccg.getEventList().get(EventPage.eventLocation).getImage());
        description.setText(ccg.getEventList().get(EventPage.eventLocation).getDescription());

        return view;
    }
}


