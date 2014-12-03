package com.example.jozsef.myweekend.androidCode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jozsef.myweekend.R;
import com.example.jozsef.myweekend.javaCode.Objects.Event;
import com.example.jozsef.myweekend.javaCode.Objects.EventList;
import com.example.jozsef.myweekend.javaCode.Objects.UserList;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Jozsef on 10/14/2014.
 * This is the list of events that is displayed "according to the category selected" this customization
 * of the list based on categories is possible however a method needs to be created to control
 * what events are displayed.
 */
public class Event_List extends Activity implements AdapterView.OnItemClickListener {

    public static int[] eventLocation;
    ListView list;//consolidates the objects created for each set of data.

    @Override//this method is required to link this java file to the android xml file eventselector.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventselector);//This declares the overall list view
        list = (ListView) findViewById(R.id.listView);//links java list to android listView
        list.setAdapter(new eventAdapter(this));//Calls method eventAdapter which customizes the layout.
        list.setOnItemClickListener(this);//recieves user input.
        createNewEvent();
    }

    @Override//Directs display based on user input.
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        EventPage.eventLocation = eventAdapter.current.get(i).idNumber;//sinks the array location selected with that of the displayed.
        Intent intent = new Intent(Event_List.this, EventPage.class);//required to change java class.
        startActivity(intent);
    }

    public void createNewEvent() {
        Button createNew = (Button) findViewById(R.id.button);
        final Context display = this.getApplicationContext();
            createNew.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if(UserList.getCurrentUser()==null)
                        Toast.makeText(display, "Please log in to create an event", Toast.LENGTH_LONG).show();
                    else
                        startActivity(new Intent(Event_List.this, Create_Event.class));
                }
            });
    }
}

//Customizes list view layout......My understanding breaks down.
class eventAdapter extends BaseAdapter
{   public static List<Event> current;
    //ArrayList<SingleRow> list;
    Context context;

    eventAdapter(Context c)
    {
        context=c;
      //  list=new ArrayList<SingleRow>();//declares list an arrayList  of data from SingleRow.

    }

    @Override
    public int getCount() {
        return current.size();
    }

    @Override
    public Object getItem(int i) {
        return EventList.getEventList().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        SimpleDateFormat monthDay = new SimpleDateFormat("MMMMMMMMMMMM dd");


        //inflater allows for easy access to modify existing values of xml files. Alowing us to match the layout of single_row.
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row, viewGroup, false);

        //Links the values within xml
        TextView title = (TextView) row.findViewById(R.id.textView8);
        TextView dates = (TextView) row.findViewById(R.id.textView9);
        ImageView image = (ImageView) row.findViewById(R.id.imageView2);

        //Changes the values
        title.setText(current.get(i).getTitle());
        dates.setText(monthDay.format(current.get(i).getDate()));
        image.setImageResource(current.get(i).getImage());

        return row;

    }
}
