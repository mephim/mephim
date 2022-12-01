package com.example.mephim.repos;

import com.example.mephim.entity.ShowDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowDateRepo extends JpaRepository<ShowDate, Integer> {
    @Query(value = "select show_date.* from show_date \n" +
            "inner join ticket \n" +
            "inner join movie \n" +
            "where show_date.show_date_id = ticket.ticket_id \n" +
            "and movie.movie_id = ticket.movie_id\n" +
            "and movie.movie_id = ?\n" +
            "and ticket.active = 1", nativeQuery = true)
    List<ShowDate> findShowDateByMovieId(Integer movieId);
    @Query(value = "select distinct show_date.* from show_date inner join ticket inner join movie inner join movie_theater\n" +
            "where show_date.show_date_id = ticket.show_date_id\n" +
            "and movie.movie_id = ticket.movie_id\n" +
            "and movie_theater.movie_id = movie.movie_id\n" +
            "and ticket.active = 1\n" +
            "and movie_theater.theater_id = ?;", nativeQuery = true)
    List<ShowDate> findShowDateByTheaterId(Integer theaterId);
}
