package dev.ritik.movies.jsonMovie;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class JsonHandler {
    public String getAllJson() throws Exception{
        StringBuilder json = new StringBuilder();
        String path = "movies.json";
        FileReader file = new FileReader(path);
        int i;
        while((i = file.read() ) != -1 ){
            json.append((char) i);
        }
        return json.toString();
    }

    public MoviesJson fetchObjects(String json) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, MoviesJson.class);
    }
}

