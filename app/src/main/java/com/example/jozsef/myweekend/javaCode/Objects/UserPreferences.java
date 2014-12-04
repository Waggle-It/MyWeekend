package com.example.jozsef.myweekend.javaCode.Objects;

/**
 * Created by Jozsef on 12/3/2014.
 */
public class UserPreferences {
    private int vehicle = 0;
    private int cause = 0;
    private int fashion = 0;
    private int food = 0;
    private int hasFood = 0;
    private int health = 0;
    private int music = 0;
    private int lifestyle = 0;
    private int technology = 0;
    private int holiday = 0;
    private int outdoor = 0;
    private int business = 0;
    private int education = 0;
    private int entertainment = 0;
    private int politics = 0;
    private int hobbies = 0;
    private int visual_arts = 0;
    private int religious = 0;
    private int sports = 0;
    private int other = 0;
    private long total = 0;

    public void incrementPreferences(Event event){
        if(event.getcharacteristics().isBusiness())
            incrementBusiness();
        if(event.getcharacteristics().isCause())
            incrementCause();
        if(event.getcharacteristics().isEducation())
            incrementEducation();
        if(event.getcharacteristics().isEntertainment())
            incrementEntertainment();
        if(event.getcharacteristics().isFashion())
            incrementFashion();
        if(event.getcharacteristics().isFood())
            incrementFood();
        if(event.getcharacteristics().isHealth())
            incrementHealth();
        if(event.getcharacteristics().isHobbies())
            incrementHobbies();
        if(event.getcharacteristics().isHoliday())
            incrementHoliday();
        if(event.getcharacteristics().isLifestyle())
            incrementLifestyle();
        if(event.getcharacteristics().isMusic())
            incrementMusic();
        if(event.getcharacteristics().isOther())
            incrementOther();
        if(event.getcharacteristics().isOutdoor())
            incrementOutdoor();
        if(event.getcharacteristics().isPolitics())
            incrementPolitics();
        if(event.getcharacteristics().isReligious())
            incrementReligious();
        if(event.getcharacteristics().isSports())
            incrementSports();
        if(event.getcharacteristics().isTechnology())
            incrementTechnology();
        if(event.getcharacteristics().isVehicle())
            incrementVehicle();
        if(event.getcharacteristics().isVisual_arts())
            incrementVisual_arts();
        if(event.getcharacteristics().isHasFood())
            incrementHasFood();
    }
    public Quality preferenceQuality(UserPreferences a, UserPreferences l){
        this.vehicle = a.vehicle*a.vehicle + l.vehicle;
        this.cause = a.cause*a.cause + l.cause;
        this.fashion = a.fashion*a.fashion + l.fashion;
        this.food = a.food*a.food + l.food;
        this.hasFood = a.hasFood*a.hasFood + l.hasFood;
        this.health = a.health*a.health + l.health;
        this.music = a.music*a.music + l.music;
        this.lifestyle = a.lifestyle*a.lifestyle + l.lifestyle;
        this.technology = a.technology*a.technology + l.technology;
        this.holiday = a.holiday*a.holiday + l.holiday;
        this.outdoor = a.outdoor*a.outdoor + l.outdoor;
        this.business = a.business*a.business + l.business;
        this.education = a.education*a.education + l.education;
        this.entertainment = a.entertainment*a.entertainment + l.entertainment;
        this.politics = a.politics*a.politics + l.politics;
        this.hobbies = a.hobbies*a.hobbies + l.hobbies;
        this.visual_arts = a.visual_arts*a.visual_arts + l.visual_arts;
        this.religious = a.religious*a.religious + l.religious;
        this.sports = a.sports*a.sports + l.sports;
        this.other = a.other*a.other + l.other;
        this.total = a.total*a.total + l.total;

        return  this.preferenceQuality();
    }

    public Quality preferenceQuality(){
        Quality temp = new Quality();
        if(vehicle>total/5)
            temp.setVehicle(true);
        if(food>total/5)
            temp.setFood(true);
        if(hasFood>total/5)
            temp.setHasFood(true);
        if(politics>total/5)
            temp.setPolitics(true);
        if(entertainment>total/5)
            temp.setEntertainment(true);
        if(education>total/5)
            temp.setEducation(true);
        if(business>total/5)
            temp.setBusiness(true);
        if(outdoor>total/5)
            temp.setOutdoor(true);
        if(holiday>total/5)
            temp.setHoliday(true);
        if(technology>total/5)
            temp.setTechnology(true);
        if(lifestyle>total/5)
            temp.setLifestyle(true);
        if(health>total/5)
            temp.setHealth(true);
        if(music>total/5)
            temp.setMusic(true);
        if(fashion>total/5)
            temp.setFashion(true);
        if(cause>total/5)
            temp.setCause(true);
        if(hobbies>total/5)
            temp.setHobbies(true);
        if(visual_arts>total/5)
            temp.setVisual_arts(true);
        if(religious>total/5)
            temp.setReligious(true);
        if(sports>total/5)
            temp.setSports(true);
        if(other>total/5)
            temp.setOther(true);
        incrementTotal();
        return temp;
    }

    public int getVehicle() {
        return vehicle;
    }

    public void setVehicle(int vehicle) {
        this.vehicle = vehicle;
    }
    public void incrementVehicle() {
        this.total++;
    }

    public int getCause() {
        return cause;
    }

    public void setCause(int cause) {
        this.cause = cause;
    }
    public void incrementCause() {
        this.cause++;
    }

    public int getFashion() {
        return fashion;
    }

    public void setFashion(int fashion) {
        this.fashion = fashion;
    }
    public void incrementFashion() {
        this.total++;
        this.fashion++;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
    public void incrementFood() {
        this.food++;
    }

    public int getHasFood() {
        return hasFood;
    }

    public void setHasFood(int hasFood) {
        this.hasFood = hasFood;
    }
    public void incrementHasFood() {
        this.hasFood++;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public void incrementHealth() {
        this.health++;
    }

    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = music;
    }
    public void incrementMusic() {
        this.music++;
    }

    public int getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(int lifestyle) {
        this.lifestyle = lifestyle;
    }
    public void incrementLifestyle() {
        this.lifestyle++;
    }

    public int getTechnology() {
        return technology;
    }

    public void setTechnology(int technology) {
        this.technology = technology;
    }
    public void incrementTechnology() {
        this.technology++;
    }

    public int getHoliday() {
        return holiday;
    }

    public void setHoliday(int holiday) {
        this.holiday = holiday;
    }
    public void incrementHoliday() {
        this.total++;
        this.holiday++;
    }

    public int getOutdoor() {
        return outdoor;
    }

    public void setOutdoor(int outdoor) {
        this.outdoor = outdoor;
    }
    public void incrementOutdoor() {
        this.outdoor++;
    }

    public int getBusiness() {
        return business;
    }

    public void setBusiness(int business) {
        this.business = business;
    }
    public void incrementBusiness() {
        this.business++;
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }
    public void incrementEducation() {
        this.education++;
    }

    public int getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(int entertainment) {
        this.entertainment = entertainment;
    }
    public void incrementEntertainment() {
        this.total++;
        this.entertainment++;
    }

    public int getPolitics() {
        return politics;
    }

    public void setPolitics(int politics) {
        this.politics = politics;
    }
    public void incrementPolitics() {
        this.politics++;
    }

    public int getHobbies() {
        return hobbies;
    }

    public void setHobbies(int hobbies) {
        this.hobbies = hobbies;
    }
    public void incrementHobbies() {
        this.hobbies++;
    }

    public int getVisual_arts() {
        return visual_arts;
    }

    public void setVisual_arts(int visual_arts) {
        this.visual_arts = visual_arts;
    }
    public void incrementVisual_arts() {
        this.visual_arts++;
    }

    public int getReligious() {
        return religious;
    }

    public void setReligious(int religious) {
        this.religious = religious;
    }public void incrementReligious() {
        this.religious++;
    }

    public int getSports() {
        return sports;
    }

    public void setSports(int sports) {
        this.sports = sports;
    }
    public void incrementSports() {
        this.sports++;
    }

    public int getOther() {
        return other;
    }

    public void setOther(int other) {
        this.other = other;
    }
    public void incrementOther() {
        this.other++;
    }

    public void incrementTotal() {
        this.total++;
    }
}
