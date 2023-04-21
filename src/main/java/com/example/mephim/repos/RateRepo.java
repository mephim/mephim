package com.example.mephim.repos;

import com.example.mephim.entity.Rate;
import com.example.mephim.response.RateResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateRepo extends JpaRepository<Rate,Integer> {
    @Query(value = "select users.username, rate.num_rate, rate.content, rate.is_liked \n" +
            "from rate inner join users \n" +
            "where users.id = rate.user_id\n" +
            "and rate.movie_id = ?;", nativeQuery = true)
    List<RateResponse> listRateFromMovie(Integer movieId);

    @Query(value = "select rate.* from rate inner join users inner join movie where \n" +
            "users.id = rate.user_id\n" +
            "and movie.movie_id = rate.rate_id\n" +
            "and movie.movie_id = ? and users.username=?", nativeQuery = true)
    List<Rate> findRateByUserAndMovie(String username, Integer movieId);
}
