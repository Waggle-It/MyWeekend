package com.example.jozsef.myweekend.sortComparators;

import com.example.jozsef.myweekend.javaCode.Objects.Event;
import com.example.jozsef.myweekend.javaCode.Objects.EventList;
import com.example.jozsef.myweekend.javaCode.Objects.QualityList;

/**
 * Created by Jozsef on 11/24/2014.
 * IDK need to figure out how to implement a category sort that is efficient.
 */
public class CatSort {
    public void eventSort(){
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
            if(EventList.getEventList().get(i).getcharacteristics().isReligious())
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
    public void eventSort(Event event){
        if(event.getcharacteristics().isBusiness())
            QualityList.getBuisnessList().add(event);
        if(event.getcharacteristics().isCause())
            QualityList.getCauseList().add(event);
        if(event.getcharacteristics().isEducation())
            QualityList.getEducationList().add(EventList.getEventList().get(i));
        if(event.getcharacteristics().isEntertainment())
            QualityList.getEducationList().add(event);
        if(event.getcharacteristics().isFashion())
            QualityList.getFashionList().add(event);
        if(event.getcharacteristics().isFood())
            QualityList.getFoodList().add(event);
        if(event.getcharacteristics().isHealth())
            QualityList.getHealthList().add(event);
        if(event.getcharacteristics().isHobbies())
            QualityList.getHobbiesList().add(event);
        if(event.getcharacteristics().isHoliday())
            QualityList.getHollidayList().add(event);
        if(event.getcharacteristics().isLifestyle())
            QualityList.getLifestyleList().add(event);
        if(event.getcharacteristics().isMusic())
            QualityList.getMusicList().add(event);
        if(event.getcharacteristics().isOther())
            QualityList.getOtherList().add(event);
        if(event.getcharacteristics().isOutdoor())
            QualityList.getOutdoorList().add(event);
        if(event.getcharacteristics().isPolitics())
            QualityList.getPoliticsList().add(event);
        if(event.getcharacteristics().isReligious()))
        QualityList.getReligiousList().add(event);
        if(event.getcharacteristics().isSports())
            QualityList.getSportsList().add(event);
        if(event.getcharacteristics().isTechnology())
            QualityList.getTechList().add(event);
        if(event.getcharacteristics().isVehicle())
            QualityList.getVehicleList().add(event);
        if(event.getcharacteristics().isVisual_arts())
            QualityList.getVehicleList().add(event);
    }
}
