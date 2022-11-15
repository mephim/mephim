package com.example.mephim.service;

import com.example.mephim.entity.ShowDate;

import java.util.List;

public interface ShowDateService {
    List<ShowDate> findAll();
    List<ShowDate> findShowDateByTheaterId(Integer theaterId);
    List<ShowDate> findShowDateByMovieId(Integer movieId);
    ShowDate findShowDateById(Integer showDateId);
}
