package com.example.jozsef.myweekend.sortComparators;

import com.example.jozsef.myweekend.javaCode.Objects.Event;
import com.example.jozsef.myweekend.javaCode.Objects.EventList;
import com.example.jozsef.myweekend.javaCode.Objects.QualityList;

/**
 * Created by Jozsef on 11/24/2014.
 * IDK need to figure out how to implement a category sort that is efficient.
 */
public class CatSort {
    public QualityList eventSort(){
        for(int i = 0; i < EventList.getEventList().size(); i++) {
            if(EventList.getEventList().get(i).getcharacteristics().isBusiness())
              QualityList.getBuisnessList().add(EventList.getEventList().get(i));
            if(EventList.getEventList().get(i).getcharacteristics().isCause())
                QualityList.getCauseList().add(EventList.getEventList().get(i));
            if(EventList.getEventList().get(i).getcharacteristics().isEducation())
                QualityList.getEducationList().add(EventList.getEventList().get(i));
            if(EventList.getEventList().get(i).getcharacteristics().isEntertainment())
                QualityList.getEducationList().add(EventList.getEventList().get(i));
            if(EventList.getEventList().get(i).getcharacteristics().isFashion())
                QualityList.getFashionList().add(EventList.getEventList().get(i));
            if(EventList.getEventList().get(i).getcharacteristics().isFood())
                QualityList.getFoodList().add(EventList.getEventList().get(i));
            if(EventList.getEventList().get(i).getcharacteristics().isHealth())
                QualityList.getHealthList().add(EventList.getEventList().get(i));
            if(EventList.getEventList().get(i).getcharacteristics().isHobbies())
                QualityList.getHobbiesList().add(EventList.getEventList().get(i));
            if(EventList.getEventList().get(i).getcharacteristics().isHoliday())
                QualityList.getHollidayList().add(EventList.getEventList().get(i));
            if(EventList.getEventList().get(i).getcharacteristics().isLifestyle())
                QualityList.getLifestyleList().add(EventList.getEventList().get(i));
            if(EventList.getEventList().get(i).getcharacteristics().isMusic())
                QualityList.getMusicList().add(EventList.getEventList().get(i));
            if(EventList.getEventList().get(i).getcharacteristics().isOther())
                QualityList.getOtherList().add(EventList.getEventList().get(i));
            if(EventList.getEventList().get(i).getcharacteristics().isOutdoor())
                QualityList.getOutdoorList().add(EventList.getEventList().get(i));
            if(EventList.getEventList().get(i).getcharacteristics().isPolitics())
                QualityList.getPoliticsList().add(EventList.getEventList().get(i));
            if(EventList.getEventList().get(i).getcharacteristics().isReligious()))
                QualityList.getReligiousList().add(EventList.getEventList().get(i));
            if(EventList.getEventList().get(i).getcharacteristics().isSports())
                QualityList.getSportsList().add(EventList.getEventList().get(i));
            if(EventList.getEventList().get(i).getcharacteristics().isTechnology())
                QualityList.getTechList().add(EventList.getEventList().get(i));
            if(EventList.getEventList().get(i).getcharacteristics().isVehicle())
                QualityList.getVehicleList().add(EventList.getEventList().get(i));
            if(EventList.getEventList().get(i).getcharacteristics().isVisual_arts())
                QualityList.getVehicleList().add(EventList.getEventList().get(i));
        }
    }
}
