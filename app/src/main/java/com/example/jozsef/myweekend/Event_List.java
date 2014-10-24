package com.example.jozsef.myweekend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**I changed somthing
 * Created by Jozsef on 10/14/2014.
 */
public class Event_List extends Activity implements AdapterView.OnItemClickListener{


    ListView list;//consolidates the objects created for each set of data.

    @Override//this method is required to link this java file to the android xml file eventselector.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventselector);//This declares the overall list view
        list= (ListView) findViewById(R.id.listView);//links java list to android listView
        list.setAdapter(new eventAdapter(this));//Calls method eventAdapter which customizes the layout.
        list.setOnItemClickListener(this);//recieves user input.
    }

    @Override//Directs display based on user input.
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        EventPage.eventLocation=i;//sinks the array location selected with that of the displayed.
        Intent intent= new Intent(Event_List.this, EventPage.class);//required to change java class.
        startActivity(intent);
    }
}

//Customizes list view layout......My understanding breaks down.
class eventAdapter extends BaseAdapter
{   EventList og = new EventList();


    //ArrayList<SingleRow> list;
    Context context;

    eventAdapter(Context c)
    {
        context=c;
      //  list=new ArrayList<SingleRow>();//declares list an arrayList  of data from SingleRow.


        String[] titles = {"Stats Tutoring Group", "Ice Cream Social", "Apple Picking", "Trip to San Fransisco", "HackMIT", "Pumpkin Patch", "Octoverlovers Hayride", "Barn dance", "IronChef", "Apple Pressing & Cider Making", "Farmer's Market", "Peach Cobbler", "BoilerMake", "Seattle Trip", "PMT run", "Opening for new Ramen shop", "AWESOME HALLOWEEN PARTY", "Juice Bar opens", "WildHacks", "Angela's Birthday Party" };
        String[] dates = {"10/15/14 10:00am", "10/16/14 11:00am", "10/17/14 12:00pm","10/18/14 1:00pm","10/18/14 2:00pm","10/17/14 11:00am","10/19/14 2:00pm","10/21/14 6:00pm","10/18/14 3:00pm","10/29/14 7:00pm","10/23/14 3:00pm","10/25/14 6:00pm","10/22/14 7:00pm","10/25/14 4:00pm","10/28/14 2:00pm","10/30/14 8:00pm","10/31/14 11:00pm","10/29/14 11:00pm","10/27/14 5:00pm","11/16/14 8:00am"};
        String[] location = {"909 Wabash Ave. Mattoon, IL 61938", "6 Hartwell Ct. Savoy, IL 61874", "1306 Cedar Dr. Killeen, TX 76544", "105 N 16 St. Mattoon, IL 61938", "6 Brian Dr. Mattoon, IL 61938", "2414 Lago Trail Killeen, TX 76544", "3108 Atkinson Ave. Killeen, Tx", "4/3 ACR Fort Hood, Tx", "4/3 ACR BIOP Baghdad Iraq", "3rd ACR rear Det. Fort hood, Tx", "B CO, 173rd Btn, 35th Signal reg. Fort Gordon, Georgia", "F CO, 1st Btn, 13th Infantry Regiment", "1600 Amphitheatre Parkway Mountain View, CA 94043", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA"};
        String description= "Discription…\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n...";
        //int [] images ={R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher};
        int images = R.drawable.ic_launcher;



        for(int i=0; i<20; i++){//builds each list element.
            boolean hasFood= ((int)(Math.random()*2)==0);
            double price = Math.random()*999;
                //list.add(new SingleRow(titles[i], dates[i], images));
                Event temp = new Event( titles[i], location[i], dates[i], description, hasFood, price, images);
                og.addEvent(temp);
        }
    }

    @Override
    public int getCount() {
        return og.getLength();
    }

    @Override
    public Object getItem(int i) {
        return og.getEventList(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //inflater allows for easy access to modify existing values of xml files. Alowing us to match the layout of single_row.
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row, viewGroup, false);

        //Links the values within xml
        TextView title = (TextView) row.findViewById(R.id.textView8);
        TextView dates = (TextView) row.findViewById(R.id.textView9);
        ImageView image = (ImageView) row.findViewById(R.id.imageView2);

        //Changes the values
        title.setText(og.getEventList(i).getTitle());
        dates.setText(og.getEventList(i).getDate());
        image.setImageResource(og.getEventList(i).getImage());

        EventPage.ccg=og;
        return row;

    }
}
