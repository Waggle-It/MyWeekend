package com.example.jozsef.myweekend.javaCode.Objects;

import java.util.ArrayList;
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

    public static List<Event> getVehicleList() {
        return vehicleList;
    }

    public static void setVehicleList(List<Event> vehicleList) {
        QualityList.vehicleList = vehicleList;
    }

    public static List<Event> getCauseList() {
        return causeList;
    }

    public static void setCauseList(List<Event> causeList) {
        QualityList.causeList = causeList;
    }

    public static List<Event> getFashionList() {
        return fashionList;
    }

    public static void setFashionList(List<Event> fashionList) {
        QualityList.fashionList = fashionList;
    }

    public static List<Event> getFoodList() {
        return foodList;
    }

    public static void setFoodList(List<Event> foodList) {
        QualityList.foodList = foodList;
    }

    public static List<Event> getHealthList() {
        return healthList;
    }

    public static void setHealthList(List<Event> healthList) {
        QualityList.healthList = healthList;
    }

    public static List<Event> getMusicList() {
        return musicList;
    }

    public static void setMusicList(List<Event> musicList) {
        QualityList.musicList = musicList;
    }

    public static List<Event> getLifestyleList() {
        return lifestyleList;
    }

    public static void setLifestyleList(List<Event> lifestyleList) {
        QualityList.lifestyleList = lifestyleList;
    }

    public static List<Event> getTechList() {
        return techList;
    }

    public static void setTechList(List<Event> techList) {
        QualityList.techList = techList;
    }

    public static List<Event> getHollidayList() {
        return hollidayList;
    }

    public static void setHollidayList(List<Event> hollidayList) {
        QualityList.hollidayList = hollidayList;
    }

    public static List<Event> getOutdoorList() {
        return outdoorList;
    }

    public static void setOutdoorList(List<Event> outdoorList) {
        QualityList.outdoorList = outdoorList;
    }

    public static List<Event> getBuisnessList() {
        return buisnessList;
    }

    public static void setBuisnessList(List<Event> buisnessList) {
        QualityList.buisnessList = buisnessList;
    }

    public static List<Event> getEducationList() {
        return educationList;
    }

    public static void setEducationList(List<Event> educationList) {
        QualityList.educationList = educationList;
    }

    public static List<Event> getEntertainmentList() {
        return entertainmentList;
    }

    public static void setEntertainmentList(List<Event> entertainmentList) {
        QualityList.entertainmentList = entertainmentList;
    }

    public static List<Event> getPoliticsList() {
        return politicsList;
    }

    public static void setPoliticsList(List<Event> politicsList) {
        QualityList.politicsList = politicsList;
    }

    public static List<Event> getHobbiesList() {
        return hobbiesList;
    }

    public static void setHobbiesList(List<Event> hobbiesList) {
        QualityList.hobbiesList = hobbiesList;
    }

    public static List<Event> getArtsList() {
        return artsList;
    }

    public static void setArtsList(List<Event> artsList) {
        QualityList.artsList = artsList;
    }

    public static List<Event> getReligiousList() {
        return religiousList;
    }

    public static void setReligiousList(List<Event> religiousList) {
        QualityList.religiousList = religiousList;
    }

    public static List<Event> getSportsList() {
        return sportsList;
    }

    public static void setSportsList(List<Event> sportsList) {
        QualityList.sportsList = sportsList;
    }

    public static List<Event> getOtherList() {
        return otherList;
    }

    public static void setOtherList(List<Event> otherList) {
        QualityList.otherList = otherList;
    }

    private static List<Event> otherList= new ArrayList<Event>();
    public QualityList(List<Event> qualityList)
    {
        qualityList = qualityList;
    }
    public QualityList() {}
    public static List<Event> getQualityList(){
        return qualityList;
    }

}
