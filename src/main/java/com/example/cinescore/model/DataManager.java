package com.example.cinescore.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class DataManager {
    private static final String FILE_PATH = "src/main/java/com/example/cinescore/data/data.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void saveState(CineScore cineScore) {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            objectMapper.writeValue(new File(FILE_PATH), cineScore);
            System.out.println("Data saved to " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CineScore loadState() {
        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            return objectMapper.readValue(new File(FILE_PATH), CineScore.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
