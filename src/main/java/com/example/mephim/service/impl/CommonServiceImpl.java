package com.example.mephim.service.impl;

import com.example.mephim.entity.*;
import com.example.mephim.exception.InvalidParamException;
import com.example.mephim.repos.*;
import com.example.mephim.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional @Slf4j
public class CommonServiceImpl implements CommonService {

    @Autowired
    SeatRepo seatRepo;

    @Autowired
    SeatTypeRepo seatTypeRepo;

    @Autowired
    SeatColumnRepo seatColumnRepo;

    @Autowired
    SeatRowRepo seatRowRepo;

    @Autowired
    ShowDateRepo showDateRepo;

    @Autowired
    ShowTimeRepo showTimeRepo;

    @Autowired
    ActorRepo actorRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    RoomRepo roomRepo;

    @Autowired
    TheaterGroupRepo theaterGroupRepo;

    @Autowired
    MovieTheaterRepo movieTheaterRepo;

    @Override
    public void initialSeatColumn(SeatColumn seatColumn) {
        log.info("Saves seat column to the database: " + seatColumn.getColumnName());
        seatColumnRepo.save(seatColumn);
    }

    @Override
    public void initialSeatRow(SeatRow seatRow) {
        log.info("Saves seat row to the database: " + seatRow.getRowName());
        seatRowRepo.save(seatRow);
    }

    @Override
    public void initialSeatType(SeatType seatType) {
        log.info("Saves seat type to the database: " + seatType.getSeatTypeName());
        seatTypeRepo.save(seatType);
    }

    @Override
    public void initialShowDate(ShowDate showDate) {
        log.info("Saves showDate to the database: " + showDate.getDate());
        showDateRepo.save(showDate);
    }

    @Override
    public void initialShowTime(ShowTime showTime) {
        log.info("Saves showTime to the database: " + showTime.getTime());
        showTimeRepo.save(showTime);
    }

    @Override
    public void initialCategory(Category category) {
        log.info("Saves category to the database: " + category.getCategoryName());
        categoryRepo.save(category);
    }

    @Override
    public void initialActor(Actor actor) {
        log.info("Saves actor to the database: " + actor.getActorName());
        actorRepo.save(actor);
    }

    @Override
    public void initialRoom(Room room) {
        log.info("Saves room to the database: " + room.getRoomName());
        roomRepo.save(room);
    }

    @Override
    public void initialTheaterGroup(TheaterGroup theaterGroup) {
        log.info("Saves theaterGroup to the database: " + theaterGroup.getTheaterName());
        theaterGroupRepo.save(theaterGroup);
    }

    @Override
    public ShowDate findShowDateById(Integer id) {
        return showDateRepo.findById(id).orElse(null);
    }

    @Override
    public ShowTime findShowTimeById(Integer id) {
        return showTimeRepo.findById(id).orElse(null);
    }

    @Override
    public Actor findActorById(Integer id) {
        return actorRepo.findById(id).orElse(null);
    }

    @Override
    public Category findCategoryById(Integer id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public MovieTheater findMovieTheaterById(Integer id) {
        return movieTheaterRepo.findById(id).orElse(null);
    }
}
