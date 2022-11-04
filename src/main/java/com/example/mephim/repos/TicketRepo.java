package com.example.mephim.repos;

import com.example.mephim.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {
    @Query(value = "select * from ticket where roomId = ?", nativeQuery = true)
    Ticket findTicketByRoomId(Integer roomId);
}
