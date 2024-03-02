package com.example.cinescore.model;

import java.io.Serializable;
import java.util.HashMap;

public class CineScore implements Serializable {
    private HashMap<String, User> users;
    private HashMap<String, Movie> movies;
    private String name;

    public CineScore(){}

    public HashMap<String, Movie> getMovies() {
        return movies;
    }

    public void createUser(String username, String password) throws Exception {
        if(users.containsKey(username)){throw new Exception("Username is taken");}
        User newUser = new User(username, password);
        users.put(username, newUser);
    }

    public User loginUser(String username, String password) throws Exception {
        if (username.isBlank()){throw new Exception("Username cannot be blank");}
        if (password.isBlank()){throw new Exception("Password cannot be blank");}
        if(users.containsKey(username)){
            User user = users.get(username);
            if(user.getPassword().equals(password)){
                System.out.println("Login success! Welcome " + username + "!");
                return user;
            } else {throw new Exception("Password incorrect. Try again!");}
        } else {throw new Exception("User does not exist");}
    }

    // public Movie getMovie(String id){
        // Use DAO method
    //}




}
