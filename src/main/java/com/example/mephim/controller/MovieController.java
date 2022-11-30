package com.example.mephim.controller;

import com.example.mephim.constants.Constants;
import com.example.mephim.entity.ShowDate;
import com.example.mephim.entity.ShowTime;
import com.example.mephim.request.MovieCreateDto;
import com.example.mephim.entity.Movie;
import com.example.mephim.exception.InvalidParamException;
import com.example.mephim.response.CustomResponse;
import com.example.mephim.response.ShowTimeRes;
import com.example.mephim.service.MovieService;
import com.example.mephim.service.ShowDateService;
import com.example.mephim.service.ShowTimeService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@CrossOrigin("*")
public class MovieController {
    @Autowired
    MovieService movieService;
    @Autowired
    ShowTimeService showTimeService;
    @Autowired
    ShowDateService showDateService;
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
            return new ResponseEntity<>(new CustomResponse<>(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new CustomResponse<>(Constants.RESPONSE_STATUS_ERROR), HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(new CustomResponse<>(Constants.RESPONSE_STATUS_SUCCESS), HttpStatus.CREATED);
    }

    @GetMapping(value = "/find-movie-by-theater")
    public ResponseEntity<?> findMovie(@RequestParam Integer theaterId) {
        List<Movie> movieList = movieService.getMovieByShowDate(theaterId);
        if(movieList.isEmpty()) return new ResponseEntity<>(new CustomResponse<>(Constants.RESPONSE_STATUS_SUCCESS), HttpStatus.OK);
        JSONObject dataResponseJson=new JSONObject();
        dataResponseJson.put("movieId", movieList);
        return new ResponseEntity<>(new CustomResponse<>(Constants.RESPONSE_STATUS_SUCCESS,dataResponseJson), HttpStatus.CREATED);
    }

    @GetMapping(value = "/find-show-date-by-movie")
    public ResponseEntity<?> findShowDate(@RequestParam Integer movieId) {
        List<ShowDate> showDateList = showDateService.findShowDateByMovieId(movieId);
        if(showDateList.isEmpty()) return new ResponseEntity<>(new CustomResponse<>(Constants.RESPONSE_STATUS_SUCCESS), HttpStatus.OK);
        JSONObject dataResponseJson=new JSONObject();
        dataResponseJson.put("showDateList", showDateList);
        return new ResponseEntity<>(new CustomResponse<>(Constants.RESPONSE_STATUS_SUCCESS,dataResponseJson), HttpStatus.CREATED);
    }

    @GetMapping(value = "/find-movie-by-show-date")
    public ResponseEntity<?> addMovie(@RequestParam Integer showDateId) {
        List<Movie> movieList = movieService.getMovieByShowDate(showDateId);
        if(movieList.isEmpty()) return new ResponseEntity<>(new CustomResponse<>(Constants.RESPONSE_STATUS_SUCCESS), HttpStatus.OK);
        JSONObject dataResponseJson=new JSONObject();
        dataResponseJson.put("movieId", movieList);
        return new ResponseEntity<>(new CustomResponse<>(Constants.RESPONSE_STATUS_SUCCESS,dataResponseJson), HttpStatus.CREATED);
    }

    @GetMapping(value = "/find-all-show-date")
    public ResponseEntity<?> findShowTimeByShowDate() {
        List<ShowDate> showDateList = showDateService.findAll();
        return new ResponseEntity<>(new CustomResponse<>(Constants.RESPONSE_STATUS_SUCCESS,showDateList), HttpStatus.CREATED);
    }

    @GetMapping(value = "/find-show-date-by-theater")
    public ResponseEntity<?> findShowTimeByShowDate(@RequestParam Integer theaterId) {
        List<ShowDate> showDateList = showDateService.findShowDateByTheaterId(theaterId);
        return new ResponseEntity<>(new CustomResponse<>(Constants.RESPONSE_STATUS_SUCCESS,showDateList), HttpStatus.CREATED);
    }

    @GetMapping(value = "/find-show-time-by-show-date")
    public ResponseEntity<?> findShowTimeByShowDate(@RequestParam Integer movieId,
                                                    @RequestParam Integer showDateId) {
        List<ShowTimeRes> showTimeList = showTimeService.findTicketByMovieIdAndShowDateIdAndShowTimeId(movieId, showDateId);
        if(showTimeList.isEmpty()) return new ResponseEntity<>(new CustomResponse<>(Constants.RESPONSE_STATUS_SUCCESS), HttpStatus.OK);
        return new ResponseEntity<>(new CustomResponse<>(Constants.RESPONSE_STATUS_SUCCESS,showTimeList), HttpStatus.CREATED);
    }
}
