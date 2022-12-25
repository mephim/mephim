package com.example.mephim.repos;

import com.example.mephim.entity.Room;
import com.example.mephim.response.RoomSeatRes;
import com.example.mephim.response.RoomStruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<Room, Integer> {
    @Query(value = "SELECT * FROM room WHERE room_seart.room_id = ?1", nativeQuery = true)
    Room findByRoomSeat(Integer roomSeat);

    @Query(value = "select distinct room.* from room inner join room_ticket inner join ticket\n" +
            "where room.room_id = room_ticket.room_id\n" +
            "and ticket.active=1\n" +
            "and room_ticket.ticket_id = ?;", nativeQuery = true)
    Room findByTicketId(Integer ticketId);

    @Query(value="call findSeatWithTicket(?,?,?);", nativeQuery = true)
    List<RoomSeatRes> findRoomSeatByShowDateAndShowTimeTicket(Integer showDateId, Integer showTimeId, Integer ticketId);

    @Query(value = "select * from room where room.room_id = ?;", nativeQuery = true)
    RoomStruct getRoomStruct(Integer roomId);
}
