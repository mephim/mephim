package com.example.mephim.controller;

import com.example.mephim.constants.Constants;
import com.example.mephim.entity.User;
import com.example.mephim.jwt.JwtUtils;
import com.example.mephim.repos.UserRepo;
import com.example.mephim.request.AccountVerifyRequest;
import com.example.mephim.request.LoginRequest;
import com.example.mephim.request.RegisterRequest;
import com.example.mephim.response.JwtResponse;
import com.example.mephim.service.SecurityService;
import com.example.mephim.service.impl.UserDetailServiceImpl;
import com.example.mephim.template.mail.RequestResetPasswordTemplate;
import com.example.mephim.ultils.AESCrypt;
import com.example.mephim.ultils.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class SecurityController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    SecurityService securityService;

    @Autowired
    private MailSender mailSender;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) throws MessagingException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailService
                .loadUserByUsername(authentication.getName());
        String jwtToken = jwtUtils.generateToken(userDetails);
        User user = userRepo.findByUsername(loginRequest.getUsername());

        String message = RequestResetPasswordTemplate.build("hoangvanhanh","fb.com/conghau6");
        mailSender.send("leconghau095@gmail.com","Reset password", message);

        return new ResponseEntity<>(new JwtResponse(jwtToken,user),HttpStatus.OK);
    }

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
