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
            "and movie.movie_id = ?", nativeQuery = true)
    List<ShowDate> findShowDateByMovieId(Integer movieId);
}
