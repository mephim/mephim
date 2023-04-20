package com.example.mephim.service;

import com.example.mephim.entity.Rate;
import com.example.mephim.exception.NotAllowRating;
import com.example.mephim.request.RateDto;

public interface RateService {
    Rate addRate(RateDto rateDto) throws NotAllowRating;
}
