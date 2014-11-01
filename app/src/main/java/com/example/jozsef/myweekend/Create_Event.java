package com.example.jozsef.myweekend;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.net.URL;

/**
 * Created by Jozsef on 10/24/2014.
 *
 * This takes input from the create event xml from the user and adds a new event to our system.
 */
public class Create_Event extends Activity {
    public static EventList ccg;
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

                create();
            }


        });
    }
    //Method is activated when the user hits the submit button all fields necessary to create a new event are retrieved.
    private void create(){
        boolean[] categories = new boolean[21];
        String title, location, description, date, pcName, pcEmail, webLink;
        double foodCosts, ticketCosts;
        int image;

        categories = onOff();

        title = getEventTitle();
        location = getEventLocation();
        description = getEventDescription();
        date = getEventDate();
        pcName = getEventPCName();
        pcEmail = getPCEmail();

        foodCosts = getEventFoodCosts();
        ticketCosts = getEventTicketCosts();

        image = getImage();

        Event nEw = new Event(title, location, date, description, categories, foodCosts, ticketCosts, image);

        ccg.addEvent(nEw);
    }

    //Returns Admission costs
    public double getEventTicketCosts(){
        EditText ticketCosts = (EditText)findViewById(R.id.ticketCosts);
        return Double.parseDouble(ticketCosts.getText().toString());
    }

    //Returns Food Costs
    public double getEventFoodCosts(){
        EditText foodCost = (EditText)findViewById(R.id.foodCost);
        return Double.parseDouble(foodCost.getText().toString());
    }

    //Returns point of contact email
    public String getPCEmail() {
        EditText email = (EditText)findViewById(R.id.pcmail);
        return email.getText().toString();
    }

    //Returns point of contact name
    public String getEventPCName() {
        EditText name = (EditText)findViewById(R.id.pcName);
        return name.getText().toString();
    }

    //Returns Date and time variable
    public String getEventDate() {
        EditText date = (EditText)findViewById(R.id.Date);
        EditText time = (EditText)findViewById(R.id.Time);
        return date.getText().toString() + " " +time.getText().toString();
    }

    //Returns Event description
    public String getEventDescription() {
        EditText desc = (EditText)findViewById(R.id.Description);
        return desc.getText().toString();
    }

    //Returns Event Location
    public String getEventLocation() {
        EditText location = (EditText)findViewById(R.id.Location);
        return location.getText().toString();
    }

    //Returns event title
    private String getEventTitle(){
        EditText title = (EditText)findViewById(R.id.EventTitle);
        return title.getText().toString();
    }

    private int getImage (){return R.drawable.ic_launcher;}

    //Returns an array of booleans that help characterize the event.
    private boolean[] onOff(){
        boolean[] categories = new boolean[21];

        CheckBox autoBoatAir = (CheckBox)findViewById(R.id.AutoBoatAir);
        CheckBox businessProfessional = (CheckBox)findViewById(R.id.BusinessProfessional);
        CheckBox charityCauses = (CheckBox)findViewById(R.id.CharityCauses);
        CheckBox familyEducation = (CheckBox)findViewById(R.id.FamilyEducation);
        CheckBox fashionBeauty = (CheckBox)findViewById(R.id.FashionBeauty);
        CheckBox filmMediaEntertainment = (CheckBox)findViewById(R.id.FilmMediaEntertainment);
        CheckBox food = (CheckBox)findViewById(R.id.food);
        CheckBox foodDrink = (CheckBox)findViewById(R.id.FoodDrink);
        CheckBox governmentPolitics = (CheckBox)findViewById(R.id.GovernmentPolitics);
        CheckBox healthWellness = (CheckBox)findViewById(R.id.HealthWellness);
        CheckBox hobbiesSpecialInterest = (CheckBox)findViewById(R.id.HobbiesSpecialInterest);
        CheckBox homeLifestyle = (CheckBox)findViewById(R.id.HomeLifestyle);
        CheckBox music = (CheckBox)findViewById(R.id.Music);
        CheckBox other = (CheckBox)findViewById(R.id.Other);
        CheckBox performingVisualArts = (CheckBox)findViewById(R.id.PerformingVisualArts);
        CheckBox religionSpirituality = (CheckBox)findViewById(R.id.ReligionSpirituality);
        CheckBox scienceTechnology = (CheckBox)findViewById(R.id.ScienceTechnology);
        CheckBox seasonalHoliday = (CheckBox)findViewById(R.id.SeasonalHoliday);
        CheckBox sportsFitness = (CheckBox)findViewById(R.id.SportsFitness);
        CheckBox ticket = (CheckBox)findViewById(R.id.ticket);
        CheckBox travelOutdoor = (CheckBox)findViewById(R.id.TravelOutdoor);

        categories[0] = autoBoatAir.isChecked();
        categories[1] = businessProfessional.isChecked();
        categories[2] = charityCauses.isChecked();
        categories[3] = familyEducation.isChecked();
        categories[4] = fashionBeauty.isChecked();
        categories[5] = filmMediaEntertainment.isChecked();
        categories[6] = food.isChecked();
        categories[7] = foodDrink.isChecked();
        categories[8] = governmentPolitics.isChecked();
        categories[9] = healthWellness.isChecked();
        categories[10] = hobbiesSpecialInterest.isChecked();
        categories[11] = homeLifestyle.isChecked();
        categories[12] = music.isChecked();
        categories[13] = other.isChecked();
        categories[14] = performingVisualArts.isChecked();
        categories[15] = religionSpirituality.isChecked();
        categories[16] = scienceTechnology.isChecked();
        categories[17] = seasonalHoliday.isChecked();
        categories[18] = sportsFitness.isChecked();
        categories[19] = ticket.isChecked();
        categories[20] = travelOutdoor.isChecked();

        return categories;
    }
}