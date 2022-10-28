package com.example.mephim.service.impl;

import com.example.mephim.dto.BookingDto;
import com.example.mephim.dto.MovieCreateDto;
import com.example.mephim.entity.*;
import com.example.mephim.repos.BookingRepo;
import com.example.mephim.repos.MovieRepo;
import com.example.mephim.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepo bookingRepo;


    @Override
    public List<Movie> findAllBooking() {
        return null;
    }

    @Override
    public void saveBooking(BookingDto bookingDto) {
        Booking booking = new Booking();

    }
}
