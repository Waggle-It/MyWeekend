package com.example.jozsef.myweekend.javaCode.Objects;

import android.content.Context;
import android.widget.Toast;

import com.example.jozsef.myweekend.androidCode.SortMenu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Elliott on 12/2/2014.
 */
public class QualityList {
    private static List<Event> vehicleList= new ArrayList<Event>();
    private static List<Event> causeList= new ArrayList<Event>();
    private static List<Event> fashionList= new ArrayList<Event>();
    private static List<Event> foodList= new ArrayList<Event>();
    private static List<Event> healthList= new ArrayList<Event>();
    private static List<Event> musicList= new ArrayList<Event>();
    private static List<Event> lifestyleList= new ArrayList<Event>();
    private static List<Event> techList= new ArrayList<Event>();
    private static List<Event> hollidayList= new ArrayList<Event>();
    private static List<Event> outdoorList= new ArrayList<Event>();
    private static List<Event> buisnessList= new ArrayList<Event>();
    private static List<Event> educationList= new ArrayList<Event>();
    private static List<Event> entertainmentList= new ArrayList<Event>();
    private static List<Event> politicsList= new ArrayList<Event>();
    private static List<Event> hobbiesList= new ArrayList<Event>();
    private static List<Event> artsList= new ArrayList<Event>();
    private static List<Event> religiousList= new ArrayList<Event>();
    private static List<Event> sportsList= new ArrayList<Event>();
    private static List<Event> hasFood= new ArrayList<Event>();
    private static List<Event> adminCost = new ArrayList<Event>();


    public static List<Event> getVehicleList() {
        return vehicleList;
    }

    public static List<Event> getCauseList() {
        return causeList;
    }

    public static List<Event> getFashionList() {
        return fashionList;
    }

    public static List<Event> getFoodList() {
        return foodList;
    }

    public static List<Event> getHealthList() {
        return healthList;
    }

    public static List<Event> getMusicList() {
        return musicList;
    }

    public static List<Event> getLifestyleList() {
        return lifestyleList;
    }

    public static List<Event> getTechList() {
        return techList;
    }

    public static List<Event> getHollidayList() {
        return hollidayList;
    }

    public static List<Event> getOutdoorList() {
        return outdoorList;
    }

    public static List<Event> getBuisnessList() {
        return buisnessList;
    }

    public static List<Event> getEducationList() {
        return educationList;
    }

    public static List<Event> getEntertainmentList() {
        return entertainmentList;
    }

    public static List<Event> getPoliticsList() {
        return politicsList;
    }

    public static List<Event> getHobbiesList() {
        return hobbiesList;
    }

    public static List<Event> getArtsList() {
        return artsList;
    }

    public static List<Event> getReligiousList() {
        return religiousList;
    }

    public static List<Event> getSportsList() {
        return sportsList;
    }

    public static List<Event> getOtherList() {
        return otherList;
    }

    public static List<Event> getHasFood() {return hasFood;}

    public static List<Event> getAdminCost() {return adminCost;}

    public static void setAdminCost(List<Event> adminCost) {QualityList.adminCost = adminCost;}

    public static void setHasFood(List<Event> hasFood) {QualityList.hasFood = hasFood;}

    public static void setCauseList(List<Event> causeList) {QualityList.causeList = causeList;}

    public static void setVehicleList(List<Event> vehicleList) {QualityList.vehicleList = vehicleList;}

    public static void setFashionList(List<Event> fashionList) {QualityList.fashionList = fashionList;}

    public static void setHealthList(List<Event> healthList) {QualityList.healthList = healthList;}

    public static void setMusicList(List<Event> musicList) {QualityList.musicList = musicList;}

    public static void setFoodList(List<Event> foodList) {QualityList.foodList = foodList;}

    public static void setLifestyleList(List<Event> lifestyleList) {QualityList.lifestyleList = lifestyleList;}

    public static void setTechList(List<Event> techList) {QualityList.techList = techList;}

    public static void setHollidayList(List<Event> hollidayList) {QualityList.hollidayList = hollidayList;}

    public static void setOutdoorList(List<Event> outdoorList) {QualityList.outdoorList = outdoorList;}

    public static void setBuisnessList(List<Event> buisnessList) {QualityList.buisnessList = buisnessList;}

    public static void setPoliticsList(List<Event> politicsList) {QualityList.politicsList = politicsList;}

    public static void setEducationList(List<Event> educationList) {QualityList.educationList = educationList;}

    public static void setEntertainmentList(List<Event> entertainmentList) {QualityList.entertainmentList = entertainmentList;}

    public static void setHobbiesList(List<Event> hobbiesList) {QualityList.hobbiesList = hobbiesList;}

    public static void setArtsList(List<Event> artsList) {QualityList.artsList = artsList;}

    public static void setReligiousList(List<Event> religiousList) {QualityList.religiousList = religiousList;}

    public static void setSportsList(List<Event> sportsList) {QualityList.sportsList = sportsList;}

    public static void setOtherList(List<Event> otherList) {QualityList.otherList = otherList;}



    private static List<Event> otherList= new ArrayList<Event>();
    public QualityList(List<Event> qualityList)
    {
        qualityList = qualityList;
    }
    public QualityList() {}

    public static List<Event> getEventList(String cat){

        if(cat.equals("Search"))

        if(cat.equals("Step Out of Your Box"))

        if(cat.equals("Recommended"))

        if(cat.equals("Popular"));

        if(cat.equals("Today")){
            List<Event> temp = new ArrayList<Event>();
            for(int i = 0; i<EventList.getEventList().size(); i++) {
                long test = EventList.getEventList().get(i).getDate();
                DateFormat dfm = new SimpleDateFormat("yyyyMMdd");
                if (dfm.format(test).equals(dfm.format(Calendar.getInstance().getTime())))
                    temp.add(EventList.getEventList().get(i));
            }
            return temp;
        }

        //Need to add the ability to add to my weekend.
        if(cat.equals("Your Weekend"))
            return UserList.getCurrentUser().getMyWeekend();
        if(cat.equals("All Events"))
            return EventList.getEventList();
        if(cat.equals("Auto, Boat & Air"))
            return getVehicleList();
        if(cat.equals("Business & Professional"))
            return getBuisnessList();
        if(cat.equals("Charity & Causes"))
            return getCauseList();
        if(cat.equals("Family & Education"))
            return getEducationList();
        if(cat.equals("Fashion & Beauty"))
            return getFashionList();
        if(cat.equals("Film, Media & Entertainment"))
            return getEntertainmentList();
        if(cat.equals("Food Served?"))
            return getHasFood();
        if(cat.equals("Food Drink"))
            return getFoodList();
        if(cat.equals("Government & Politics"))
            return getPoliticsList();
        if(cat.equals("Health & Wellness"))
            return getHealthList();
        if(cat.equals("Hobbies & Special Interest"))
            return getHobbiesList();
        if(cat.equals("Home & Lifestyle"))
            return getLifestyleList();
        if(cat.equals("Music"))
            return getMusicList();
        if(cat.equals("Other"))
            return getOtherList();
        if(cat.equals("Performing & Visual Arts"))
            return getArtsList();
        if(cat.equals("Religion & Spirituality"))
            return getReligiousList();
        if(cat.equals("Science & Technology"))
            return getTechList();
        if(cat.equals("Seasonal & Holiday"))
            return getHollidayList();
        if(cat.equals("Sports and Fitness"))
            return getSportsList();
        if(cat.equals("Admission Costs?"));

        if(cat.equals("Travel & Outdoor"))
            return getOutdoorList();

        return EventList.getEventList();
    }
}
