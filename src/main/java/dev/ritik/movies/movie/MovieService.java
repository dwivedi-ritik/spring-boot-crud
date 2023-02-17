package dev.ritik.movies.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    @Autowired
    MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }
    public List<Movie>getAllMovies(){
        return movieRepository.findAll();
    }
    public Movie getMovieById(Long id){
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.get();
    }

    public Movie updateMovieById(Long id , Movie updatedMovie){
        Movie fetchedMovie = movieRepository.findById(id).get();
        if(updatedMovie.getTitle() != null){
            fetchedMovie.setTitle(updatedMovie.getTitle());
        }
        if(updatedMovie.getDescription() != null){
            fetchedMovie.setDescription(updatedMovie.getDescription());
        }
        if(updatedMovie.getRating() != null){
            fetchedMovie.setRating(updatedMovie.getRating());
        }
        if(updatedMovie.getDownloads() != null){
            fetchedMovie.setDownloads(updatedMovie.getDownloads());
        }
        return movieRepository.save(fetchedMovie);
    }
    public Movie addMovie(Movie movie){
       return movieRepository.save(movie);
    }

    public boolean deleteMovie(Long id){
        if(!movieRepository.existsById(id)) return false;
        Movie movie = movieRepository.findById(id).get();
        movieRepository.delete(movie);
        return true;
    }
}
