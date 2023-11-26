// Write your code here

package com.example.movie;

import java.util.*;
import com.example.movie.Movie;

public interface MovieRepository {
    ArrayList<Movie> getAllMovies();

    Movie getMovieById(int movieId);

    Movie addMovie(Movie movie);

    Movie updateMovieById(int movieId, Movie movie);

    void deleteMovieById(int movieId);

}