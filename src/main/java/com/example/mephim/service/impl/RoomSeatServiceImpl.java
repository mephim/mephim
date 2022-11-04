package com.example.mephim.service.impl;

import com.example.mephim.entity.RoomSeat;
import com.example.mephim.repos.RoomSeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomSeatServiceImpl implements RoomSeatService{

    @Autowired
    RoomSeatRepo roomSeatRepo;

    @Override
    public void addRoomSeat(RoomSeat roomSeat) {
        roomSeatRepo.save(roomSeat);
    }
}
