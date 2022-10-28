package com.example.mephim.service.impl;

import com.example.mephim.dto.MovieCreateDto;
import com.example.mephim.entity.Movie;
import com.example.mephim.entity.MovieActor;
import com.example.mephim.entity.MovieCategory;
import com.example.mephim.entity.MovieTheater;
import com.example.mephim.repos.MovieRepo;
import com.example.mephim.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepo movieRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public List<Movie> findAMovies() {
            return movieRepo.findAll();
    }

    @Override
    public void saveMovie(MovieCreateDto movieCreateDto) {
        Movie movie = new Movie();
        movie.setMovieName(movieCreateDto.getMovieName());
        movie.setMovieDirector(movieCreateDto.getMovieDirector());
        movie.setMovieLength(movieCreateDto.getMovieLength());
        movie.setMovieTrailerUrl(movieCreateDto.getMovieTrailerUrl());
        movie.setMoviePoster(movieCreateDto.getMoviePoster());
        movie.setMovieDescription(movieCreateDto.getMovieDescription());

        List<Integer> categoryIds = movieCreateDto.getMovieCategoryIds();
        List<MovieCategory> movieCategoryList = new ArrayList<>();
        categoryIds.forEach((categoryId) -> movieCategoryList.add(new MovieCategory(categoryId)));
        movie.setMovieCategories(movieCategoryList);

        List<Integer> movieActorIds = movieCreateDto.getMovieActorIds();
        List<MovieActor> movieActorList = new ArrayList<>();
        movieActorIds.forEach((movieActorId) -> movieActorList.add(new MovieActor(movieActorId)));
        movie.setMovieActors(movieActorList);

        List<Integer> movieTheaterIds = movieCreateDto.getMovieTheaterIds();
        List<MovieTheater> movieTheaterList = new ArrayList<>();
        movieTheaterIds.forEach((movieTheaterId) -> movieTheaterList.add(new MovieTheater(movieTheaterId)));
        movie.setMovieTheaters(movieTheaterList);
        movieRepo.save(movie);
    }

    @Override
    public void deleteMovie(Integer movieId) {
        movieRepo.deleteById(movieId);
    }
}
