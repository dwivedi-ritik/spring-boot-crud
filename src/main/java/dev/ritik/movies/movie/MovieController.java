package dev.ritik.movies.movie;

import dev.ritik.movies.error.CustomError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/movie")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "getAllMovies", method = RequestMethod.GET)
    public List<Movie> getMovies() {
        return movieService.getAllMovies();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody Movie movieById(@RequestParam("id") Long ID) {
        return movieService.getMovieById(ID);
    }

    @RequestMapping(value = "addMovie", method = RequestMethod.POST)
    public @ResponseBody Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @RequestMapping(value = "updateMovie", method = RequestMethod.PUT)
    public @ResponseBody Movie updateMovie(@RequestParam("id") Long id, @RequestBody Movie updatedMovie) {
        return movieService.updateMovieById(id, updatedMovie);
    }

    @RequestMapping(value = "deleteMovie", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteMovie(@RequestParam("id") Long id) {
        return movieService.deleteMovie(id) ? new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "getRandom", method = RequestMethod.GET)
    public ResponseEntity<Movie> getRandomMovieController() {
        return new ResponseEntity<>(movieService.getRandomMovie(), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public @ResponseBody CustomError handleException(Exception e) {
        return new CustomError(e.getLocalizedMessage());
    }

}
