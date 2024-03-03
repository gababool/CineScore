package com.example.cinescore.model;

import java.io.Serializable;
import java.util.HashMap;

public class CineScore implements Serializable {
    public CineScore(){}

    public void createUser(String username, String password) {
        UserDAO.addNewUser(username, password);
    }

    public User loginUser(String username, String password) {
        return UserDAO.loginUser(username, password);
    }

    // public Movie getMovie(String id){
        // Use DAO method
    //}




}
