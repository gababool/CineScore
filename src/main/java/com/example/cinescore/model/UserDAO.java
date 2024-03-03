package com.example.cinescore.model;

import java.sql.*;

public class UserDAO {

    public static void addNewUser(String username, String password){
        try (Connection c = DatabaseUtil.getConnection()){
            User.checkCredentials(username, password); // Make this better
            PreparedStatement stmt = c.prepareStatement("INSERT INTO CS_USER VALUES (?, ?)");
            stmt.setString(1, username);
            stmt.setString(2, password);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("User registered successfully!");
            } else {
                System.out.println("Failed to insert user.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User loginUser(String username, String password){
        try (Connection c = DatabaseUtil.getConnection()){
            PreparedStatement stmt = c.prepareStatement("SELECT * FROM CS_USER WHERE username = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                String dbUsername = rs.getString("username");
                String dbPassword = rs.getString("password");

                if (dbUsername.equals(username) && dbPassword.equals(password)){
                    return new User(username, password);
                }
            } else {
                throw new SQLException("Password or username are incorrect");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




}
