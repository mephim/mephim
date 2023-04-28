package com.example.mephim.service;

import com.example.mephim.response.IMovieStatisResponse;
import com.example.mephim.response.ITransStatisResponse;

import java.util.List;

public interface StatisService {
    List<ITransStatisResponse> getStatisTransactionByMonthAgo(Integer numMonth);
    List<ITransStatisResponse> getStatisTransactionByDayAgo(Integer numDay);
    List<IMovieStatisResponse> getMovieTransactionBy1WeeksAgo();
}
