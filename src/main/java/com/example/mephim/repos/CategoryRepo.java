package com.example.mephim.repos;

import com.example.mephim.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    @Query(value="select * from category inner join movie_category where movie_category.movie_id = ?;", nativeQuery = true)
    List<Category> findByMovie(Integer movieId);
}
