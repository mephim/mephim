package com.example.mephim.service.impl;

import com.example.mephim.repos.RoomRepo;
import com.example.mephim.repos.UserRepo;
import com.example.mephim.request.BookingDto;
import com.example.mephim.entity.*;
import com.example.mephim.repos.BookingRepo;
import com.example.mephim.service.BookingService;
import com.example.mephim.service.SeatService;
import com.example.mephim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    RoomServiceImpl roomService;

    @Autowired
    SeatService seatService;

    @Autowired
    UserService userService;


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
//        seat.setSeatType(new SeatType(bookingDto.getSeatTypeId(), null, null));
        seatService.addSeat(seat);
//        booking.setSeat(seat);
        booking.setTicket(new Ticket(bookingDto.getTicketId()));
//        booking.setRoom(room);
        booking.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));
        User user = userService.findByUsername(bookingDto.getUser());
        booking.setUser(user);
        bookingRepo.save(booking);
    }
}
