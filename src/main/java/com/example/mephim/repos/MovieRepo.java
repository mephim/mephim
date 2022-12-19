package com.example.mephim.repos;

import com.example.mephim.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {

    Movie findMovieByMovieId(Integer movieId);

//    @Query(value="select movie_id, movie_description, movie_length, movie_name, movie_poster, movie_trailer_url from movie",nativeQuery = true)
    List<Movie> findAll();
    @Query(value = "select distinct movie.* from movie inner join ticket where movie.movie_id = ticket.movie_id and ticket.active = 1;", nativeQuery = true)
    List<Movie> findMovieHasTicket();
//    void saveMovie(Movie movie);
    @Query(value="select distinct movie.* from movie inner join ticket inner join show_date\n" +
            "where movie.movie_id = ticket.movie_id\n" +
            "and ticket.show_date_id = show_date.show_date_id\n" +
            "and show_date.show_date_id = ?\n" +
            "and ticket.active = 1",nativeQuery = true)
    List<Movie> getMovieByShowDate(Integer showDateId);

    @Query(value = "select distinct * from movie inner join movie_theater where movie.movie_id = movie_theater.movie_id\n" +
            "and movie_theater.theater_id = 1", nativeQuery = true)
    List<Movie> findMovieByTheaterId(Integer theaterId);
}
