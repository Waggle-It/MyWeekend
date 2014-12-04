package com.example.jozsef.myweekend.androidCode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jozsef.myweekend.javaCode.Objects.Event;
import com.example.jozsef.myweekend.javaCode.Objects.EventList;
import com.example.jozsef.myweekend.R;
import com.example.jozsef.myweekend.javaCode.Objects.Quality;
import com.example.jozsef.myweekend.javaCode.Objects.User;
import com.example.jozsef.myweekend.sortComparators.CatSort;
import com.example.jozsef.myweekend.sortComparators.DateSort;
import com.example.jozsef.myweekend.javaCode.Objects.UserList;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * Simple login display that checks input, also allowing for a guest exploration of the app
 * that prevents the creation of events, and a create new user function.
 */

public class Login extends Activity {

    @Override   //OnCreate links the login xml file with this java class.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        loginSubmission();
        newUser();
        guestUser();
        fakeData();
    }

    //Listens for the user to submit their login information.
    public void loginSubmission() {
        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                verifyUserAndPassword();
            }
        });

    }

    public void newUser() {
        TextView newUser = (TextView) findViewById(R.id.NewUser);

        newUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "Welcome!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Login.this, NewUser.class));
            }
        });

    }

    public void guestUser() {
        TextView guestUser = (TextView) findViewById(R.id.ContGuest);

        guestUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                UserList.setCurrentUser(null);
                startActivity(new Intent(Login.this, SortMenu.class));
            }
        });

    }

    private void verifyUserAndPassword(){
        EditText password = (EditText)findViewById(R.id.password);
        EditText loginId = (EditText)findViewById(R.id.loginId);
        boolean userCorrect, loggedin;

        userCorrect = loggedin = false;
        for(int i=0; i< UserList.getUserListLength(); i++) {
            if(UserList.getUserEmail(i).equals(loginId.getText().toString())) {
                userCorrect = true;
                if (UserList.getPassword(i).equals(password.getText().toString())) {
                    UserList.setCurrentUser(i);
                    startActivity(new Intent(Login.this, SortMenu.class));
                    loggedin=true;
                }
            }
        }
        if(!userCorrect)
                Toast.makeText(Login.this, "Invalid email address", Toast.LENGTH_LONG).show();
            else if(!loggedin)
                Toast.makeText(Login.this, "Password does not match email address", Toast.LENGTH_LONG).show();

    }

    private void fakeData() {

        String[] titles = {"Stats Tutoring Group", "Ice Cream Social", "Apple Picking", "Trip to San Fransisco", "HackMIT", "Pumpkin Patch", "Octoverlovers Hayride", "Barn dance", "IronChef", "Apple Pressing & Cider Making", "Farmer's Market", "Peach Cobbler", "BoilerMake", "Seattle Trip", "PMT run", "Opening for new Ramen shop", "AWESOME HALLOWEEN PARTY", "Juice Bar opens", "WildHacks", "Angela's Birthday Party" };
        String[] location = {"909 Wabash Ave. Mattoon, IL 61938", "6 Hartwell Ct. Savoy, IL 61874", "1306 Cedar Dr. Killeen, TX 76544", "105 N 16 St. Mattoon, IL 61938", "6 Brian Dr. Mattoon, IL 61938", "2414 Lago Trail Killeen, TX 76544", "3108 Atkinson Ave. Killeen, Tx", "4/3 ACR Fort Hood, Tx", "4/3 ACR BIOP Baghdad Iraq", "3rd ACR rear Det. Fort hood, Tx", "B CO, 173rd Btn, 35th Signal reg. Fort Gordon, Georgia", "F CO, 1st Btn, 13th Infantry Regiment", "1600 Amphitheatre Parkway Mountain View, CA 94043", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA"};
        String description= "Description…\nz\ny\nx\nw\nv\nu\nt\ns\nr\nq\np\no\nn\nm\nl\nk\nj\ni\nh\ng\nf\ne\nd\nc\nb\na\nz\ny\nx\nw\nv\nu\nt\ns\nr\nq\np\no\nn\nm\nl\nk\nj\ni\nh\ng\nf\ne\nd\nc\nb\na\nz\ny\nx\nw\nv\nu\nt\ns\nr\nq\np\no\nn\nm\nl\nk\nj\ni\nh\ng\nf\ne\nd\nc\nb\na\n\nz\ny\nx\nw\nv\nu\nt\ns\nr\nq\np\no\nn\nm\nl\nk\nj\ni\nh\ng\nf\ne\nd\nc\nb\na\n...";

        //int [] images ={R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher};
        int images = R.drawable.download;

        User me = new User("j", "j", 61938);
        UserList.addUser(me);


        for(int i=0; i<20; i++){//builds each list element.
            double foodCosts = Math.random()*999;
            double ticketCosts = Math.random()*999;
            //list.add(new SingleRow(titles[i], dates[i], images));
            long dates = (1414713600 + Math.abs(new Random().nextLong())%(1420113599 - 1414713600 ))*1000L;
            Event temp = new Event( titles[i], location[i], dates, description, rand(), foodCosts, ticketCosts, images, "", "", "", "", "");
            EventList.getEventList().add(temp);
            //date[i]=temp.getDate();
        }
        Collections.sort(EventList.getEventList(), new DateSort());
        CatSort.eventSort();
    }
    public Quality rand(){
        Quality temp = new Quality();
        if((int)(Math.random()*5) == 0)
            temp.setFood(true);
        if((int)(Math.random()*5) == 0)
            temp.setCause(true);
        if((int)(Math.random()*5) == 0)
            temp.setSports(true);
        if((int)(Math.random()*5) == 0)
            temp.setBusiness(true);
        if((int)(Math.random()*5) == 0)
            temp.setTechnology(true);
        if((int)(Math.random()*5) == 0)
            temp.setEducation(true);
        if((int)(Math.random()*5) == 0)
            temp.setEducation(true);
        if((int)(Math.random()*5) == 0)
            temp.setEntertainment(true);
        if((int)(Math.random()*5) == 0)
            temp.setFashion(true);
        if((int)(Math.random()*5) == 0)
            temp.setHealth(true);
        if((int)(Math.random()*5) == 0)
            temp.setHobbies(true);
        if((int)(Math.random()*5) == 0)
            temp.setHoliday(true);
        if((int)(Math.random()*5) == 0)
            temp.setLifestyle(true);
        if((int)(Math.random()*5) == 0)
            temp.setMusic(true);
        if((int)(Math.random()*5) == 0)
            temp.setOther(true);
        if((int)(Math.random()*5) == 0)
            temp.setOutdoor(true);
        if((int)(Math.random()*5) == 0)
            temp.setPolitics(true);
        if((int)(Math.random()*5) == 0)
            temp.setReligious(true);
        if((int)(Math.random()*5) == 0)
            temp.setSports(true);
        if((int)(Math.random()*5) == 0)
            temp.setVisual_arts(true);
        if((int)(Math.random()*5) == 0)
            temp.setVehicle(true);

        return temp;
    }
}