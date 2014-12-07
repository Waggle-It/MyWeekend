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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jozsef.myweekend.R;
import com.example.jozsef.myweekend.javaCode.Objects.EventList;
import com.example.jozsef.myweekend.javaCode.Objects.QualityList;

/**
 * Created by Jozsef on 10/30/2014.
 * Sort menu is a Grid that could be set up to change based on the users preferences
 * to more accurately suggest categories of the users interest.
 */
public class SortMenu extends Activity implements AdapterView.OnItemClickListener{

    GridView Grid;//consolidates the objects created for each set of data.

    @Override//this method is required to link this java file to the android xml file eventselector.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sort_menu);//This declares the overall list view
        Grid = (GridView) findViewById(R.id.gridView);//links java list to android listView
        Grid.setAdapter(new sortAdapter(this));//Calls method eventAdapter which customizes the layout.
        Grid.setOnItemClickListener(this);//recieves user input.
    }

    @Override//Directs display based on user input.
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    //EventPage.eventLocation = i;//sinks the array location selected with that of the displayed.
        String[] categories = this.getResources().getStringArray(R.array.sort);
        eventAdapter.current = QualityList.getEventList(categories[i]);//sinks the array location selected with that of the displayed.
        Intent intent = new Intent(SortMenu.this, Event_List.class);//required to change java class.
        if(i == 0)
            intent = new Intent(SortMenu.this, Search.class);
        startActivity(intent);
    }
}

class sortAdapter extends BaseAdapter
{
    //ArrayList<SingleRow> list;
    Context context;
    String[] catagories;

    sortAdapter(Context c)
    {   context=c;
        catagories = context.getResources().getStringArray(R.array.sort);

        //  list=new ArrayList<SingleRow>();//declares list an arrayList  of data from SingleRow.
    }

    @Override
    public int getCount() {
        return 28;
    }

    @Override
    public Object getItem(int i) {
        return catagories[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int[] images = {R.drawable.search, R.drawable.today, R.drawable.your_weekend, R.drawable.step_out_of_your_box, R.drawable.recommended, R.drawable.popular, R.drawable.all_events, R.drawable.car_plane, R.drawable.buisness, R.drawable.charity, R.drawable.education, R.drawable.fashion, R.drawable.film_media, R.drawable.has_food, R.drawable.culinary, R.drawable.politics, R.drawable.health, R.drawable.interest, R.drawable.home, R.drawable.music, R.drawable.other, R.drawable.visual_arts, R.drawable.religion, R.drawable.technology, R.drawable.holiday, R.drawable.sports, R.drawable.money, R.drawable.travel};

        //inflater allows for easy access to modify existing values of xml files. Alowing us to match the layout of single_row.
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View block=inflater.inflate(R.layout.single_block, viewGroup, false);

        //Links the values within xml
        TextView area = (TextView) block.findViewById(R.id.textView);
        ImageView image = (ImageView) block.findViewById(R.id.background);

        //Changes the values
        area.setText(catagories[i]);
        image.setImageResource(images[i]);

        return block;

    }

}
