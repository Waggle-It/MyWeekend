package com.example.jozsef.myweekend.androidCode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jozsef.myweekend.javaCode.VerifyCreateNewUser;
import com.example.jozsef.myweekend.R;


/**
 * Created by Jozsef on 10/31/2014.
 * This is the create new user display page with all the various inputs being sent to verifyNewUser
 * to insure unique and accurate information before construction.
 */
public class NewUser extends Activity{
    private static Context display;

    @Override   //OnCreate links the login xml file with this java class.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.new_user);

        Button create= (Button)findViewById(R.id.Button);

        display = this.getApplicationContext();

        create.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                VerifyCreateNewUser temp = new VerifyCreateNewUser();
                boolean newMember = temp.create(getEmail(), getPassword(), getConfirmPassword(), getZipCode());

                if(newMember)
                    startActivity(new Intent(NewUser.this, Login.class));
            }
        });
    }

    private String getEmail(){
        EditText email = (EditText)findViewById(R.id.Email);
        if(email==null)
            return "";
        return email.getText().toString();
    }

    private String getPassword(){
        EditText password = (EditText)findViewById(R.id.password);
        if(password==null)
            return "";
        return password.getText().toString();
    }

    private String getConfirmPassword(){
        EditText confirmPassword = (EditText)findViewById(R.id.passwordConfirm);
        if(confirmPassword==null)
            return "";
        return confirmPassword.getText().toString();
    }

    private int getZipCode(){
        EditText zip = (EditText)findViewById(R.id.Zip);

        try {
            return Integer.parseInt(zip.getText().toString());
        }
        catch(Exception e){}

        Toast.makeText(display, "Please enter a valid zip code", Toast.LENGTH_LONG).show();

        return 0;
    }

    public void passwordMatchError(){
        Toast.makeText(display, "Password does not match confirmation password", Toast.LENGTH_LONG).show();

    }

    public void passWordParameterError(){
        Toast.makeText(display, "Password must be at least 8 characters", Toast.LENGTH_LONG).show();
    }

    public void validZipError(){
        Toast.makeText(display, "Invalid Zip Code", Toast.LENGTH_LONG).show();
    }

    public void acctAlreadyRegisteredError(){
        Toast.makeText(display, "Account already exists" , Toast.LENGTH_LONG).show();
    }
    public void invalidEmailError(){

        Toast.makeText(display, "Not a valid email address" , Toast.LENGTH_LONG).show();

    }
}