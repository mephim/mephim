package com.example.mephim.service.impl;

import com.example.mephim.entity.Account;
import com.example.mephim.repos.AccountRepo;
import com.example.mephim.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepo accountRepo;
    @Override
    public Account findByUsername(String username) {
        return accountRepo.findByUsername(username);
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public Account findByVerificationCode(String verifyCode) {
        return accountRepo.findByVerificationCode(verifyCode);
    }

    @Override
    public Boolean activeAccount(String username) {
        return accountRepo.activeAccount(username) > 0;
    }

    @Override
    public Boolean deleteVerificationCode(String username) {
        return accountRepo.deleteVerificationCode(username) > 0;
    }
}
