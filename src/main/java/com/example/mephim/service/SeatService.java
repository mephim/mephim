package com.example.mephim.service;

import com.example.mephim.entity.Seat;

public interface SeatService {
    void save(Seat seat);
    Seat findById(Integer seatId);
    Seat findSeatByTicketIdAndSeatId(Integer ticketId, Integer seatId);
}
