/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here

package com.example.movie;

import java.util.*;
import com.example.movie.Movie;
import com.example.movie.MovieService;

import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    MovieService movieService = new MovieService();

    @GetMapping("/movies")
    public ArrayList<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable("movieId") int movieId) {
        return movieService.getMovieById(movieId);
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);

    }

    @PutMapping("/movies/{movieId}")
    public Movie updateMovieById(@PathVariable("movieId") int movieId, @RequestBody Movie movie) {
        return movieService.updateMovieById(movieId, movie);
    }

    @DeleteMapping("/movies/{movieId}")
    public void deleteMovieById(@PathVariable("movieId") int movieId) {
        movieService.deleteMovieById(movieId);
    }

}