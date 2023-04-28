package com.example.mephim.controller;

import com.example.mephim.repos.StatisRepo;
import com.example.mephim.response.CustomResponse;
import com.example.mephim.response.IMovieStatisResponse;
import com.example.mephim.response.ITransStatisResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statis")
@CrossOrigin("*")
public class StatisticalController {
    @Autowired
    StatisRepo statisRepo;

    @GetMapping("/get-transaction-by-month")
    public ResponseEntity<?> getStatisTransactionByMonthAgo(@RequestParam(defaultValue = "1") Integer numMonth) {
        List<ITransStatisResponse> transactionList = statisRepo.getStatisTransactionByMonthAgo(numMonth);
        return new ResponseEntity<>(new CustomResponse<>(1,transactionList), HttpStatus.OK);
    }

    @GetMapping("/get-transaction-by-day")
    public ResponseEntity<?> getStatisTransactionByDayAgo(@RequestParam(defaultValue = "1") Integer numDay) {
        List<ITransStatisResponse> transactionList = statisRepo.getStatisTransactionByDayAgo(numDay);
        return new ResponseEntity<>(new CustomResponse<>(1,transactionList), HttpStatus.OK);
    }

    @GetMapping("/get-movie-by-month")
    public ResponseEntity<?> getStatisTransactionBy1WeeksAgo() {
        List<IMovieStatisResponse> transactionList = statisRepo.getMovieTransactionBy1WeeksAgo();
        return new ResponseEntity<>(new CustomResponse<>(1,transactionList), HttpStatus.OK);
    }
}
