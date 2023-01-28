package com.example.mephim.service.impl;

import com.example.mephim.entity.Room;
import com.example.mephim.repos.RoomRepo;
import com.example.mephim.response.RoomSeatRes;
import com.example.mephim.response.RoomStruct;
import com.example.mephim.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepo roomRepo;

    @Override
    public List<Room> findAll() {
        return roomRepo.findAll();
    }

    @Override
    public Room findByTicketId(Integer ticketId) {
        return roomRepo.findByTicketId(ticketId);
    }

    @Override
    public Room findByRoomId(Integer roomId) {
        return roomRepo.findById(roomId).orElse(null);
    }

    @Override
    public List<RoomSeatRes> findRoomSeatByShowDateAndShowTimeTicket(Integer showDateId, Integer showTimeId, Integer ticketId) {
        return roomRepo.findRoomSeatByShowDateAndShowTimeTicket(showDateId, showTimeId, ticketId);
    }

    @Override
    public RoomStruct getRoomStruct(Integer roomId) {
        return roomRepo.getRoomStruct(roomId);
    }
}
