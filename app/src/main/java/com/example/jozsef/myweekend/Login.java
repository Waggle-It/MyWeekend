package com.example.jozsef.myweekend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


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
            EditText password = (EditText)findViewById(R.id.password);
            EditText loginId = (EditText)findViewById(R.id.loginId);
            if(UserList.getPassword(0).equals(password.getText().toString()) && UserList.getUserEmail(0).equals(loginId.getText().toString()))
                startActivity(new Intent(Login.this, SortMenu.class));
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
                startActivity(new Intent(Login.this, SortMenu.class));
            }
        });

    }

    private void fakeData() {
        EventList og = new EventList();

        String[] titles = {"Stats Tutoring Group", "Ice Cream Social", "Apple Picking", "Trip to San Fransisco", "HackMIT", "Pumpkin Patch", "Octoverlovers Hayride", "Barn dance", "IronChef", "Apple Pressing & Cider Making", "Farmer's Market", "Peach Cobbler", "BoilerMake", "Seattle Trip", "PMT run", "Opening for new Ramen shop", "AWESOME HALLOWEEN PARTY", "Juice Bar opens", "WildHacks", "Angela's Birthday Party" };
        String[] dates = {"10/15/14 10:00am", "10/16/14 11:00am", "10/17/14 12:00pm","10/18/14 1:00pm","10/18/14 2:00pm","10/17/14 11:00am","10/19/14 2:00pm","10/21/14 6:00pm","10/18/14 3:00pm","10/29/14 7:00pm","10/23/14 3:00pm","10/25/14 6:00pm","10/22/14 7:00pm","10/25/14 4:00pm","10/28/14 2:00pm","10/30/14 8:00pm","10/31/14 11:00pm","10/29/14 11:00pm","10/27/14 5:00pm","11/16/14 8:00am"};
        String[] location = {"909 Wabash Ave. Mattoon, IL 61938", "6 Hartwell Ct. Savoy, IL 61874", "1306 Cedar Dr. Killeen, TX 76544", "105 N 16 St. Mattoon, IL 61938", "6 Brian Dr. Mattoon, IL 61938", "2414 Lago Trail Killeen, TX 76544", "3108 Atkinson Ave. Killeen, Tx", "4/3 ACR Fort Hood, Tx", "4/3 ACR BIOP Baghdad Iraq", "3rd ACR rear Det. Fort hood, Tx", "B CO, 173rd Btn, 35th Signal reg. Fort Gordon, Georgia", "F CO, 1st Btn, 13th Infantry Regiment", "1600 Amphitheatre Parkway Mountain View, CA 94043", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA", "TBA"};
        String description= "Description…\nz\ny\nx\nw\nv\nu\nt\ns\nr\nq\np\no\nn\nm\nl\nk\nj\ni\nh\ng\nf\ne\nd\nc\nb\na\nz\ny\nx\nw\nv\nu\nt\ns\nr\nq\np\no\nn\nm\nl\nk\nj\ni\nh\ng\nf\ne\nd\nc\nb\na\nz\ny\nx\nw\nv\nu\nt\ns\nr\nq\np\no\nn\nm\nl\nk\nj\ni\nh\ng\nf\ne\nd\nc\nb\na\n\nz\ny\nx\nw\nv\nu\nt\ns\nr\nq\np\no\nn\nm\nl\nk\nj\ni\nh\ng\nf\ne\nd\nc\nb\na\n...";

        boolean[] characteristics = new boolean[21];

        //int [] images ={R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher};
        int images = R.drawable.ic_launcher;

        for(int i=0; i<21; i++){
            characteristics[i]=Math.random()*2==0;
        }



        for(int i=0; i<20; i++){//builds each list element.
            double foodCosts = Math.random()*999;
            double ticketCosts = Math.random()*999;
            //list.add(new SingleRow(titles[i], dates[i], images));
            Event temp = new Event( titles[i], location[i], dates[i], description, characteristics, foodCosts, ticketCosts, images);
            og.addEvent(temp);

            eventAdapter.og=og;
            Create_Event.ccg=og;
        }
    }
}

