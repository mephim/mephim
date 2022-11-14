package com.example.mephim.service;

import com.example.mephim.entity.ShowDate;

import java.util.List;

public interface ShowDateService {
    List<ShowDate> findShowDateByMovieId(Integer movieId);
    ShowDate findShowDateById(Integer showDateId);
}
