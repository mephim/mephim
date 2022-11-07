package com.example.mephim.service.impl;

import com.example.mephim.request.MovieCreateDto;
import com.example.mephim.entity.*;
import com.example.mephim.exception.InvalidParamException;
import com.example.mephim.repos.MovieRepo;
import com.example.mephim.service.CommonService;
import com.example.mephim.service.MovieActorService;
import com.example.mephim.service.MovieCategoryService;
import com.example.mephim.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
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
    MovieActorService movieActorService;
    @Autowired
    MovieCategoryService movieCategoryService;

    @Override
    public List<Movie> findAMovies() {
        return movieRepo.findAll();
    }

    boolean isExitsCategoriesId(List<Integer> idList) {
        List<Integer> listIdNotExist = idList.stream().filter((id -> commonService.findCategoryById(id) == null))
                .collect(Collectors.toList());
        return listIdNotExist.isEmpty();
    }
    boolean isExitsActorsId(List<Integer> idList) {
        List<Integer> listIdNotExist = idList.stream().filter((id -> commonService.findActorById(id) == null))
                .collect(Collectors.toList());
        return listIdNotExist.isEmpty();
    }

    @Override
    public void saveMovie(MovieCreateDto movieCreateDto) throws InvalidParamException {
        Movie movie = new Movie();
        movie.setMovieName(movieCreateDto.getMovieName());
        movie.setMovieDirector(movieCreateDto.getMovieDirector());
        movie.setMovieLength(movieCreateDto.getMovieLength());
        movie.setMovieTrailerUrl(movieCreateDto.getMovieTrailerUrl());
        movie.setMoviePoster(movieCreateDto.getMoviePoster());
        movie.setMovieDescription(movieCreateDto.getMovieDescription());

        if (!isExitsCategoriesId(movieCreateDto.getMovieCategoryIds())
                || !isExitsActorsId(movieCreateDto.getMovieActorIds())) {
            throw new InvalidParamException();
        }
        Movie movieSaved = movieRepo.save(movie);
        movieCreateDto.getMovieCategoryIds().forEach(id -> {
            MovieCategory movieCategory = new MovieCategory();
            movieCategory.setCategory(new Category(id));
            movieCategory.setMovie(movieSaved);
            movieCategoryService.save(movieCategory);
        });

        movieCreateDto.getMovieActorIds().forEach(id -> {
            MovieActor movieActor = new MovieActor();
            movieActor.setActor(new Actor(id));
            movieActor.setMovie(movieSaved);
            movieActorService.save(movieActor);
        });

    }

    @Override
    public void deleteMovie(Integer movieId) {
        movieRepo.deleteById(movieId);
    }

    @Override
    public Integer getMovieByShowDate(Integer showDateId) {
        return movieRepo.getMovieByShowDate(showDateId);
    }
}
