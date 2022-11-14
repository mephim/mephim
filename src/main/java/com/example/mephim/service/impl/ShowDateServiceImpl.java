package com.example.mephim.service.impl;

import com.example.mephim.entity.ShowDate;
import com.example.mephim.repos.ShowDateRepo;
import com.example.mephim.service.ShowDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowDateServiceImpl implements ShowDateService {

    @Autowired
    ShowDateRepo showDateRepo;

    @Override
    public List<ShowDate> findShowDateByMovieId(Integer movieId) {
        return showDateRepo.findShowDateByMovieId(movieId);
    }

    @Override
    public ShowDate findShowDateById(Integer showDateId) {
        return showDateRepo.findById(showDateId).orElse(null);
    }
}
