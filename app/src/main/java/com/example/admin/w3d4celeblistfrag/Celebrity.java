package com.example.admin.w3d4celeblistfrag;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by admin on 9/14/2017.
 */

class Celebrity implements Serializable{
    private String name, movie;
    private int age, height, picID;

    public Celebrity(String name, String movie, int age, int height, int picID) {
        this.name = name;
        this.movie = movie;
        this.age = age;
        this.height = height;
        this.picID = picID;
        Log.d("TAG", "Celebrity: " + picID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPicID() {
        return picID;
    }

    public void setPicID(int picID) {
        this.picID = picID;
    }
}
