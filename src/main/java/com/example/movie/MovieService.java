/*
 * You can use the following import statements
 * 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 * 
 */

package com.example.movie;

import com.example.movie.Movie;
import com.example.movie.MovieRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import javax.validation.OverridesAttribute;

// Do not modify the below code

public class MovieService implements MovieRepository {

    private static HashMap<Integer, Movie> movieList = new HashMap<>();

    public MovieService() {
        movieList.put(1, new Movie(1, "Avengers: Endgame", "Robert Downey Jr."));
        movieList.put(2, new Movie(2, "Avatar", "Sam Worthington"));
        movieList.put(3, new Movie(3, "Titanic", "Leonardo DiCaprio"));
        movieList.put(4, new Movie(4, "Star Wars: The Force Awakens", "Daisy Ridley"));
        movieList.put(5, new Movie(5, "Jurassic World", "Chris Pratt"));
    }

    // Do not modify the above code

    // Write your code here

    int uniqueId = 6;

    @Override
    public ArrayList<Movie> getAllMovies() {
        Collection<Movie> moviesCollection = movieList.values();
        ArrayList<Movie> allMovies = new ArrayList<>(moviesCollection);

        return allMovies;
    }

    @Override
    public Movie getMovieById(int movieId) {
        Movie movie = movieList.get(movieId);
        if (movie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return movie;
        }

    }

    @Override
    public Movie addMovie(Movie movie) {
        movie.setMovieId(uniqueId);
        movieList.put(uniqueId, movie);
        uniqueId += 1;
        return movie;
    }

    @Override
    public Movie updateMovieById(int movieId, Movie movie) {
        Movie existMovie = movieList.get(movieId);
        if (existMovie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (movie.getMovieName() != null) {
            existMovie.setMovieName(movie.getMovieName());
        }
        if (movie.getLeadActor() != null) {
            existMovie.setLeadActor(movie.getLeadActor());
        }
        return existMovie;

    }

    @Override
    public void deleteMovieById(int movieId) {
        Movie movie = movieList.get(movieId);

        if (movie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            movieList.remove(movieId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }

}
