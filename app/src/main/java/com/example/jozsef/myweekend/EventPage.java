package com.example.jozsef.myweekend;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.jozsef.myweekend.R.layout.*;

/**
 * Created by Jozsef on 10/15/2014.
 */
public class EventPage extends Activity {


    public static int eventLocation;
    public static EventList ccg;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view=findViewById(R.id.event_page);
        LayoutInflater x = getLayoutInflater();
        view = x.inflate(R.layout.event_page, null);

        TextView title = (TextView) view.findViewById(R.id.textView);
        TextView dates = (TextView) view.findViewById(R.id.textView6);
        TextView location = (TextView) view.findViewById(R.id.textView8);
        ImageView image = (ImageView) view.findViewById(R.id.imageView);
        TextView description = (TextView) view.findViewById(R.id.textView10);


        title.setText(ccg.getEventList(EventPage.eventLocation).getTitle());
        dates.setText(ccg.getEventList(EventPage.eventLocation).getDate());
        location.setText(ccg.getEventList(EventPage.eventLocation).getLocation());
        image.setImageResource(ccg.getEventList(EventPage.eventLocation).image);
        description.setText(ccg.getEventList(EventPage.eventLocation).getDescription());
        setContentView(view);
    }

}


