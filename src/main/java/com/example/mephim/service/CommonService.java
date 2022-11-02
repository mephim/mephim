package com.example.mephim.service;

import com.example.mephim.entity.*;
import com.example.mephim.exception.InvalidParamException;
import com.example.mephim.repos.MovieTheaterRepo;

public interface CommonService {
    void initialSeatColumn(SeatColumn seatColumn);
    void initialSeatRow(SeatRow seatRow);
    void initialSeatType(SeatType seatType);
    void initialShowDate(ShowDate showDate);
    void initialShowTime(ShowTime showTime);
    void initialCategory(Category category);
    void initialActor(Actor actor);
    void initialRoom(Room room);
    void initialTheaterGroup(TheaterGroup theaterGroup);

    ShowDate findShowDateById(Integer id);
    ShowTime findShowTimeById(Integer id);
    Actor findActorById(Integer id);
    Category findCategoryById(Integer id);
    MovieTheater findMovieTheaterById(Integer id);
}
