package com.example.cinescore.model;

import com.example.cinescore.CineScoreApp;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.*;

public class User implements Serializable {
    private String username;
    private String password;
    private HashMap<String, Integer> ratedMovies;
    private ArrayList<Movie> watchlist;

    public User(String username, String password){
        this.username = username;
        this.password = username;
        this.ratedMovies = new HashMap<>();
        this.watchlist = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static boolean checkCredentials(String username, String password) throws SQLException {
        if (username.isBlank()) {
            throw new SQLException("Username cannot be blank");
        }
        if (!username.matches("[a-zA-Z0-9]+")) {
            throw new SQLException("Invalid username. Must only contain letters and/or digits.");
        }
        if (username.length() > 12) {
            throw new SQLException("Username length cannot exceed 12 characters");
        }
        if (password.isBlank()) {
            throw new SQLException("Password cannot be blank");
        }
        if (password.length() > 16) {
            throw new SQLException("Password length cannot exceed 16 characters");
        }
        if (password.length() < 8) {
            throw new SQLException("Password length cannot be less than 8 characters");
        }
        return true;
    }

    public void setUsername(String username) throws Exception {
        this.username = username;
    }

    public void setPassword(String password) throws Exception {
        this.password = password;
    }

    public ArrayList<Movie> getRatedMovies(){
        return new ArrayList<>();
    }

    public ArrayList<Movie> getWatchlistedMovies(){
        return new ArrayList<>();
    }

}
