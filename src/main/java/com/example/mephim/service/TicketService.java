package com.example.mephim.service;

import com.example.mephim.entity.Ticket;
import org.springframework.data.jpa.repository.Query;

public interface TicketService {
//    @Query(value = "select * from account where username = ?", nativeQuery = true)
    Ticket findTicketByRoomId(Integer roomId);
}
