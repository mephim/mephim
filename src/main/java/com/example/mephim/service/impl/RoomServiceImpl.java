package com.example.mephim.service.impl;

import com.example.mephim.entity.Room;
import com.example.mephim.repos.RoomRepo;
import com.example.mephim.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepo roomRepo;

    @Override
    public Room findByRoomId(Integer roomId) {
        return roomRepo.findById(roomId).orElse(null);
    }
}
