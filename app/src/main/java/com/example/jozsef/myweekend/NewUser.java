package com.example.jozsef.myweekend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Jozsef on 10/31/2014.
 */
public class NewUser extends Activity{

    @Override   //OnCreate links the login xml file with this java class.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.new_user);

        create();

    }

    private String getEmail(){
        EditText email = (EditText)findViewById(R.id.Email);
        return email.getText().toString();
    }
    private String getPassword(){
        EditText password = (EditText)findViewById(R.id.password);
        return password.getText().toString();
    }
    private int getZipCode(){
        EditText zip = (EditText)findViewById(R.id.Zip);
        return zip.getInputType();
    }

    private void create(){
        Button create= (Button)findViewById(R.id.Button);


        create.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int[] preferancesLike = new int[21];

                for(int i=0; i<21; i++) {
                    preferancesLike[i] = 0;
                }

                User newUser = new User(getEmail(), getPassword(), getZipCode(), preferancesLike);
                UserList.addUser(newUser);

                startActivity(new Intent(NewUser.this, Login.class));
            }
        });
    }
}
