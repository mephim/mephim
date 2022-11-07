package com.example.mephim.service;

import com.example.mephim.request.MovieCreateDto;
import com.example.mephim.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAMovies();
    void saveMovie(MovieCreateDto movie) throws Exception;
    void deleteMovie(Integer movieId);
    Integer getMovieByShowDate(Integer showDateId);
}
