package com.example.mephim.service.impl;

import com.example.mephim.entity.RoomSeat;
import com.example.mephim.repos.RoomSeatRepo;
import com.example.mephim.response.RoomSeatRes;
import com.example.mephim.service.RoomSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public List<RoomSeatRes> findRoomSeatByShowDateAndShowTimeTicket(Integer showDateId, Integer showTimeId, Integer ticketId) {
        List<RoomSeat> roomSeatListIsEmpty = roomSeatRepo.findRoomSeatIsEmptyByShowDateAndShowTimeTicket(showDateId, showTimeId, ticketId);
        List<RoomSeat> roomSeatListIsBooking = roomSeatRepo.findRoomSeatIsBookingByShowDateAndShowTimeTicket(showDateId, showTimeId, ticketId);

        List<RoomSeatRes> roomSeatRes = new ArrayList<>();
        roomSeatListIsEmpty.forEach(roomSeat -> {
            RoomSeatRes res = new RoomSeatRes();
            res.setRoomSeatId(roomSeat.getRoomSeatId());
            res.setSeatName(roomSeat.getSeat().getSeatColumn().getColumnName() + roomSeat.getSeat().getSeatRow().getRowName());
            res.setSeatType(roomSeat.getSeatType().getSeatTypeName());
            res.setIsBooking(false);
            roomSeatRes.add(res);
        });

        roomSeatListIsBooking.forEach(roomSeat -> {
            RoomSeatRes res = new RoomSeatRes();
            res.setRoomSeatId(roomSeat.getRoomSeatId());
            res.setSeatName(roomSeat.getSeat().getSeatColumn().getColumnName() + roomSeat.getSeat().getSeatRow().getRowName());
            res.setSeatType(roomSeat.getSeatType().getSeatTypeName());
            res.setIsBooking(true);
            roomSeatRes.add(res);
        });


        Collections.sort(roomSeatRes);


        return roomSeatRes;
    }
}
