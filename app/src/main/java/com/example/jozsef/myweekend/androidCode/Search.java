package com.example.jozsef.myweekend.androidCode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jozsef.myweekend.R;
import com.example.jozsef.myweekend.javaCode.Objects.EventList;
import com.example.jozsef.myweekend.javaCode.Objects.Quality;
import com.example.jozsef.myweekend.javaCode.SearchTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

        final EditText keywords = (EditText)findViewById(R.id.title);
        final EditText startDate = (EditText)findViewById(R.id.StartDate);
        final EditText endDate = (EditText)findViewById(R.id.EndDate);
        final EditText budget = (EditText)findViewById(R.id.Budget);
        final EditText partySize = (EditText)findViewById(R.id.SizePart);
        final CheckBox hungry = (CheckBox)findViewById(R.id.food);
        final Quality prefer = getQuality();
        final String[] keyWordArray = wordParse(keywords.toString());

        setContentView(view);

        Button create= (Button)findViewById(R.id.button);


        create.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                {
                    SearchTest poop = new SearchTest();
                    eventAdapter.current = poop.search(keyWordArray, dateLong(startDate), dateLong(endDate), prefer, hungry.isChecked(), getCosts(budget), Integer.parseInt(partySize.toString()));
                    startActivity(new Intent(Search.this, Event_List.class));
                }
            }
        });

    }
    public Quality getQuality(){
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
    public String[] wordParse(String keywords){
        String [] temp = new String[keywords.length()];
        int i =0;
        while(keywords.contains(" ")){
            temp[i]=keywords.substring(0, keywords.indexOf(" "));
            keywords = keywords.substring(keywords.indexOf(" ")+1, keywords.length());
        }
        for(int j=0;j<keywords.length();j++)
            if(temp[i]==null){
                String[] MoreTemp = new String[j];
                System.arraycopy(temp, 0, MoreTemp, 0, j);
                temp = MoreTemp;
                j = Integer.MAX_VALUE;
            }
        return temp;

    }
    public long dateLong(EditText dateTest){
        Long uniTime = 0L;
        DateFormat dfm = new SimpleDateFormat("yyyyMMdd");
        String date = dateTest.toString();

        String temp = "20" + date.substring(6, date.length()) + date.substring(0, 2) + date.substring(3, 5);

        try{
            uniTime = dfm.parse(temp).getTime();
        }catch (Exception e){}


        return uniTime;
    }
    public double getCosts(EditText costs){
        try {
            double x = Double.parseDouble(costs.getText().toString());
            if(x>=0 && x<=200)
                return x;
        }
        catch(Exception e){}

        return -1.0;
    }
}
