package com.example.jozsef.myweekend.androidCode;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jozsef.myweekend.javaCode.Objects.Event;
import com.example.jozsef.myweekend.javaCode.Objects.EventList;
import com.example.jozsef.myweekend.R;
import com.example.jozsef.myweekend.javaCode.Objects.UserList;

import java.text.SimpleDateFormat;
import java.util.List;

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
    Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findEvent();

        LayoutInflater x = getLayoutInflater();
        view = x.inflate(R.layout.event_page, null);

        modifyView();

        setContentView(view);

        like();
        attend();
        url();
        contact();
        yourWeekend();
    }
    public void findEvent(){
        for(int i = 0; i<EventList.getEventList().size(); i++)
            if(eventLocation == EventList.getEventList().get(i).idNumber)
                event = EventList.getEventList().get(i);
    }


    public View modifyView() {
        SimpleDateFormat monthDay = new SimpleDateFormat("MMMMMMMMMMMM dd, HH:MM");
        SimpleDateFormat year = new SimpleDateFormat("yyyy");

        TextView title = (TextView) view.findViewById(R.id.textView);
        TextView dates = (TextView) view.findViewById(R.id.textView6);
        TextView location = (TextView) view.findViewById(R.id.textView8);
        ImageView image = (ImageView) view.findViewById(R.id.imageView);
        TextView description = (TextView) view.findViewById(R.id.textView10);
        TextView user = (TextView) view.findViewById(R.id.submittedBy);
        TextView name = (TextView) view.findViewById(R.id.pcName);
        TextView email = (TextView) view.findViewById(R.id.pcEmail);
        TextView url = (TextView) view.findViewById(R.id.url);
        TextView phone = (TextView) view.findViewById(R.id.pcPhone);

        title.setText(event.getTitle());
        dates.setText(monthDay.format(event.getDate()) + "\n" + year.format(event.getDate()));
        location.setText(event.getLocation());
        image.setImageResource(event.getImage());
        description.setText(event.getDescription());
        user.setText(event.getSubmittedBy());
        name.setText(event.getPcName());
        email.setText(event.getPcEmail());
        url.setText(event.getEventURL());
        phone.setText(event.getPcPhone());


        return view;
    }
    public void like(){
        Button like = (Button)findViewById(R.id.buttonLike);
        like.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                UserList.getCurrentUser().getPreferancesLike().incrementPreferences(event);
            }
        });
    }
    public void attend(){
        Button attend = (Button)findViewById(R.id.buttonAttend);
        attend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                UserList.getCurrentUser().getPreferancesAttended().incrementPreferences(event);
            }
        });
    }
    public void contact(){
        Button contact = (Button)findViewById(R.id.buttonContact);
        final TextView phone = (TextView)findViewById(R.id.pcPhone);
        final TextView name = (TextView)findViewById(R.id.pcName);
        final TextView email = (TextView)findViewById(R.id.pcEmail);

        if((event.getPcPhone()!=null && event.getPcPhone().length()>0) || (event.getPcEmail()!=null && event.getPcEmail().length()>0) || (event.getPcName()!=null && event.getPcName().length()>0))
            contact.setVisibility(View.VISIBLE);

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(event.getPcEmail()!=null && event.getPcEmail().length()>0)
                    email.setVisibility(View.VISIBLE);
                if(event.getPcName()!=null && event.getPcName().length()>0)
                    name.setVisibility(View.VISIBLE);
                if(event.getPcPhone()!=null && event.getPcPhone().length()>0)
                    phone.setVisibility(View.VISIBLE);            }
        });
    }
    public void url(){
        Button url = (Button)findViewById(R.id.buttonUrl);
        final TextView urlT = (TextView)findViewById(R.id.url);
        if(event.getEventURL()!=null && event.getEventURL().length()>1)
            url.setVisibility(View.VISIBLE);

        url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlT.setVisibility(View.VISIBLE);
            }
        });

    }
    public void yourWeekend(){
        Button yourWeekend = (Button)findViewById(R.id.buttonYourWeekend);
        Button attend = (Button)findViewById(R.id.buttonAttend);
        Button like = (Button)findViewById(R.id.buttonLike);
        if(UserList.getCurrentUser()==null) {
            yourWeekend.setVisibility(View.GONE);
            attend.setVisibility(View.GONE);
            like.setVisibility(View.GONE);
        }
        yourWeekend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                List <Event> list= UserList.getCurrentUser().getMyWeekend();
                if(!list.contains(event))
                    list.add(event);
            }
        });
    }
}


