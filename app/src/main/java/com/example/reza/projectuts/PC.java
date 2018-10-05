package com.example.reza.projectuts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PC {

    private String name;
    private int thumbnail;
    private int rating;

    public PC(){

    }

    public PC(String name, int rating, int thumbnail) {
        this.name = name;
        this.rating = rating;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}