package com.example.mephim.service;

import com.example.mephim.entity.Account;
import com.example.mephim.request.RegisterRequest;

import javax.mail.MessagingException;
import java.security.NoSuchAlgorithmException;

public interface SecurityService {
    void createNewAccount(RegisterRequest registerRequest) throws MessagingException, NoSuchAlgorithmException;
    void requestResetPassword(String mail, String link);
    void resetPassword(String username, String newPassword);
}
