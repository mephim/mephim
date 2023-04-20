package com.example.mephim.service;

import com.example.mephim.request.MovieCreateDto;
import com.example.mephim.entity.Movie;
import com.example.mephim.response.MovieDetailResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {
    Page<Movie> findAMoviesForAdmin(Pageable pageable);
    List<Movie> findAMovies();
    MovieDetailResponse findById(Integer movieId);
    List<Movie> findMovieHasTicket();
    List<Movie> findMovieHasTicketAndSearchByCategoryAndName(String keySearch, Integer categoryId);
    List<Movie> findMovieHasTicketAndSearchByName(String keySearch);
    List<Movie> findMovieHasTicketAndSearchByCategory(Integer categoryId);
    void saveMovie(MovieCreateDto movie) throws Exception;
    void deleteMovie(Integer movieId);
    List<Movie> getMovieByTheater(Integer theaterId);
    List<Movie> getMovieByShowDate(Integer showDateId);
}
