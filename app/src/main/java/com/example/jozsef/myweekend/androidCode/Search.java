package com.example.jozsef.myweekend.androidCode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jozsef.myweekend.R;
import com.example.jozsef.myweekend.javaCode.Objects.EventList;

/**
 * Created by Jozsef on 12/2/2014.
 */
public class Search extends Activity {
    View view;

    @Override   //Retrieves the xml layout view from create_event
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.search);

        LayoutInflater x = getLayoutInflater();
        view = x.inflate(R.layout.create_event, null);

        setContentView(view);

        Button create= (Button)findViewById(R.id.button);

        create.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                {
                    startActivity(new Intent(Search.this, Event_List.class));
                }
            }
        });

    }
}
