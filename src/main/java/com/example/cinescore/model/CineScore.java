package com.example.cinescore.model;

import java.io.Serializable;
import java.util.HashMap;

public class CineScore implements Serializable {
    private HashMap<String, Movie> movies;
    private  HashMap<String, Show> shows;
    private String name;

    public CineScore(String name){
        this.movies = new HashMap<>();
        this.shows = new HashMap<>();
        this.name = name;
    }
    public CineScore(){};

    public User createUser(String username, String email, String password) throws Exception {
        if(UserManager.getUsers().containsKey(username)){throw new Exception("Username is taken");}
        User newUser = new User(username, email, password);
        UserManager.getInstance().addUser(newUser);
        return newUser;
    }

    public User loginUser(String username, String password) throws Exception {
        if(UserManager.getUsers().containsKey(username)){
            User user = UserManager.getInstance().getUser(username);
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
