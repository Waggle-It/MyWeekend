package com.example.jozsef.myweekend;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by Jozsef on 10/9/2014.
 */
public class EventList extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.eventselector);


        Button event1;
        event1 = (Button) findViewById(R.id.Event1);


        event1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });




    }

    public void loginSubmission(View v){

    }


}
