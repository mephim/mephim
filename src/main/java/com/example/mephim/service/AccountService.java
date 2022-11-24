package com.example.mephim.service;

import com.example.mephim.entity.Account;

public interface AccountService {
    Account findByUsername(String username);
    Account createAccount(Account account);
}
