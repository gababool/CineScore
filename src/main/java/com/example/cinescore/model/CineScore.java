package com.example.cinescore.model;

import java.io.Serializable;
import java.util.HashMap;

public class CineScore implements Serializable {
    HashMap<String, User> users;
    HashMap<String, Movie> movies;
    HashMap<String, Show> shows;

    public CineScore(){
        this.users = new HashMap<>();
        this.movies = new HashMap<>();
        this.shows = new HashMap<>();
    }

    public User createUser(String username, String password) throws Exception {
        if(users.containsKey(username)){throw new Exception("Username is taken");}
        User newUser = new User(username, password);
        users.put(username, newUser);
        return newUser;
    }

    public User loginUser(String username, String password) throws Exception {
        if(users.containsKey(username)){
            User user = users.get(username);
            if(user.getPassword().equals(password)){
                System.out.println("Login success! Welcome " + username + "!");
                return user;
            } else {
                throw new Exception("Password incorrect. Try again!");
            }
        } else {
            throw new Exception("User does not exist");
        }
    }



}
