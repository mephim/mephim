package com.example.mephim.controller;

import com.example.mephim.constants.Constants;
import com.example.mephim.request.MovieCreateDto;
import com.example.mephim.entity.Movie;
import com.example.mephim.exception.InvalidParamException;
import com.example.mephim.response.CustomResponse;
import com.example.mephim.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    @Autowired
    MovieService movieService;
    @GetMapping("/listMovie")
    public ResponseEntity<?> listMovie() {
        List<Movie> movieList = movieService.findAMovies();
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }
    @PostMapping(value = "/addMovie")
    public ResponseEntity<?> addMovie(@RequestBody MovieCreateDto movieCreateDto) {
        try {
            movieService.saveMovie(movieCreateDto);
        } catch (InvalidParamException e) {
            return new ResponseEntity<>(new CustomResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new CustomResponse(Constants.RESPONSE_STATUS_ERROR), HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(new CustomResponse(Constants.RESPONSE_STATUS_SUCCESS), HttpStatus.CREATED);
    }
}
