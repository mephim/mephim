package com.example.mephim.repos;

import com.example.mephim.entity.MovieTheater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieTheaterRepo extends JpaRepository<MovieTheater,Integer> {
}
