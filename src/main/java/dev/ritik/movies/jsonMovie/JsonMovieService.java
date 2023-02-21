package dev.ritik.movies.jsonMovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsonMovieService {
    private final JsonMovieRepository jsonMovieRepository;
    @Autowired
    public JsonMovieService(JsonMovieRepository jsonMovieRepository){
        this.jsonMovieRepository = jsonMovieRepository;
    }
    public MoviesJson getAllMovies() throws Exception{
        return jsonMovieRepository.getAllMovies();
    }

    public MoviesJson getMovieById(Long id) throws Exception{
        return jsonMovieRepository.getMoviesById(id);
    }
}
