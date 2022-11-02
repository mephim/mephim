package com.example.mephim.service.impl;

import com.example.mephim.entity.MovieActor;
import com.example.mephim.repos.MovieActorRepo;
import com.example.mephim.service.MovieActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class MovieActorImpl implements MovieActorService {
    @Autowired
    MovieActorRepo movieActorRepo;

    @Override
    public void save(MovieActor movieActor) {
        movieActorRepo.save(movieActor);
    }


}
