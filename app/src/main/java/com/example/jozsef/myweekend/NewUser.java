package com.example.jozsef.myweekend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

    private String getConfirmPassword(){
        EditText confirmPassword = (EditText)findViewById(R.id.passwordConfirm);
        return confirmPassword.getText().toString();
    }

    private int getZipCode(){
        EditText zip = (EditText)findViewById(R.id.Zip);

        try {
            int x = Integer.parseInt(zip.getText().toString());
            return x;
        }
       catch(Exception e){}

        Toast.makeText(NewUser.this, "Please enter a valid zip code", Toast.LENGTH_LONG).show();

        return 0;
    }

    private void create(){
        Button create= (Button)findViewById(R.id.Button);


        create.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int[] preferancesLike = new int[21];

                if(verifyEmail(getEmail()) && verifyPassword(getPassword(), getConfirmPassword()) && verifyZip(getZipCode()) && uniqueUser() && verifyEmail()) {
                    for (int i = 0; i < 21; i++) {
                        preferancesLike[i] = 0;
                    }

                    User newUser = new User(getEmail(), getPassword(), getZipCode(), preferancesLike);
                    UserList.addUser(newUser);

                    startActivity(new Intent(NewUser.this, Login.class));
                }


            }
        });
    }

    private boolean verifyPassword(String password, String confirmPassword){
        if (password.length()>7) {
            if(password.equals(confirmPassword))
                return true;
            else
                Toast.makeText(NewUser.this, "Password does not match confirmation password", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(NewUser.this, "Password must be at least 8 characters", Toast.LENGTH_LONG).show();

        return false;
    }

    private boolean verifyEmail(String email){
        return true;
    }


    private boolean verifyZip(int Zip){
        if(Integer.toString(Zip).length()==5) {
            return true;

        }
        else
            Toast.makeText(NewUser.this, "Invalid Zip Code", Toast.LENGTH_LONG).show();


        return false;
    }

    private boolean uniqueUser(){
        ;
        boolean unique = true;

        for(int i=0; i<UserList.getUserListLength(); i++) {
            if (UserList.getUserEmail(i).equals(getEmail()))
                unique = false;
        }
        if(!unique)
        Toast.makeText(NewUser.this, "Account already exists" , Toast.LENGTH_LONG).show();

        return unique;
    }

    //Code borrowed from http://examples.javacodegeeks.com/
    private boolean verifyEmail(){

        Pattern pattern;
        Matcher matcher;

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

            pattern = Pattern.compile(EMAIL_PATTERN);

            matcher = pattern.matcher(getEmail());

        if(!matcher.matches())
            Toast.makeText(NewUser.this, "Not a valid email address" , Toast.LENGTH_LONG).show();

        return matcher.matches();


    }
}