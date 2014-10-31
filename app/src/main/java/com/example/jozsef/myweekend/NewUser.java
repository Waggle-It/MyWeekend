package com.example.jozsef.myweekend;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Jozsef on 10/31/2014.
 */
public class NewUser extends Activity{

    @Override   //OnCreate links the login xml file with this java class.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.new_user);
    }
}
