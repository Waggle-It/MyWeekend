package com.example.jozsef.myweekend.javaCode.Objects;

import com.example.jozsef.myweekend.androidCode.Event_List;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jozsef on 10/31/2014.
 * The user object that contains all the parameters that are associated with the user.
 * a edit user info display and method needs to be created.
 */
public class User {
    private String email;
    private String password;
    private int zipCode;
    private UserPreferences preferancesAttended = new UserPreferences();
    private UserPreferences preferancesLike = new UserPreferences();
    private List<Event> myWeekend = new ArrayList<Event>();


    public User(String email, String password, int zipCode){
        this.email = email;
        this.password = password;
        this.zipCode = zipCode;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public List<Event> getMyWeekend() {
        return myWeekend;
    }

    public void addMyWeekend(Event myWeekend) {
        this.myWeekend.add(myWeekend);
    }

    public UserPreferences getPreferancesLike() {
        return preferancesLike;
    }

    public UserPreferences getPreferancesAttended() {
        return preferancesAttended;
    }
}
