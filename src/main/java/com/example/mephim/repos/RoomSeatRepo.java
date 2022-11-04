package com.example.mephim.repos;

import com.example.mephim.entity.Booking;
import com.example.mephim.entity.RoomSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomSeatRepo extends JpaRepository<RoomSeat, Integer> {
    @Query(value = "select booking.* from booking " +
            "inner join ticket " +
            "inner join booking_status " +
            "where ticket.ticket_id = booking.ticket_id " +
            "and booking_status.booking_status_id=1 " +
            "and booking.ticket_id=?", nativeQuery = true)
    Booking findByTicketId(Integer ticketId);

}
