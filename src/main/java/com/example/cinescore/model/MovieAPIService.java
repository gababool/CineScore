package com.example.cinescore.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MovieAPIService {
    static String baseUrl = "http://www.omdbapi.com/";
    static String apiKey = "84c068f5";

    public static void main(String[] args) {
        retrieveMovieData("The Godfather", "1972");
    }


    public static Movie retrieveMovieData(String movieTitle, String movieReleaseYear){
        Movie movie = null;
        try{
            String encodedTitle = URLEncoder.encode(movieTitle, "UTF-8");
            String encodedYear = URLEncoder.encode(movieReleaseYear, "UTF-8");

            String fullUrl = baseUrl + "?t=" + encodedTitle + "&y=" + encodedYear + "&apikey=" + apiKey;

            URL url = new URL(fullUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonResponse = objectMapper.readTree(response.toString());

            String title = jsonResponse.get("Title").asText();
            String year = jsonResponse.get("Year").asText();
            String director = jsonResponse.get("Director").asText();
            String poster = jsonResponse.get("Poster").asText();
            String runtime = jsonResponse.get("Runtime").asText();
            String writer = jsonResponse.get("Writer").asText();
            String actors = jsonResponse.get("Actors").asText();
            String plot = jsonResponse.get("Plot").asText();
            String id = jsonResponse.get("imdbID").asText();

            movie = new Movie(title, director, year, writer, runtime, actors, plot, id, poster);

            connection.disconnect();

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Movie not found");
        }
        return movie;

    }

}



