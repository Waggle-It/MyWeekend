package com.example.jozsef.myweekend;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jozsef on 10/14/2014.
 */
public class Event_List extends Activity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventselector);
        list= (ListView) findViewById(R.id.listView);
        list.setAdapter(new eventAdapter(this));
    }
}

class SingleRow
{
    String title;
    String date;
    int image;

    SingleRow(String title, String date, int image){
        this.title=title;
        this.date=date;
        this.image=image;
    }

}

class eventAdapter extends BaseAdapter
{
    ArrayList<SingleRow> list;
    Context context;

    eventAdapter(Context c)
    {
        context=c;
        list=new ArrayList<SingleRow>();

        String[] titles = {"event0", "event1", "event2", "event3", "event4", "event5", "event6", "event7", "event8", "event9", "event0", "event1", "event2", "event3", "event4", "event5", "event6", "event7", "event8", "event9"};
        String[] dates = {"10/14/14", "10/22/14", "11/01/14", "11/12/14", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA",  "TBA", "TBA", "TBA",  "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA"};
        int [] images ={R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher};

        for(int i=0; i<20; i++){

            list.add(new SingleRow(titles[i], dates[i], images[i]));
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row, viewGroup, false);

        TextView title = (TextView) row.findViewById(R.id.textView8);
        TextView dates = (TextView) row.findViewById(R.id.textView9);
        ImageView image = (ImageView) row.findViewById(R.id.imageView2);

        SingleRow temp = list.get(i);

        title.setText(temp.title);
        dates.setText(temp.date);
        image.setImageResource(temp.image);

        return row;
    }
}
