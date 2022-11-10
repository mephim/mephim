package com.example.mephim.controller;

import com.example.mephim.entity.RoomSeat;
import com.example.mephim.repos.RoomSeatRepo;
import com.example.mephim.request.BookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/seat")
public class RoomSeatController{

    @Autowired
    RoomSeatRepo roomSeatRepo;

    @PostMapping("/find")
    public ResponseEntity<?> addBooking(@RequestParam(name = "showDateId") Integer showDateId,
                                        @RequestParam(name = "showTimeId") Integer showTimeId,
                                        @RequestParam(name = "ticketId") Integer ticketId) {

        List<RoomSeat> roomSeat = roomSeatRepo.findRoomSeatByShowDateAndShowTime(showDateId,showTimeId,ticketId);

        return new ResponseEntity<>(roomSeat, HttpStatus.OK);

    }

}
