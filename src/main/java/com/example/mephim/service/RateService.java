package com.example.mephim.service;

import com.example.mephim.entity.Rate;
import com.example.mephim.exception.NotAllowRating;
import com.example.mephim.request.RateDto;
import com.example.mephim.response.RateResponse;

import java.util.List;

public interface RateService {
    List<RateResponse> getListRateByMovie(Integer movieId);
    Rate addRate(RateDto rateDto) throws NotAllowRating;
}
