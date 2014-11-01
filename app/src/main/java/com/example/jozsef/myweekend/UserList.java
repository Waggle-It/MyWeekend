package com.example.jozsef.myweekend;

/**
 * Created by Jozsef on 10/31/2014.
 */
public class UserList {
    private static User[] userList = new User[0];

    public static void addUser(User nEw){
        User[] temp = new User[userList.length + 1];

        for(int i=0; i<userList.length; i++){
            temp[i] = userList[i];
        }
        temp[userList.length] = nEw;
        userList = temp;
    }

    public static String getPassword(int i){
        return userList[i].getPassword();
    }

    public static String getUserEmail(int i){
        return userList[i].getEmail();
    }
}
