package com.example.mephim.repos;

import com.example.mephim.entity.ShowDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowDateRepo extends JpaRepository<ShowDate, Integer> {
}
