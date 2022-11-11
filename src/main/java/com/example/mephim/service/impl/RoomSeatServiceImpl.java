package com.example.mephim.service.impl;

import com.example.mephim.entity.RoomSeat;
import com.example.mephim.repos.RoomSeatRepo;
import com.example.mephim.response.RoomSeatRes;
import com.example.mephim.service.RoomSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service @Transactional
public class RoomSeatServiceImpl implements RoomSeatService {

    @Autowired
    RoomSeatRepo roomSeatRepo;

    @Override
    public void addRoomSeat(RoomSeat roomSeat) {
        roomSeatRepo.save(roomSeat);
    }

    @Override
    public RoomSeat findById(Integer roomSeatId) {
        return roomSeatRepo.findById(roomSeatId).orElse(null);
    }

    @Override
    public List<RoomSeatRes> findRoomSeatByShowDateAndShowTime(Integer showDateId, Integer showTimeId, Integer ticketId) {
        List<RoomSeat> roomSeatList = roomSeatRepo.findRoomSeatByShowDateAndShowTime(showDateId, showTimeId, ticketId);
        List<RoomSeatRes> roomSeatRes = new ArrayList<>();
        roomSeatList.forEach(roomSeat -> {
            RoomSeatRes res = new RoomSeatRes();
            res.setRoomSeatId(roomSeat.getRoomSeatId());
            res.setSeatName(roomSeat.getSeat().getSeatColumn().getColumnName() + roomSeat.getSeat().getSeatRow().getRowName());
            res.setSeatType(roomSeat.getSeatType().getSeatTypeName());

            roomSeatRes.add(res);
        });

        return roomSeatRes;
    }
}
