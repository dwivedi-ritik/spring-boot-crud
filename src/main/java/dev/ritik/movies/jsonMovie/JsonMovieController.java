package dev.ritik.movies.jsonMovie;

import dev.ritik.movies.error.CustomError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v2/")
public class JsonMovieController {
    private final JsonMovieService jsonMovieService;

    @Autowired
    JsonMovieController(JsonMovieService jsonMovieService){
        this.jsonMovieService = jsonMovieService;
    }
    @RequestMapping(path = "getAllMovies" , method = RequestMethod.GET)
    public @ResponseBody MoviesJson getAllMovies() throws Exception{
        return jsonMovieService.getAllMovies();
    }

    @RequestMapping(path = "movies" , method = RequestMethod.GET)
    public @ResponseBody MoviesJson getMovieById(@RequestParam("id") Long id) throws Exception{
        return jsonMovieService.getMovieById(id);
    }

    @ExceptionHandler(Exception.class)
    public @ResponseBody CustomError handleException(Exception e){
        return new CustomError(e.getLocalizedMessage());
    }
}
