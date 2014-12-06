package com.example.jozsef.myweekend.javaCode;

import com.example.jozsef.myweekend.androidCode.Search;
import com.example.jozsef.myweekend.javaCode.Objects.Event;
import com.example.jozsef.myweekend.javaCode.Objects.Quality;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jozsef on 12/6/2014.
 */
public class SearchTest {
    public int titleContains(String[] keyWords, Event event){
        int count = 0;
        for(int i=0; i<keyWords.length; i++)
            if(event.getTitle().contains(keyWords[i]))
                count++;
        return count;
    }
    public int descriptionContains(String[] keyWords, Event event){
        int count = 0;
        for(int i=0; i<keyWords.length; i++)
            if(event.getDescription().contains(keyWords[i]))
                count++;

        return count;
    }
    public boolean dateWithinConstaraints(long start, long end, Event event){
        if(event.getDate()>=start && event.getDate()<=end)
            return true;
        return false;
    }
    public boolean affordHungry(double budget, int partySize, Event event){
        return budget < (event.getTicketCosts() + event.getFoodCosts()) * partySize;
    }
    public boolean afford(double budget, int partySize, Event event){
        return budget < event.getTicketCosts() * partySize;
    }
    public boolean testParameters(Event event, long start, long end, boolean hungry, double budget, int partySize){
        if((start != -1 || end !=-1) || dateWithinConstaraints(start, end, event)) {
            if (budget != -1) {
                if (hungry && affordHungry(budget, partySize, event))
                    return true;
                else if (!hungry && afford(budget, partySize, event))
                    return true;
            }
            else
                return true;
        }

        return false;

    }
    public int prefRank(Quality prefer, Event event){
        int prefRank = 0;
        if(event.getcharacteristics().isBusiness() && prefer.isBusiness())
            prefRank++;
        if(event.getcharacteristics().isCause() && prefer.isCause())
            prefRank++;
        if(event.getcharacteristics().isEducation() && prefer.isEducation())
            prefRank++;
        if(event.getcharacteristics().isEntertainment() && prefer.isEntertainment())
            prefRank++;
        if(event.getcharacteristics().isFashion() && prefer.isFashion())
            prefRank++;
        if(event.getcharacteristics().isFood() && prefer.isFood())
            prefRank++;
        if(event.getcharacteristics().isHealth() && prefer.isHealth())
            prefRank++;
        if(event.getcharacteristics().isHobbies() && prefer.isHobbies())
            prefRank++;
        if(event.getcharacteristics().isHoliday() && prefer.isHoliday())
            prefRank++;
        if(event.getcharacteristics().isLifestyle() && prefer.isLifestyle())
            prefRank++;
        if(event.getcharacteristics().isMusic() && prefer.isMusic())
            prefRank++;
        if(event.getcharacteristics().isOther() && prefer.isOther())
            prefRank++;
        if(event.getcharacteristics().isOutdoor() && prefer.isOutdoor())
            prefRank++;
        if(event.getcharacteristics().isPolitics() && prefer.isPolitics())
            prefRank++;
        if(event.getcharacteristics().isReligious() && prefer.isReligious())
            prefRank++;
        if(event.getcharacteristics().isSports() && prefer.isSports())
            prefRank++;
        if(event.getcharacteristics().isTechnology() && prefer.isTechnology())
            prefRank++;
        if(event.getcharacteristics().isVehicle() && prefer.isVehicle())
            prefRank++;
        if(event.getcharacteristics().isVisual_arts() && prefer.isVisual_arts())
            prefRank++;
        if(event.getcharacteristics().isHasFood() && prefer.isHasFood())
            prefRank++;
        return prefRank;
    }
    public int eventRank(String[] keywords, Event event, long start, long end, Quality prefer, boolean hungry, double budget, int partySize){
        if(testParameters(event, start, end, hungry, budget, partySize))
            return titleContains(keywords, event)*10+descriptionContains(keywords, event)+prefRank(prefer, event);

            return Integer.MAX_VALUE;

    }
    public int eventRankedList(String[] keywords, Event event, long start, long end, Quality prefer, boolean hungry, double budget, int partySize){
        List <SearchRank> temp = new ArrayList<SearchRank>();
        int rank = eventRank(keywords, event, start, end, prefer, hungry, budget, partySize);
        SearchRank tem = new SearchRank(event, rank);
        temp.add(tem);

        return 0;
    }
    public class SearchRank{
        private Event event;
        private int rank;

        public SearchRank(Event event, int rank){
            this.event = event;
            this.rank = rank;
        }

        public Event getEvent() {
            return event;
        }

        public void setEvent(Event event) {
            this.event = event;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            rank = rank;
        }
    }

}
