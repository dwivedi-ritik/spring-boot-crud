package dev.ritik.movies.jsonMovie;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

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

class MoviesJson{
    ArrayList<MoviesArray> movies;

    public ArrayList<MoviesArray> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<MoviesArray> movies) {
        this.movies = movies;
    }
}

class MoviesArray{
    Long id;
    String title;
    Integer year;
    Integer runtime;
    List<String> genres;
    String director;
    String actors;
    String plot;
    String posterUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}

