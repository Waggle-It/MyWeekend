package com.example.jozsef.myweekend.javaCode;

import com.example.jozsef.myweekend.javaCode.Objects.User;
import com.example.jozsef.myweekend.javaCode.Objects.UserList;
import com.example.jozsef.myweekend.androidCode.NewUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jozsef on 11/5/2014.
 * Verifies valid inputs from the user controlling weather the user gets created or not.
 */
public class VerifyCreateNewUser extends NewUser {

    //Creates a new user if all inputs are validated.
    public boolean create(String email, String password, String confirmPassword,int zip){

        int[] preferancesLike = new int[21];

        if(verifyEmail(email) && verifyPassword(password, confirmPassword) && verifyZip(zip) && uniqueUser(email) && verifyEmail(email)) {
            for (int i = 0; i < 21; i++)
                preferancesLike[i] = 0;


            User newUser = new User(email, password, zip);
            UserList.addUser(newUser);

            return true;
        }
        return false;
    }
    //Determines if password and verify password are the same and length is 8 or greater.
    private boolean verifyPassword(String password, String confirmPassword){
        if (password.length()>7) {
            if(password.equals(confirmPassword))
                return true;
            else
                super.passwordMatchError();
        }
        else
            super.passWordParameterError();

        return false;
    }

    //verifies length 5 and all integers.
    private boolean verifyZip(int Zip){
        if(Integer.toString(Zip).length()==5) {
            return true;
        }
        else
            super.validZipError();

        return false;
    }

    private boolean uniqueUser(String email){

        boolean unique = true;

        for(int i=0; i<UserList.getUserListLength(); i++) {
            if (UserList.getUserEmail(i).equals(email))
                unique = false;
        }
        if(!unique)
            super.acctAlreadyRegisteredError();

        return unique;
    }

    //Code borrowed from http://examples.javacodegeeks.com/
    private boolean verifyEmail(String email){

        Pattern pattern;
        Matcher matcher;

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        pattern = Pattern.compile(EMAIL_PATTERN);

        matcher = pattern.matcher(email);

        if(!matcher.matches())
            super.invalidEmailError();

        return matcher.matches();


    }
}