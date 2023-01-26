package com.example.mephim.service;

import com.example.mephim.entity.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> findAll();
    List<Actor> findByMovie(Integer movieId);
}
