package com.example.mephim.repos;

import com.example.mephim.entity.Booking;
import com.example.mephim.entity.RoomSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface RoomSeatRepo extends JpaRepository<RoomSeat, Integer> {
    @Query(value = "select booking.* from booking " +
            "inner join ticket " +
            "inner join booking_status " +
            "where ticket.ticket_id = booking.ticket_id " +
            "and booking_status.booking_status_id=1 " +
            "and booking.ticket_id=?", nativeQuery = true)
    RoomSeat findByTicketId(Integer ticketId);

    @Query(value="-- find movie by showdate id\n" +
            "select room_seat.* from room_seat inner join room inner join ticket inner join room_ticket left join booking\n" +
            "on booking.room_seat_id = room_seat.room_seat_id\n" +
            "where room_seat.room_id = room.room_id\n" +
            "and room.room_id = room_ticket.room_id\n" +
            "and ticket.ticket_id = room_ticket.ticket_id\n" +
            "-- and booking.booking_id is null\n" +
            "and ticket.show_date_id = ?\n" +
            "and ticket.show_time_id = ?\n" +
            "-- and room_ticket.active = 1\n" +
            "and room_ticket.ticket_id = ?", nativeQuery = true)
    List<RoomSeat> findRoomSeatByShowDateAndShowTime(Integer showDateId, Integer showTimeId, Integer ticketId);
}
