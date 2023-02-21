package dev.ritik.movies.jsonMovie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
public class testMovie {
    public static void main(String[] args) throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        JsonHandler jsonHandler = new JsonHandler();
        String json = jsonHandler.getAllJson();
        MoviesJson moviesJson = jsonHandler.fetchObjects(json);

        System.out.println(mapper.writeValueAsString(moviesJson));
    }
}
