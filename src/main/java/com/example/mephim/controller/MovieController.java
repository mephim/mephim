package com.example.mephim.controller;

import com.example.mephim.dto.MovieCreateDto;
import com.example.mephim.entity.Movie;
import com.example.mephim.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    @Autowired
    MovieServiceImpl movieService;

    @GetMapping("/listMovie")
    public ResponseEntity<?> listMovie() {
        List<Movie> movieList = movieService.findAMovies();
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @PostMapping(value = "/addMovie")
    public ResponseEntity<?> addMovie(@RequestBody MovieCreateDto movieCreateDto) {
        System.out.println("Form data: " + movieCreateDto);
       try {
            movieService.saveMovie(movieCreateDto);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
