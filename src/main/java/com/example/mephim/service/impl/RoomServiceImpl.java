package com.example.mephim.service.impl;

import com.example.mephim.entity.*;
import com.example.mephim.repos.RoomRepo;
import com.example.mephim.request.AddRoomDto;
import com.example.mephim.response.RoomSeatRes;
import com.example.mephim.response.RoomStruct;
import com.example.mephim.service.RoomService;
import com.example.mephim.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepo roomRepo;

    @Autowired
    SeatService seatService;

    @Transactional
    @Override
    public Room save(AddRoomDto roomDto) {
        Room room = new Room();
        room.setRoomName(roomDto.getRoomName());
        room.setTotalRow(roomDto.getHeight());
        room.setTotalColumn(roomDto.getWidth());
        room.setIsEnable(true);

        Room savedRoom = roomRepo.save(room);
        saveSeatForRoom(room.getRoomId(), savedRoom.getTotalColumn(), savedRoom.getTotalRow(), roomDto.getRowVIP());
        return savedRoom;
    }

    void saveSeatForRoom(int roomId, int width, int height, List<Integer> rowVIP) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                Seat seat;
                if (rowVIP.contains(i)) {
                    seat = new Seat(new Room(roomId), new SeatColumn(i), new SeatRow(j), new SeatType(2));

                } else {
                    seat = new Seat(new Room(roomId), new SeatColumn(i), new SeatRow(j), new SeatType(1));

                }
                seatService.save(seat);
            }
        }
    }

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
