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
        Event myBday = new Event( "My Birthday", "6 Hartwell Ct. Savoy, IL 61938", 1418544000000L, "Horse Farm\n" +
                "Posted at: 2009-07-14 15:12:55\n" +
                "Original ad: \n" +
                "I am a 18 year old looking for a summer job. it is hard for me to find work and I just want a job so I can afford a car for college next summer. I can clean, babysit, answer phones, pretty much whatever as long as it pays!!\n" +
                "From Mike Anderson to ***********@***********.org\n" +
                "Hey, \n" +
                "\n" +
                "I saw your ad looking for work and I think I have a job for you! I am looking for an assistant on my farm for the summer. It will involve working outdoors. Let me know if you are interested. \n" +
                "\n" +
                "Mike\n" +
                "\n" +
                "From Stephanie ******* to Me\n" +
                "Hi Mike! I am interested in your job! I love animals and used to ride horses so a farm would be great! what kind of work would I be doing, and where is your farm located? it needs to be close to ******** so my parents can drop me off and pick meup\n" +
                "\n" +
                "From Mike Anderson to Stephanie *********\n" +
                "Stephanie,\n" +
                "\n" +
                "It is very close to **********. I'm glad to hear you are familiar with horses, because you will be primarily working with horses.\n" +
                "\n" +
                "My farm gets all the old horses that other farms don't need anymore, and they are starting to take up a lot of room in my stable, which I want to turn into a garage for my new truck. Therefore, the horses need to go. As my assistant, you will be in charge of killing the horses and dumping them in the lake behind my farm. \n" +
                "\n" +
                "I used to have a captive bolt pistol (cattle gun) that I used to put them down, but it broke when I tried to use it to tap a keg. You'll probably have to use my 12-gauge shotgun to put them down. Sometimes they don't die right away when you shoot them, and will start freaking out. You just have to stay calm and keep shooting. Don't worry, I'll show you how to use the shotgun if you aren't familiar with one.\n" +
                "\n" +
                "You then need to use my chainsaw to cut the horses into smaller parts that you can carry down to the lake. It can get a little messy, so I suggest wearing some clothes that you don't care about, or some clothes that the horse blood would compliment. \n" +
                "\n" +
                "The lake isn't mine, it is my neighbor's. He gets kind of angry when he sees me dumping dead horses in his lake, so you have to make sure he isn't around when you do it. I have some cinderblocks you can use to weigh the horses down so he won't see them. \n" +
                "\n" +
                "I have a lot of horses, and each horse takes about an hour and a half to dispose of, so you should have plenty of work. The job will pay $15 an hour. When can you start? \n" +
                "\n" +
                "Mike\n" +
                "\n" +
                "From Stephanie ******* to Me\n" +
                "omg that is HORRIBLE! That is truely awful and sick!! Why cant you just give the poor horses away? sorry but I am not helping you slaughter horses!!!\n" +
                "\n" +
                "From Mike Anderson to Stephanie *********\n" +
                "Stephanie,\n" +
                "\n" +
                "I'm sorry if you are a bit surprised, but this is how farms work. You can't give away old horses, you have to kill them. I thought about it, and if you don't want to use the chainsaw to cut up the horses, you can just use my truck to drag them down to the lake. Do you have your license or permit? If not, this could be good driving practice for you. You don't want to pass up on this great job opportunity.\n" +
                "\n" +
                "Mike\n" +
                "\n" +
                "From Stephanie ******* to Me\n" +
                "No that is not how farms work you are just SICK! I am NOT interested\n" +
                "\n" +
                "From Mike Anderson to Stephanie *********\n" +
                "Stephanie you are going to regret this some day when you try to get a real job. I think this would look great on your resume.", rand(), 0, 0, R.drawable.download, "jozsef.morrissey", "Jozsef Morrissey", "jozsef.morrissey@gmail.com", "https://www.facebook.com/jozsef.morrissey", "2172548654");
        myBday.getcharacteristics().setHasFood(true);
        EventList.getEventList().add(myBday);

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
        if((int)(Math.random()*7) == 0)
            temp.setFood(true);
        if((int)(Math.random()*7) == 0)
            temp.setCause(true);
        if((int)(Math.random()*7) == 0)
            temp.setSports(true);
        if((int)(Math.random()*7) == 0)
            temp.setBusiness(true);
        if((int)(Math.random()*7) == 0)
            temp.setTechnology(true);
        if((int)(Math.random()*7) == 0)
            temp.setEducation(true);
        if((int)(Math.random()*7) == 0)
            temp.setEducation(true);
        if((int)(Math.random()*7) == 0)
            temp.setEntertainment(true);
        if((int)(Math.random()*7) == 0)
            temp.setFashion(true);
        if((int)(Math.random()*7) == 0)
            temp.setHealth(true);
        if((int)(Math.random()*7) == 0)
            temp.setHobbies(true);
        if((int)(Math.random()*7) == 0)
            temp.setHoliday(true);
        if((int)(Math.random()*7) == 0)
            temp.setLifestyle(true);
        if((int)(Math.random()*7) == 0)
            temp.setMusic(true);
        if((int)(Math.random()*7) == 0)
            temp.setOther(true);
        if((int)(Math.random()*7) == 0)
            temp.setOutdoor(true);
        if((int)(Math.random()*7) == 0)
            temp.setPolitics(true);
        if((int)(Math.random()*7) == 0)
            temp.setReligious(true);
        if((int)(Math.random()*7) == 0)
            temp.setSports(true);
        if((int)(Math.random()*7) == 0)
            temp.setVisual_arts(true);
        if((int)(Math.random()*7) == 0)
            temp.setVehicle(true);

        return temp;
    }
}