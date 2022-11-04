package com.example.mephim.repos;

import com.example.mephim.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {
    @Query(value = "select booking.* from booking inner join ticket where booking.ticket_id = ticket.ticket_id and booking.room_seat_id = ? and booking.ticket_id = ?;", nativeQuery = true)
    Booking findBookingByRoomSeatAndTicket(Integer roomSeatId, Integer ticketId);
}
