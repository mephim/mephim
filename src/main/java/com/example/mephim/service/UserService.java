package com.example.mephim.service;

import com.example.mephim.entity.User;

public interface UserService {
    User findByUsername(String username);
    User createNewUser(User user);
}
