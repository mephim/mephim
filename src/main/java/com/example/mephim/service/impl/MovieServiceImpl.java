package com.example.mephim.service.impl;

import com.example.mephim.request.MovieCreateDto;
import com.example.mephim.entity.*;
import com.example.mephim.exception.InvalidParamException;
import com.example.mephim.repos.MovieRepo;
import com.example.mephim.response.MovieDetailResponse;
import com.example.mephim.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service @Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepo movieRepo;
    @Autowired
    CommonService commonService;
    @Autowired
    MovieCategoryService movieCategoryService;
    @Autowired
    CategoryService categoryService;

    @Override
    public Page<Movie> findAMoviesForAdmin(Pageable pageable) {
        return movieRepo.findAll(pageable);
    }

    @Override
    public List<Movie> findAMovies() {
        return movieRepo.findAll();
    }

    @Override
    public MovieDetailResponse findById(Integer movieId) {
        Movie movie = movieRepo.findMovieByMovieId(movieId);
        List<Category> categoryList = categoryService.findByMovie(movieId);
        if(movie == null) return null;
        MovieDetailResponse movieDetailResponse = new MovieDetailResponse();
        movieDetailResponse.setMovie(movie);
        movieDetailResponse.setCategoryList(categoryList);
        return movieDetailResponse;
    }

    @Override
    public List<Movie> findMovieHasTicket() {
        return movieRepo.findMovieHasTicket();
    }

    boolean isExitsCategoriesId(List<Integer> idList) {
        List<Integer> listIdNotExist = idList.stream().filter((id -> commonService.findCategoryById(id) == null))
                .collect(Collectors.toList());
        return listIdNotExist.isEmpty();
    }

    @Override
    public void saveMovie(MovieCreateDto movieCreateDto) throws InvalidParamException {
        Movie movie = new Movie();
        movie.setMovieName(movieCreateDto.getMovieName());
        movie.setMovieActor(movieCreateDto.getMovieActor());
        movie.setMovieDirector(movieCreateDto.getMovieDirector());
        movie.setMovieLength(movieCreateDto.getMovieLength());
        movie.setMovieTrailerUrl(movieCreateDto.getMovieTrailerUrl());
        movie.setMoviePoster(movieCreateDto.getMoviePoster());
        movie.setMovieDescription(movieCreateDto.getMovieDescription());

        Movie movieSaved = movieRepo.save(movie);
        movieCreateDto.getMovieCategoryIds().forEach(id -> {
            MovieCategory movieCategory = new MovieCategory();
            movieCategory.setCategory(new Category(id));
            movieCategory.setMovie(movieSaved);
            movieCategoryService.save(movieCategory);
        });
    }

    @Override
    public void deleteMovie(Integer movieId) {
        movieRepo.deleteById(movieId);
    }

    @Override
    public List<Movie> getMovieByTheater(Integer theaterId) {
        return movieRepo.findMovieByTheaterId(theaterId);
    }

    @Override
    public List<Movie> getMovieByShowDate(Integer showDateId) {
        return movieRepo.getMovieByShowDate(showDateId);
    }
}
