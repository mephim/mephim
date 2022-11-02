package com.example.mephim.repos;

import com.example.mephim.entity.TheaterGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterGroupRepo extends JpaRepository<TheaterGroup, Integer> {
}
