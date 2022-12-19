package com.example.mephim.service;

import com.example.mephim.entity.Ticket;
import com.example.mephim.response.ShowExistResponse;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketService {
    List<Ticket> findAll();
    Ticket findById(Integer ticketId);
    Ticket findTicketByMovie(Integer movieId);
    Ticket findTicketByShowDateAndShowTime(Integer showDateId, Integer showTimeId);
    Ticket findTicketByMovieIdAndShowDateIdAndShowTimeId(Integer movieId, Integer showDateId, Integer showTimeId);
    List<ShowExistResponse> findListShowExistByRoomAndTime(Integer roomId, String timeStart, String timeEnd);

}
