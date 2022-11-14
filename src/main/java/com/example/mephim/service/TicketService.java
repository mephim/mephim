package com.example.mephim.service;

import com.example.mephim.entity.Ticket;
import org.springframework.data.jpa.repository.Query;

public interface TicketService {
    Ticket findById(Integer ticketId);
    Ticket findTicketByMovie(Integer movieId);
    Ticket findTicketByShowDateAndShowTime(Integer showDateId, Integer showTimeId);
    Ticket findTicketByMovieIdAndShowDateIdAndShowTimeId(Integer movieId, Integer showDateId, Integer showTimeId);

}
