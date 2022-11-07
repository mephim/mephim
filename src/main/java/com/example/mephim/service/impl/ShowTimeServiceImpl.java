package com.example.mephim.service.impl;

import com.example.mephim.entity.ShowTime;
import com.example.mephim.repos.ShowTimeRepo;
import com.example.mephim.service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowTimeServiceImpl implements ShowTimeService {

    @Autowired
    ShowTimeRepo showTimeRepo;

    @Override
    public List<ShowTime> findShowTimeByShowDate(Integer movieId, Integer showDateId) {
        return showTimeRepo.findShowTimeByShowDate(movieId,showDateId);
    }
}
