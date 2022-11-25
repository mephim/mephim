package com.example.mephim.service;

import com.example.mephim.entity.Account;

public interface AccountService {
    Account findByUsername(String username);
    Account createAccount(Account account);
    Account findByVerificationCode(String verifyCode);
    Boolean activeAccount(String username);
    Boolean deleteVerificationCode(String username);
}
