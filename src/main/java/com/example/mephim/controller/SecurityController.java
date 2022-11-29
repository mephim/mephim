package com.example.mephim.controller;

import com.example.mephim.constants.Constants;
import com.example.mephim.request.AccountVerifyRequest;
import com.example.mephim.request.RegisterRequest;
import com.example.mephim.service.SecurityService;
import com.example.mephim.ultils.AESCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class SecurityController {
    @Autowired
    SecurityService securityService;

    @PostMapping("/register-account")
    public ResponseEntity<?> registerAccount(@RequestBody RegisterRequest registerRequest) {
        try {
            securityService.createNewAccount(registerRequest);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/verify-account")
    public ResponseEntity<?> verifyAccount(@RequestBody AccountVerifyRequest accountVerifyRequest){
        if(accountVerifyRequest == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Long verifyCodeCreateTime = Long.valueOf(Objects.requireNonNull(AESCrypt.decrypt(accountVerifyRequest.getVerifyCode(), Constants.secretKey)).substring(0,10));
        Boolean verifyResult = securityService.verifyAccount(accountVerifyRequest.getVerifyCode(), verifyCodeCreateTime);
        if(verifyResult) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
