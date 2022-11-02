package com.example.mephim.repos;

import com.example.mephim.entity.MovieActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieActorRepo extends JpaRepository<MovieActor, Integer> {
}
