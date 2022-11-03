package com.example.mephim.controller;

import com.example.mephim.constants.Constants;
import com.example.mephim.exception.InvalidParamException;
import com.example.mephim.request.BookingDto;
import com.example.mephim.response.CustomResponse;
import com.example.mephim.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping("/addNew")
    public ResponseEntity<?> addBooking(@RequestBody BookingDto bookingDto) {
            bookingService.saveBooking(bookingDto);
        return new ResponseEntity<>(new CustomResponse(Constants.RESPONSE_STATUS_SUCCESS), HttpStatus.CREATED);
    }
}