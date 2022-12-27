package com.example.mephim.service.impl;

import com.example.mephim.exception.InvalidParamException;
import com.example.mephim.exception.SeatIsBookedException;
import com.example.mephim.request.BookingDto;
import com.example.mephim.entity.*;
import com.example.mephim.repos.BookingRepo;
import com.example.mephim.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.List;

@Service @Transactional
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    RoomServiceImpl roomService;

    @Autowired
    SeatService seatService;

//    @Autowired
//    UserService userService;

//    @Autowired
//    RoomSeatService roomSeatService;

    @Autowired
    TicketService ticketService;

    @Override
    public List<Movie> findAllBooking() {
        return null;
    }

    @Override
    public Booking findBookingByRoomSeatAndTicket(Integer roomSeatId, Integer ticketId) {
        return bookingRepo.findBookingByRoomSeatAndTicket(roomSeatId, ticketId);
    }

    @Override
    public Integer saveBooking(BookingDto bookingDto) throws InvalidParamException, SeatIsBookedException {
        Booking bookedBySeat = findBookingByRoomSeatAndTicket(bookingDto.getSeatId(), bookingDto.getTicketId());
        if(bookedBySeat != null) throw new SeatIsBookedException();

//        User user = userService.findByUsername(bookingDto.getUser());
//        if(user == null) throw new InvalidParamException();

        Seat seat = seatService.findSeatByTicketIdAndSeatId(bookingDto.getTicketId(), bookingDto.getSeatId());
        if(seat == null) throw new InvalidParamException();

        Ticket ticket = ticketService.findById(bookingDto.getTicketId());
        if(ticket == null) throw new InvalidParamException();


        Booking booking = new Booking();
//        booking.setUser(user);
        booking.setSeat(seat);
        booking.setTicket(ticket);
        booking.setBookingStatus(new BookingStatus(1));
        booking.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));

        Booking bookingSaved = bookingRepo.save(booking);
        return bookingSaved.getBookingId();
    }
}
