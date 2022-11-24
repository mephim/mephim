package com.example.mephim.service.impl;

import com.example.mephim.entity.User;
import com.example.mephim.repos.UserRepo;
import com.example.mephim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Override
    public User findByUsername(String username) {
        User user = userRepo.findByUsername(username);
        System.out.println("---User find by username: "+ user);
        return user;
    }

    @Override
    public User createNewUser(User user) {
        return userRepo.save(user);
    }
}
