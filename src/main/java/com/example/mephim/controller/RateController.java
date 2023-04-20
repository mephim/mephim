package com.example.mephim.controller;

import com.example.mephim.exception.NotAllowRating;
import com.example.mephim.request.RateDto;
import com.example.mephim.response.CustomResponse;
import com.example.mephim.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rate")
@CrossOrigin("*")
public class RateController {
    @Autowired
    RateService rateService;

    @PostMapping("/add")
    public ResponseEntity<?> addRate(@RequestBody RateDto rateDto) throws NotAllowRating {
        rateService.addRate(rateDto);
        return new ResponseEntity<>(new CustomResponse<>(1, rateDto), HttpStatus.OK);
    }
}
