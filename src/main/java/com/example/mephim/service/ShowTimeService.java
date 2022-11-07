package com.example.mephim.service;

import com.example.mephim.entity.ShowTime;

import java.util.List;

public interface ShowTimeService {
    List<ShowTime> findShowTimeByShowDate(Integer movieId, Integer showDateId);
}
