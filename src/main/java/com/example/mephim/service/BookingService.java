package com.example.mephim.service;

import com.example.mephim.request.BookingDto;
import com.example.mephim.entity.Movie;

import java.util.List;

public interface BookingService {
    List<Movie> findAllBooking();
    void saveBooking(BookingDto bookingDto);
}
