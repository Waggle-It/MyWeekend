package com.example.jozsef.myweekend.javaCode.Objects;

/**
 * Created by Jozsef on 10/31/2014.
 */
public class User {
    private String email;
    private String password;
    private int zipCode;
    private int[] preferancesAttended;
    private int[] preferancesLike;


    public User(String email, String password, int zipCode, int[] preferancesLike){
        this.email = email;
        this.password = password;
        this.zipCode = zipCode;

        this.preferancesLike = preferancesLike;
        this.preferancesAttended = preferancesLike;
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

    public void setPreferancesAttended(int[] preferancesAttended) {
        this.preferancesAttended = preferancesAttended;
    }

    public void setPreferancesLike(int[] preferancesLike) {
        this.preferancesLike = preferancesLike;
    }
}