package com.example.cinescore.model;

import java.io.Serializable;
import java.util.HashMap;

public class UserManager implements Serializable {
    private static UserManager instance;
    private static HashMap<String, User> users = new HashMap<>();
    private User currentUser;

    private UserManager() {}

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public User getUser(String username){
        return users.get(username);
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public static HashMap<String, User> getUsers() {
        return users;
    }

    public void addUser(User user){
        users.put(user.getUsername(), user);
    }
}