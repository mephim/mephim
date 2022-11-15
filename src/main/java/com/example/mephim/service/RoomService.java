package com.example.mephim.service;

import com.example.mephim.entity.Room;

public interface RoomService {
    Room findByTicketId(Integer ticketId);
    Room findByRoomId(Integer roomId);
}
