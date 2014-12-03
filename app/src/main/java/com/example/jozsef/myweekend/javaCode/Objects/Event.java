package com.example.jozsef.myweekend.javaCode.Objects;
/**
 *This class creates an object of type event with the various parameters that an event could possibly
 * take on.
 */
public class Event {
    private String title, location, description, submittedBy, pcEmail, pcName, eventURL;
    private Long date;
    private Quality characteristics;
    public int image, idNumber;
    private double foodCosts, ticketCosts;
    public static int id;

    public Event(String title, String location, Long date, String description, Quality characteristics, double foodCosts, double ticketCosts, int image, String submittedBy, String pcName, String pcEmail, String eventURL){
        this.title = title;
        this.location = location;
        this.date = date;
        this.description = description;
        this.characteristics = characteristics;
        this.foodCosts = foodCosts;
        this.ticketCosts = ticketCosts;
        this.image = image;
        this.submittedBy = submittedBy;
        this.pcEmail = pcEmail;
        this.pcName = pcName;
        this.eventURL = eventURL;

        ++id;
        this.idNumber = id;
    }
    public Event(){
    }
    public String getTitle(){
        return title;
    }
    public String getLocation(){
        return location;
    }
    public long getDate(){
        return date;
    }
    public String getDescription(){
        return description;
    }
    public Quality getcharacteristics(){
        return characteristics;
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
    public void setDate(long date){
        this.date = date;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setTicketCosts(double price){
        this.ticketCosts = price;
    }
    public void setFoodCosts(double price){
        this.foodCosts = price;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getPcEmail() {
        return pcEmail;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public String getEventURL() {
        return eventURL;
    }

    public void setEventURL(String eventURL) {
        this.eventURL = eventURL;
    }
}
