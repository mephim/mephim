package com.example.mephim.service.impl;

import com.example.mephim.entity.Actor;
import com.example.mephim.repos.ActorRepo;
import com.example.mephim.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    ActorRepo actorRepo;

    @Override
    public List<Actor> findAll() {
        return actorRepo.findAll();
    }

    @Override
    public List<Actor> findByMovie(Integer movieId) {
        return actorRepo.findByMovie(movieId);
    }
}
