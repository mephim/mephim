package com.example.mephim.service.impl;

import com.example.mephim.repos.StatisRepo;
import com.example.mephim.response.IMovieStatisResponse;
import com.example.mephim.response.ITransStatisResponse;
import com.example.mephim.service.StatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisServiceImpl implements StatisService {
    @Autowired
    StatisRepo statisRepo;
    @Override
    public List<ITransStatisResponse> getStatisTransactionByMonthAgo(Integer numMonth) {
        return statisRepo.getStatisTransactionByMonthAgo(numMonth);
    }

    @Override
    public List<ITransStatisResponse> getStatisTransactionByDayAgo(Integer numDay) {
        return statisRepo.getStatisTransactionByDayAgo(numDay);
    }

    @Override
    public List<IMovieStatisResponse> getMovieTransactionBy1WeeksAgo() {
        return statisRepo.getMovieTransactionBy1WeeksAgo();
    }
}
