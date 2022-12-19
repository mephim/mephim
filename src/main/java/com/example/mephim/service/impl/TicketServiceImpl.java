package com.example.mephim.service.impl;

import com.example.mephim.entity.Ticket;
import com.example.mephim.repos.TicketRepo;
import com.example.mephim.response.ShowExistResponse;
import com.example.mephim.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepo ticketRepo;

    @Override
    public List<Ticket> findAll() {
        return ticketRepo.findAll();
    }

    @Override
    public Ticket findById(Integer ticketId) {
        return ticketRepo.findById(ticketId).orElse(null);
    }

    @Override
    public Ticket findTicketByMovie(Integer movieId) {
        return ticketRepo.findTicketByMovie(movieId);
    }

    @Override
    public Ticket findTicketByShowDateAndShowTime(Integer showDateId, Integer showTimeId) {
        return ticketRepo.findTicketByShowDateAndShowTime(showDateId, showTimeId);
    }

    @Override
    public Ticket findTicketByMovieIdAndShowDateIdAndShowTimeId(Integer movieId, Integer showDateId, Integer showTimeId) {
        return ticketRepo.findTicketByMovieIdAndShowDateIdAndShowTimeId(movieId, showDateId, showTimeId);
    }

    @Override
    public List<ShowExistResponse> findListShowExistByRoomAndTime(Integer roomId, String timeStart, String timeEnd) {
        return ticketRepo.findListShowExistByRoomAndTime(roomId, timeStart, timeEnd);
    }

    public ShowExistResponse findConflictShowExist(ShowExistResponse showExistResponse, Integer movieId) {
        if (movieId.equals(showExistResponse.getMovieId())) {
            return showExistResponse;
        }
    }
}
