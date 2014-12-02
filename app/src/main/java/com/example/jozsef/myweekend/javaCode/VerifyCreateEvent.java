package com.example.jozsef.myweekend.javaCode;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.jozsef.myweekend.androidCode.Create_Event;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jozsef on 11/24/2014.
 * This class is sent various  required values from Create_Event verifying valid input.
 */
public class VerifyCreateEvent{
    private static Context display;

    // This group of verifications are self explanitory.
    public boolean verifyTicketCosts(double cost){
        return cost >= 0.0;
    }
    public boolean verifyFoodCosts(double cost, boolean isFood){
        return !isFood || cost >= 0.0;
    }
    public boolean verifyEventTitle(String test){
        return !test.equals("");
    }
    public boolean verifyZip(int Zip){return Integer.toString(Zip).length() == 5;}
    public boolean verifyEventDisc(String test){
        return !test.equals("");
    }
    public boolean verifyEventAddress(String test){
        return !test.equals("");
    }
    public boolean verifyEventCity(String test){
        return !test.equals("");
    }

    //Now only verifies correct abbreviation, if typed states are to be allowed then a function
    //needs to be written to convert state name to abbreviation so that google maps will recognize it.
    //although havent checked to make sure google link doesn't recognize spelled out format.
    public boolean verifyEventState(String test){
        if(test.equals("") || test.equals(" "))
            return false;

        String statesAb = "VA OR ID NV CA AZ UT MT WY CO NM TX OK KS NE SD ND MN IA MO AR LA MS AL GA FL SC NC TN VA KY WV OH IN MI PA NY ME NH VT MA RI CT NJ DE MD DC AK HI IL";
        String states = "alabama alaska arizona arkansas california colorado connecticut delaware florida georgia hawaii idaho illinois indiana iowa kansas kentucky louisiana maine maryland massachusetts michigan minnesota mississippi missouri montana nebraska nevada new hampshire new jersey new mexico new york north carolina north dakota ohio oklahoma oregon pennsylvania rhode island south carolina south dakota tennessee texas utah vermont virginia washington west virginia wisconsin wyoming";
        return statesAb.contains(test.toUpperCase());
    }
    //ensures format(mm/dd/yy) like us crazy americans prefer.
    public boolean verifyEventDate(String date){
        String month, day, year, slashes;
        boolean isDate = true;

        if(date.length()==8){
            month = date.substring(0,2);
            day = date.substring(3,5);
            year = date.substring(6,8);
            slashes = date.substring(2,3) + date.substring(5,6);
            if(Integer.parseInt(month)>12 || Integer.parseInt(month)<1)
                isDate = false;
            if(Integer.parseInt(day)<1 || Integer.parseInt(day)>31)
                isDate=false;
            if(Integer.parseInt(year)>99 || Integer.parseInt(year)<0)
                isDate=false;
            if(!slashes.equals("//"))
                isDate = false;
            return isDate;
        }
        else
            return false;
    }
    //insures format(HH:MM
    public boolean verifyEventTime(String time){
        if(time.length() != 5)
            return false;
        if(time.indexOf(":") != 2)
            return false;
        String hours = time.substring(0, time.indexOf(":"));
        if(Integer.parseInt(hours)>24 || Integer.parseInt(hours) < 1)
            return false;
        String minutes = time.substring(time.indexOf(":") + 1, time.length());
        return !(Integer.parseInt(minutes) < 0 || Integer.parseInt(minutes) > 59);
    }
    //Don't know how this works pattern matcher was copied off the net but verifies email address format.
    //Code borrowed from http://examples.javacodegeeks.com/
    public boolean verifyPCEmail(String test){
        if(test.equals(""))
            return true;
        else{
            Pattern pattern;
            Matcher matcher;

            String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

            pattern = Pattern.compile(EMAIL_PATTERN);

            matcher = pattern.matcher(test);

            return matcher.matches();
        }
    }
}
