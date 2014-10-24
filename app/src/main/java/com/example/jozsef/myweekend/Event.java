package com.example.jozsef.myweekend;
public class Event {
    private String title, location, date, description ;
    private boolean hasFood;
    int image;
    private double price;
    public Event(String title, String location, String date, String description, boolean hasFood, double price, int image){
        this.title = title;
        this.location = location;
        this.date = date;
        this.description = description;
        this.hasFood = hasFood;
        this.price = price;
        this.image = image;
    }
    public Event(){
    }
    public String getTitle(){
        return title;
    }
    public String getLocation(){
        return location;
    }
    public String getDate(){
        return date;
    }
    public String getDescription(){
        return description;
    }
    public boolean hasFood(){
        return hasFood;
    }
    public double getPrice(){
        return price;
    }
    public int getImage(){return this.image; }
    public void setTitle(String title){
        this.title = title;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setHasFood(boolean hasFood){
        this.hasFood = hasFood;
    }
    public void setPrice(double price){
        this.price = price;
    }

}
