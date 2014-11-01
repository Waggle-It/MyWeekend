package com.example.jozsef.myweekend;
/**
 *This class creates an object of type event with the various parameters that an event could possibly
 * take on.
 */
public class Event {
    private String title, location, date, description ;
    private boolean[] characteristics;
    int image;
    private double foodCosts, ticketCosts;
    public Event(String title, String location, String date, String description, boolean[] characteristics, double foodCosts, double ticketCosts, int image){
        this.title = title;
        this.location = location;
        this.date = date;
        this.description = description;
        this.characteristics = characteristics;
        this.foodCosts = foodCosts;
        this.ticketCosts = ticketCosts;
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
    public boolean getcharacteristics(int i){
        return characteristics[i];
    }
    public double getFoodCosts(){
        return foodCosts;
    }
    public double getTicketCosts(){
        return ticketCosts;
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
    public void setHasFood(boolean onOff, int i){
        this.characteristics[i] = onOff;
    }
    public void setTicketCosts(double price){
        this.ticketCosts = price;
    }
    public void setFoodCosts(double price){
        this.foodCosts = price;
    }
}
