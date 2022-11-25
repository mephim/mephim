package com.example.mephim.repos;

import com.example.mephim.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, String> {
    @Query(value = "select * from account where username = ?", nativeQuery = true)
    Account findByUsername(String username);
    @Query(value = "select * from account where verification_code = ?", nativeQuery = true)
    Account findByVerificationCode(String verifyCode);
    @Modifying
    @Query(value = "update account set is_enable = true where username = ?", nativeQuery = true)
    Integer activeAccount(String username);
    @Modifying
    @Query(value = "update account set verification_code = null where username = ?", nativeQuery = true)
    Integer deleteVerificationCode(String username);
}
