package com.example.mephim.repos;

import com.example.mephim.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, String> {
    @Query(value = "select * from account where username = ?", nativeQuery = true)
    Account findByUsername(String username);
}
