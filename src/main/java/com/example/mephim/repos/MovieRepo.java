package com.example.mephim.repos;

import com.example.mephim.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {
//    @Query(value="select movie_id, movie_description, movie_length, movie_name, movie_poster, movie_trailer_url from movie",nativeQuery = true)
    List<Movie> findAll();
//    void saveMovie(Movie movie);


    List<Movie> findByShowDate(Integer showDateId);
}
