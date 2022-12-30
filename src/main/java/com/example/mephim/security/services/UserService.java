package com.example.mephim.security.services;

import com.example.mephim.entity.User;
import com.example.mephim.exception.EmailDuplicateException;
import com.example.mephim.exception.UsernameDuplicateException;
import com.example.mephim.payload.request.SignupRequest;

public interface UserService {
    void signUp(SignupRequest signupRequest) throws UsernameDuplicateException, EmailDuplicateException;
    User findByVerifyCode(String verifyCode);
}
