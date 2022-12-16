package com.example.mephim.response;

import org.springframework.beans.factory.annotation.Value;

public interface ShowResponse {
    @Value("#{target.date}")
    String getDate();
    @Value("#{target.time}")
    String getTime();
    @Value("#{target.movie_length}")
    Integer getMovieLength();
    @Value("#{target.room_name}")
    String getRoomName();
    @Value("#{target.movie_name}")
    String getMovieName();
}