package com.example.mephim.service;

import com.example.mephim.entity.User;
import com.example.mephim.response.UserResponse;

import java.util.List;

public interface UserService {
    User findByUsername(String username);
    User createNewUser(User user);
    List<UserResponse> findAllUser();
    Boolean addPoint(Integer point, String email);
    Boolean setVisible(Boolean isEnable, String email, String reason);
}
