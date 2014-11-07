package com.example.mongoconnector;

import com.example.jozsef.myweekend.*;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 * Created by NicholasKenealy on 11/3/14.
 */
public class Connector {

    MongoClient mongoClient;
    DB db;
    DBCollection coll;


    /*
        Makes a Connector that connects the waggle event database
     */
     public Connector(){
         try {
             mongoClient = new MongoClient("www.waggle-it.me", 27017);
             db = mongoClient.getDB("nodetest1");
             System.out.println("Connect to database successfully");
             coll = db.getCollection("usercollection");
             System.out.println("Collection eventlist selected successfully");
         }catch(Exception e){
             System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         }

    }

    public MongoClient getMongoClient(){
        return mongoClient;
    }

    public DB getDb(){
        return db;
    }

    public DBCollection getCollection(){
        return coll;
    }


    public void printDB(){
        DBCursor cursor = coll.find();
        int i=1;
        while (cursor.hasNext()) {
            System.out.println("Inserted Document: "+i);
            String dbItem = cursor.next().toString();
            int index = dbItem.indexOf("title");
            String titleAndAfter = dbItem.substring(index + 10);
            String titleName = titleAndAfter.substring(0,titleAndAfter.indexOf("\""));
            System.out.println(titleName);
            i++;
        }
    }

    //public Event pullEvent(int i){

    //}

    //public Event pushEvent(Event e){

    //}


}
