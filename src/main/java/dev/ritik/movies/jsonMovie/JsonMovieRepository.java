package dev.ritik.movies.jsonMovie;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class JsonMovieRepository {
    public MoviesJson getAllMovies() throws Exception {
        JsonHandler jsonHandler = new JsonHandler();
        String json = jsonHandler.getAllJson();
        return jsonHandler.fetchObjects(json);
    }

    public static MoviesJson getMoviesById(Long id) throws Exception{
        JsonHandler jsonHandler = new JsonHandler();

        ArrayList<MoviesArray> mArr = new ArrayList<>();

        String json = jsonHandler.getAllJson();
        MoviesJson moviesJson = jsonHandler.fetchObjects(json);

        for(MoviesArray moviesArray: moviesJson.getMovies()){
            if(moviesArray.id ==  id) {
                mArr.add(moviesArray);
                break;
            }
        }
        MoviesJson resMoviesJson =  new MoviesJson();
        resMoviesJson.setMovies(mArr);
        return resMoviesJson;
    }
}
