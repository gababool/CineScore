package com.example.cinescore.model;

public class UserManager {
    private static UserManager instance;
    private User currentUser;

    private UserManager() {}

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public User getCurrentUser() {return currentUser;}

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public void removeCurrentUser() {this.currentUser = null;}

}