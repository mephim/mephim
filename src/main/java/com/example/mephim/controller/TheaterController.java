package com.example.mephim.controller;

import com.example.mephim.entity.Movie;
import com.example.mephim.entity.Theater;
import com.example.mephim.repos.TheaterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/theater")
@CrossOrigin("*")
public class TheaterController {

    @Autowired
    TheaterRepo theaterRepo;

    @GetMapping("/list-theater")
    public ResponseEntity<?> listMovie() {
        List<Theater> theaterList = theaterRepo.findAll();
        return new ResponseEntity<>(theaterList, HttpStatus.OK);
    }
}
