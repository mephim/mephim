package com.example.mephim.repos;

import com.example.mephim.entity.RoomTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTicketRepo extends JpaRepository<RoomTicket, Integer> {
    @Query(value = "select * from room_ticket where room_ticket.ticket_id = ?;", nativeQuery = true)
    RoomTicket findByTicketId(Integer ticketId);
}
