package com.example.jozsef.myweekend.sortComparators;

import com.example.jozsef.myweekend.javaCode.Objects.Event;
import com.example.jozsef.myweekend.javaCode.SearchTest;

import java.util.Comparator;

/**
 * Created by Jozsef on 12/6/2014.
 */
public class RankSort implements Comparator<SearchTest.SearchRank> {


    @Override
    public int compare(SearchTest.SearchRank one, SearchTest.SearchRank two) {
        if(one.getRank()<two.getRank())
            return -1;
        if(two.getRank()>two.getRank())
            return 1;

        return 0;
    }
}
