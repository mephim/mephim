package com.example.mephim.service;

import com.example.mephim.entity.RoomSeat;

import java.util.List;
import java.util.Objects;

public interface RoomSeatService {
    void addRoomSeat(RoomSeat roomSeat);
    RoomSeat findById(Integer roomSeatId);
    List<RoomSeat> findRoomSeatByShowDateAndShowTime(Integer showDateId, Integer showTimeId, Integer ticketId);
}
