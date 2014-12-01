package com.example.jozsef.myweekend.javaCode.Objects;

/**
 * Created by Jozsef on 10/31/2014.
 */
public class UserList {
    private static User currentUser;
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

    public static int getUserListLength(){return userList.length;}

    public static User getCurrentUser() {
        return currentUser;
    }

    public static final void setCurrentUser(int i) {
        UserList.currentUser = userList[i];
    }
    public static final void setCurrentUser(User i) {
        UserList.currentUser = i;}

}