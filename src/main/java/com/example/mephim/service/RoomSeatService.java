package com.example.mephim.service;

import com.example.mephim.entity.RoomSeat;

public interface RoomSeatService {
    void addRoomSeat(RoomSeat roomSeat);
    RoomSeat findById(Integer roomSeatId);
}
