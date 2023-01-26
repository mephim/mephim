package com.example.mephim.repos;

import com.example.mephim.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepo extends JpaRepository<Actor, Integer> {
    @Query(value="select * from actor inner join movie_actor where movie_actor.movie_id = ?;", nativeQuery = true)
    List<Actor> findByMovie(Integer movieId);
}
