package com.example.mephim.controller;

import com.example.mephim.constants.Constants;
import com.example.mephim.entity.Booking;
import com.example.mephim.exception.InvalidParamException;
import com.example.mephim.exception.SeatIsBookedException;
import com.example.mephim.request.BookingDto;
import com.example.mephim.response.CustomResponse;
import com.example.mephim.service.BookingService;
import org.json.simple.JSONObject;
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
        Integer bookingSaved;
        try {
            bookingSaved = bookingService.saveBooking(bookingDto);
        } catch (InvalidParamException | SeatIsBookedException e) {
            return new ResponseEntity<>(new CustomResponse<Booking>(e.getMessage()), HttpStatus.EXPECTATION_FAILED);
        }
        JSONObject dataResponseJson=new JSONObject();
        dataResponseJson.put("bookingId", bookingSaved);
        return new ResponseEntity<>(new CustomResponse<>(Constants.RESPONSE_STATUS_SUCCESS, dataResponseJson), HttpStatus.CREATED);
    }
}