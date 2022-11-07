package com.example.mephim.service.impl;

import com.example.mephim.entity.Ticket;
import com.example.mephim.repos.TicketRepo;
import com.example.mephim.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepo ticketRepo;

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
        return ticketRepo.findTicketByShowDateAndShowTime(showDateId,showTimeId);
    }
}
