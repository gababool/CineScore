package com.example.cinescore.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class DataManager {
    private static final String MEDIA_FILE_PATH = "src/main/java/com/example/cinescore/data/mediaData.json";
    private static final String USERS_FILE_PATH = "src/main/java/com/example/cinescore/data/userData.json";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void saveMedia(CineScore cineScore) {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            objectMapper.writeValue(new File(MEDIA_FILE_PATH), cineScore);
            System.out.println("Data saved to " + MEDIA_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CineScore loadMedia() {
        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            return objectMapper.readValue(new File(MEDIA_FILE_PATH), CineScore.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveUsers(UserManager userManager) {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            objectMapper.writeValue(new File(USERS_FILE_PATH), userManager);
            System.out.println("Data saved to " + USERS_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserManager loadUsers() {
        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            return objectMapper.readValue(new File(USERS_FILE_PATH), UserManager.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
