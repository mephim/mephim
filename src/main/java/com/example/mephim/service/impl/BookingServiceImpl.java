package com.example.mephim.service.impl;

import com.example.mephim.repos.RoomRepo;
import com.example.mephim.request.BookingDto;
import com.example.mephim.entity.*;
import com.example.mephim.repos.BookingRepo;
import com.example.mephim.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    RoomServiceImpl roomService;


    @Override
    public List<Movie> findAllBooking() {
        return null;
    }

    @Override
    public void saveBooking(BookingDto bookingDto) {
        Booking booking = new Booking();
        Room room = roomService.findByRoomId(bookingDto.getRoomId());
        Seat seat = new Seat();
        seat.setSeatRow(new SeatRow(bookingDto.getSeatRowId(), null, null));
        seat.setSeatColumn(new SeatColumn(bookingDto.getSeatColumnId(), null, null));
        seat.setSeatType(new SeatType(bookingDto.getSeatTypeId(), null, null));
        booking.setSeat(seat);
        booking.setTicket(new Ticket(bookingDto.getTicketId()));
    }
}
