package com.example.jozsef.myweekend.javaCode.Objects;

import com.example.jozsef.myweekend.R;

/**
 * Created by Elliott on 11/3/2014.
 * A series of booleans that describe the event in question.
 */
public class Quality {
    public boolean isVehicle() {
        return vehicle;
    }

    public void setVehicle(boolean vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isCause() {
        return cause;
    }

    public void setCause(boolean cause) {
        this.cause = cause;
    }

    public boolean isFashion() {
        return fashion;
    }

    public void setHasFood(boolean food){hasFood = food;}

    public boolean isHasFood(){return hasFood;}

    public void setFashion(boolean fashion) {
        this.fashion = fashion;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isHealth() {
        return health;
    }

    public void setHealth(boolean health) {
        this.health = health;
    }

    public boolean isMusic() {
        return music;
    }

    public void setMusic(boolean music) {
        this.music = music;
    }

    public boolean isLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(boolean lifestyle) {
        this.lifestyle = lifestyle;
    }

    public boolean isTechnology() {
        return technology;
    }

    public void setTechnology(boolean technology) {
        this.technology = technology;
    }

    public boolean isHoliday() {
        return holiday;
    }

    public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }

    public boolean isOutdoor() {
        return outdoor;
    }

    public void setOutdoor(boolean outdoor) {
        this.outdoor = outdoor;
    }

    public boolean isBusiness() {
        return business;
    }

    public void setBusiness(boolean business) {
        this.business = business;
    }

    public boolean isEducation() {
        return education;
    }

    public void setEducation(boolean education) {
        this.education = education;
    }

    public boolean isEntertainment() {
        return entertainment;
    }

    public void setEntertainment(boolean entertainment) {
        this.entertainment = entertainment;
    }

    public boolean isPolitics() {
        return politics;
    }

    public void setPolitics(boolean politics) {
        this.politics = politics;
    }

    public boolean isHobbies() {
        return hobbies;
    }

    public void setHobbies(boolean hobbies) {
        this.hobbies = hobbies;
    }

    public boolean isVisual_arts() {
        return visual_arts;
    }

    public void setVisual_arts(boolean visual_arts) {
        this.visual_arts = visual_arts;
    }

    public boolean isReligious() {
        return religious;
    }

    public void setReligious(boolean religious) {
        this.religious = religious;
    }

    public boolean isSports() {
        return sports;
    }

    public void setSports(boolean sports) {
        this.sports = sports;
    }

    public boolean isOther() {
        return other;
    }

    public void setOther(boolean other) {
        this.other = other;
    }

    private boolean vehicle;
    private boolean cause;
    private boolean fashion;
    private boolean food;
    private boolean hasFood;
    private boolean health;
    private boolean music;
    private boolean lifestyle;
    private boolean technology;
    private boolean holiday;
    private boolean outdoor;
    private boolean business;
    private boolean education;
    private boolean entertainment;
    private boolean politics;
    private boolean hobbies;
    private boolean visual_arts;
    private boolean religious;
    private boolean sports;
    private boolean other;
    public Quality(){
        vehicle =false;
        cause = vehicle = fashion = food = health = music = lifestyle = technology = holiday = outdoor = business = education
                = entertainment = politics = hobbies = visual_arts = religious = sports = other =false;
    }
    public int getImage(){
        if(isHasFood())
            return R.drawable.has_food_big;
        if(isMusic())
            return R.drawable.music;
        if(isVehicle())
            return R.drawable.car_plane;
        if(isBusiness())
            return R.drawable.buisness;
        if(isVisual_arts())
            return R.drawable.visual_arts;
        if(isCause())
            return R.drawable.charity;
        if(isEducation())
            return R.drawable.education;
        if(isEntertainment())
            return R.drawable.film_media;
        if(isFood())
            return R.drawable.culinary;
        if(isHealth())
            return R.drawable.health;
        if(isHobbies())
            return R.drawable.interest;
        if(isHoliday())
            return R.drawable.holiday;
        if(isOther())
            return R.drawable.other;
        if(isOutdoor())
            return R.drawable.travel;
        if(isSports())
            return R.drawable.sports;
        if(isPolitics())
            return R.drawable.politics;
        if(isReligious())
            return R.drawable.religion;
        if(isLifestyle())
            return R.drawable.home;
        return R.drawable.ic_launcher;
    }

}
