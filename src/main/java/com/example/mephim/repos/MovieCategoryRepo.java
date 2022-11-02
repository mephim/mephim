package com.example.mephim.repos;

import com.example.mephim.entity.MovieCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCategoryRepo extends JpaRepository<MovieCategory, Integer> {
}
