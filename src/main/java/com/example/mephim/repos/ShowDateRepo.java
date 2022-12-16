package com.example.mephim.repos;

import com.example.mephim.entity.ShowDate;
import com.example.mephim.entity.ShowTime;
import com.example.mephim.response.ShowResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowDateRepo extends JpaRepository<ShowDate, Integer> {
    @Query(value = "select show_date.* from show_date \n" +
            "inner join ticket \n" +
            "inner join movie \n" +
            "where show_date.show_date_id = ticket.show_date_id \n" +
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

    @Query(value = "select show_date.date, show_time.time, movie.movie_length, movie.movie_name, room.room_name from show_date inner join show_time inner join movie inner join ticket inner join room_ticket inner join room\n" +
            "where show_date.show_date_id = ticket.show_date_id\n" +
            "and show_time.show_time_id = ticket.show_time_id\n" +
            "and room_ticket.ticket_id = ticket.ticket_id\n" +
            "and room_ticket.room_id = room.room_id\n" +
            "and movie.movie_id = ticket.movie_id", nativeQuery = true)
    List<ShowResponse> adminFindAllShow();
}
