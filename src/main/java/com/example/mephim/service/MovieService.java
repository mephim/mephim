package com.example.mephim.service;

import com.example.mephim.dto.MovieCreateDto;
import com.example.mephim.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAMovies();
    void saveMovie(MovieCreateDto movie);
    void deleteMovie(Integer movieId);
}
