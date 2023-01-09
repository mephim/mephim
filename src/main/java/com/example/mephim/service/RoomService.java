package com.example.mephim.service;

import com.example.mephim.entity.Room;
import com.example.mephim.response.RoomSeatRes;
import com.example.mephim.response.RoomStruct;

import java.util.List;

public interface RoomService {
    List<Room> findAll();
    Room findByTicketId(Integer ticketId);
    Room findByRoomId(Integer roomId);
    List<RoomSeatRes> findRoomSeatByShowDateAndShowTimeTicket(Integer showDateId, Integer showTimeId, Integer ticketId);
    RoomStruct getRoomStruct(Integer roomId);
}
