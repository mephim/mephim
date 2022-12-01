package com.example.mephim.service;

import com.example.mephim.request.MovieCreateDto;
import com.example.mephim.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAMovies();
    List<Movie> findMovieHasTicket();
    void saveMovie(MovieCreateDto movie) throws Exception;
    void deleteMovie(Integer movieId);
    List<Movie> getMovieByTheater(Integer theaterId);
    List<Movie> getMovieByShowDate(Integer showDateId);
}
