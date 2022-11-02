package com.example.mephim.repos;

import com.example.mephim.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM `user` WHERE username = ?1", nativeQuery = true)
    User findByUsername(String username);
}
