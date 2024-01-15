package com.example.cinescore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Show implements Serializable, Media {

    private String title;
    private int releaseYear;

    ArrayList<Integer> ratings;
    ArrayList<String> reviews;

    public Show(String title, int releaseYear){
        this.title = title;
        this.releaseYear = releaseYear;
    }
    public Show(){};

    public String getTitle() {
        return title;
    }
    public int getReleaseYear() {
        return releaseYear;
    }

}
