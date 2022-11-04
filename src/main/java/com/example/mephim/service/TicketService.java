package com.example.mephim.service;

import com.example.mephim.entity.Ticket;
import org.springframework.data.jpa.repository.Query;

public interface TicketService {
    Ticket findById(Integer ticketId);
}
