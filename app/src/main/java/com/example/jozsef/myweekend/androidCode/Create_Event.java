package com.example.jozsef.myweekend.androidCode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jozsef.myweekend.R;
import com.example.jozsef.myweekend.javaCode.Objects.Event;
import com.example.jozsef.myweekend.javaCode.Objects.EventList;
import com.example.jozsef.myweekend.javaCode.Objects.Quality;
import com.example.jozsef.myweekend.javaCode.Objects.UserList;
import com.example.jozsef.myweekend.javaCode.VerifyCreateEvent;
import com.example.jozsef.myweekend.sortComparators.CatSort;
import com.example.jozsef.myweekend.sortComparators.DateSort;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;


/**
 * Created by Jozsef on 10/24/2014.
 *
 * This takes input from the create event xml from the user and adds a new event to our system.
 */
public class Create_Event extends Activity {
    View view;

    @Override   //Retrieves the xml layout view from create_event
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater x = getLayoutInflater();
        view = x.inflate(R.layout.create_event, null);

        setContentView(view);

        Button create= (Button)findViewById(R.id.button);

        create.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(verify()) {
                    create();
                    startActivity(new Intent(Create_Event.this, SortMenu.class));
                }
                else
                    Toast.makeText(Create_Event.this, "Please fill in indicated Fields (*)", Toast.LENGTH_LONG).show();

            }
        });
    }
    //tests user inputs and activates astrix icons beside required inputs.
    public boolean verify(){
        boolean returnVal=true;
        VerifyCreateEvent sugar = new VerifyCreateEvent();
        if(!sugar.verifyPCEmail(getPCEmail())) {
            TextView astrix = (TextView)findViewById(R.id.Required9);
            astrix.setVisibility(View.VISIBLE);
            TextView required = (TextView)findViewById(R.id.textViewRequired);
            required.setVisibility(View.VISIBLE);
            returnVal = false;
        }
            else{
                TextView astrix = (TextView)findViewById(R.id.Required9);
                astrix.setVisibility(View.INVISIBLE);
            }

        if(!sugar.verifyEventDate(getEventDateString())) {
            TextView astrix = (TextView)findViewById(R.id.Required2);
            astrix.setVisibility(View.VISIBLE);
            TextView required = (TextView)findViewById(R.id.textViewRequired);
            required.setVisibility(View.VISIBLE);
            returnVal = false;
        }
            else{
                TextView astrix = (TextView)findViewById(R.id.Required2);
                astrix.setVisibility(View.INVISIBLE);
            }
        if(!sugar.verifyEventTime(getTime())){
            TextView astrix = (TextView)findViewById(R.id.Required3);
            astrix.setVisibility(View.VISIBLE);
            TextView required = (TextView)findViewById(R.id.textViewRequired);
            required.setVisibility(View.VISIBLE);
            returnVal = false;
        }
            else{
                TextView astrix = (TextView)findViewById(R.id.Required3);
                astrix.setVisibility(View.INVISIBLE);
            }

        if(!sugar.verifyEventDisc(getEventDescription())) {
            TextView astrix = (TextView)findViewById(R.id.Required8);
            astrix.setVisibility(View.VISIBLE);
            TextView required = (TextView)findViewById(R.id.textViewRequired);
            required.setVisibility(View.VISIBLE);
            returnVal = false;
        }
            else{
                TextView astrix = (TextView)findViewById(R.id.Required8);
                astrix.setVisibility(View.INVISIBLE);
            }

        if(!sugar.verifyEventTitle(getEventTitle())) {
            TextView astrix = (TextView)findViewById(R.id.Required1);
            astrix.setVisibility(View.VISIBLE);
            TextView required = (TextView)findViewById(R.id.textViewRequired);
            required.setVisibility(View.VISIBLE);
            returnVal = false;
        }
            else{
                TextView astrix = (TextView)findViewById(R.id.Required1);
                astrix.setVisibility(View.INVISIBLE);
            }

        if(!sugar.verifyFoodCosts(getEventFoodCosts(), onOff().isFood())) {
            TextView astrix = (TextView)findViewById(R.id.Required10);
            astrix.setVisibility(View.VISIBLE);
            TextView required = (TextView)findViewById(R.id.textViewRequired);
            required.setVisibility(View.VISIBLE);
            returnVal = false;
        }
            else{
                TextView astrix = (TextView)findViewById(R.id.Required10);
                astrix.setVisibility(View.INVISIBLE);
            }

        if(!sugar.verifyEventCity(getEventCity())) {
            TextView astrix = (TextView)findViewById(R.id.Required5);
            astrix.setVisibility(View.VISIBLE);
            TextView required = (TextView)findViewById(R.id.textViewRequired);
            required.setVisibility(View.VISIBLE);
            returnVal = false;
        }
            else{
                TextView astrix = (TextView)findViewById(R.id.Required5);
                astrix.setVisibility(View.INVISIBLE);
            }

        if(!sugar.verifyEventAddress(getEventAddress())) {
            TextView astrix = (TextView)findViewById(R.id.Required4);
            astrix.setVisibility(View.VISIBLE);
            TextView required = (TextView)findViewById(R.id.textViewRequired);
            required.setVisibility(View.VISIBLE);
            returnVal = false;
        }
            else{
                TextView astrix = (TextView)findViewById(R.id.Required4);
                astrix.setVisibility(View.INVISIBLE);
            }

        if(!sugar.verifyZip(getEventZipCode())) {
            TextView astrix = (TextView)findViewById(R.id.Required7);
            astrix.setVisibility(View.VISIBLE);
            TextView required = (TextView)findViewById(R.id.textViewRequired);
            required.setVisibility(View.VISIBLE);
            returnVal = false;
        }
            else{
                TextView astrix = (TextView)findViewById(R.id.Required7);
                astrix.setVisibility(View.INVISIBLE);
            }

        if(!sugar.verifyEventState(getEventState())) {
            TextView astrix = (TextView)findViewById(R.id.Required6);
            astrix.setVisibility(View.VISIBLE);
            TextView required = (TextView)findViewById(R.id.textViewRequired);
            required.setVisibility(View.VISIBLE);
            returnVal = false;
        }
            else{
                TextView astrix = (TextView)findViewById(R.id.Required6);
                astrix.setVisibility(View.INVISIBLE);
            }

        if(!sugar.verifyTicketCosts(getEventTicketCosts())) {
            TextView astrix = (TextView)findViewById(R.id.Required11);
            astrix.setVisibility(View.VISIBLE);
            TextView required = (TextView)findViewById(R.id.textViewRequired);
            required.setVisibility(View.VISIBLE);
            returnVal = false;
        }
        else{
            TextView astrix = (TextView)findViewById(R.id.Required11);
            astrix.setVisibility(View.INVISIBLE);
        }



        return returnVal;

    }
    //Method is activated when the user hits the submit button all fields necessary to create a new event are retrieved.
    private void create(){
        Quality categories;
        String title, location, description, pcName, pcEmail, webLink, submittedBy, phone;
        double foodCosts, ticketCosts;
        int image;
        long date;

        categories = onOff();

        title = getEventTitle();
        location = getEventAddress() + " " + getEventCity() + ", " + getEventState() + " " + getEventZipCode();
        description = getEventDescription();
        date = getEventDateLong();
        pcName = getEventPCName();
        pcEmail = getPCEmail();
        submittedBy = getSubmittedBy();
        webLink = getURL();
        phone = getPhoneNum();

        foodCosts = getEventFoodCosts();
        ticketCosts = getEventTicketCosts();

        image = getImage();

        Event nEw = new Event(title, location, date, description, categories, foodCosts, ticketCosts, image, submittedBy, pcName, pcEmail, webLink, phone);
        EventList.getEventList().add(nEw);
        Collections.sort(EventList.getEventList(), new DateSort());
        CatSort.eventSort(nEw);

    }
    public String getTime(){
        TextView time = (TextView)findViewById(R.id.Time);
        if(time.length() == 4)
            return "0" + time.getText().toString().trim();
        return time.getText().toString().trim();
    }
    public String getURL(){
        TextView url = (TextView)findViewById(R.id.eventURL);

        return url.getText().toString().replaceAll("\\s+","");
    }

    public String getSubmittedBy(){
        return UserList.getCurrentUser().getEmail();
    }

    //Returns Admission costs
    public double getEventTicketCosts(){
        EditText ticketCosts = (EditText)findViewById(R.id.ticketCosts);
        try {
            return Double.parseDouble(ticketCosts.getText().toString());
        }
        catch(Exception e){}

            return -1.0;
    }

    //Returns Food Costs
    public double getEventFoodCosts(){
        EditText foodCost = (EditText)findViewById(R.id.foodCost);
        try {
            double x = Double.parseDouble(foodCost.getText().toString());
            if(x>=0 && x<=200)
                return x;
        }
        catch(Exception e){}

        return -1.0;
    }

    //Returns point of contact email
    public String getPCEmail() {
        EditText email = (EditText)findViewById(R.id.pcmail);
        if(email == null)
            return "";
        return email.getText().toString().trim();
    }

    //Returns point of contact name
    public String getEventPCName() {
        EditText name = (EditText)findViewById(R.id.pcName);
        return name.getText().toString().trim();
    }

    public String getEventDateString(){
        return ((EditText)findViewById(R.id.Date)).getText().toString().trim();
    }
    //Returns Date and time variable
    public long getEventDateLong() {
        Long uniTime = 0L;
        DateFormat dfm = new SimpleDateFormat("yyyyMMddHHmm");
        String date = getEventDateString();
        String time = getTime();
        String temp = "20" + date.substring(6, date.length()) + date.substring(0, 2) + date.substring(3, 5) + time.substring(0, 2) + time.substring(3 , time.length());

        try{
            uniTime = dfm.parse(temp).getTime();
        }catch (Exception e){}


        return uniTime;
    }

    //Returns Event description
    public String getEventDescription() {
        EditText desc = (EditText)findViewById(R.id.Description);
        return desc.getText().toString().trim();
    }

    //Returns Event Address
    public String getEventAddress() {
        EditText location = (EditText)findViewById(R.id.Address);
        return location.getText().toString().trim();
    }

    //Returns Event City
    public String getEventCity() {
        EditText location = (EditText) findViewById(R.id.City);
        return location.getText().toString().trim();
    }

        //Returns Event State
    public String getEventState() {
        EditText location = (EditText) findViewById(R.id.State);
        return location.getText().toString().trim().toUpperCase();
    }

    //Returns Event Zip Code
    public int getEventZipCode() {
            EditText zip = (EditText)findViewById(R.id.ZipCode);

            try {
                return Integer.parseInt(zip.getText().toString().trim());
            }
            catch(Exception e){}

            return 0;
        }

    //Returns event title
    public String getEventTitle(){
        EditText title = (EditText)findViewById(R.id.EventTitle);
        return title.getText().toString();
    }

    public String getPhoneNum(){
        EditText phone = (EditText)findViewById(R.id.PhoneNumber);
        return phone.getText().toString().trim();
    }

    public int getImage (){return R.drawable.ic_launcher;}

    //Returns an array of booleans that help characterize the event.
    public Quality onOff() {

        CheckBox autoBoatAir = (CheckBox) findViewById(R.id.AutoBoatAir);
        CheckBox businessProfessional = (CheckBox) findViewById(R.id.BusinessProfessional);
        CheckBox charityCauses = (CheckBox) findViewById(R.id.CharityCauses);
        CheckBox familyEducation = (CheckBox) findViewById(R.id.FamilyEducation);
        CheckBox fashionBeauty = (CheckBox) findViewById(R.id.FashionBeauty);
        CheckBox filmMediaEntertainment = (CheckBox) findViewById(R.id.FilmMediaEntertainment);
        CheckBox food = (CheckBox) findViewById(R.id.food);
        CheckBox foodDrink = (CheckBox) findViewById(R.id.FoodDrink);
        CheckBox governmentPolitics = (CheckBox) findViewById(R.id.GovernmentPolitics);
        CheckBox healthWellness = (CheckBox) findViewById(R.id.HealthWellness);
        CheckBox hobbiesSpecialInterest = (CheckBox) findViewById(R.id.HobbiesSpecialInterest);
        CheckBox homeLifestyle = (CheckBox) findViewById(R.id.HomeLifestyle);
        CheckBox music = (CheckBox) findViewById(R.id.Music);
        CheckBox other = (CheckBox) findViewById(R.id.Other);
        CheckBox performingVisualArts = (CheckBox) findViewById(R.id.PerformingVisualArts);
        CheckBox religionSpirituality = (CheckBox) findViewById(R.id.ReligionSpirituality);
        CheckBox scienceTechnology = (CheckBox) findViewById(R.id.ScienceTechnology);
        CheckBox seasonalHoliday = (CheckBox) findViewById(R.id.SeasonalHoliday);
        CheckBox sportsFitness = (CheckBox) findViewById(R.id.SportsFitness);
        CheckBox travelOutdoor = (CheckBox) findViewById(R.id.TravelOutdoor);

        Quality temp = new Quality();

        temp.setVehicle(autoBoatAir.isChecked());
        temp.setBusiness(businessProfessional.isChecked());
        temp.setCause(charityCauses.isChecked());
        temp.setEducation(familyEducation.isChecked());
        temp.setFashion(fashionBeauty.isChecked());
        temp.setEntertainment(filmMediaEntertainment.isChecked());
        temp.setFood(foodDrink.isChecked());
        temp.setPolitics(governmentPolitics.isChecked());
        temp.setHealth(healthWellness.isChecked());
        temp.setHobbies(hobbiesSpecialInterest.isChecked());
        temp.setLifestyle(homeLifestyle.isChecked());
        temp.setHasFood(foodDrink.isChecked());
        temp.setFood(food.isChecked());
        temp.setMusic(music.isChecked());
        temp.setOther(other.isChecked());
        temp.setVisual_arts(performingVisualArts.isChecked());
        temp.setReligious(religionSpirituality.isChecked());
        temp.setTechnology(scienceTechnology.isChecked());
        temp.setHoliday(seasonalHoliday.isChecked());
        temp.setSports(sportsFitness.isChecked());
        temp.setOutdoor(travelOutdoor.isChecked());

        return temp;
    }
}