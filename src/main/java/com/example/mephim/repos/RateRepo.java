package com.example.mephim.repos;

import com.example.mephim.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepo extends JpaRepository<Rate,Integer> {

}
