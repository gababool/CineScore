package com.example.cinescore.model;

import com.example.cinescore.CineScoreApp;

import java.io.Serializable;
import java.util.*;

public class User implements Serializable {
    private String username;
    private String password;

    public User(String username, String password) throws Exception {
        this.username = checkUsername(username);
        this.password = checkPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String checkUsername(String username) throws Exception {
        if (username.isBlank()) {
            throw new Exception("Username cannot be blank");
        }
        if (!username.matches("[a-zA-Z0-9]+")) {
            throw new Exception("Invalid username. Must only contain letters and/or digits.");
        }
        if (username.length() > 12) {
            throw new Exception("Username length cannot exceed 12 characters");
        }
        return username;
    }

    public String checkPassword(String password) throws Exception {
        if (password.isBlank()) {
            throw new Exception("Password cannot be blank");
        }
        if (password.length() > 16) {
            throw new Exception("Password length cannot exceed 16 characters");
        }
        if (password.length() < 8) {
            throw new Exception("Password length cannot be less than 8 characters");
        }
        return password;
    }

    public void setUsername(String username) throws Exception {
        this.username = checkUsername(username);
    }

    public void setPassword(String password) throws Exception {
        this.password = checkPassword(password);
    }
}
