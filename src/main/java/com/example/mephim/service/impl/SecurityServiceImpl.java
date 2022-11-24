package com.example.mephim.service.impl;

import com.example.mephim.constants.Constants;
import com.example.mephim.entity.Account;
import com.example.mephim.entity.User;
import com.example.mephim.request.RegisterRequest;
import com.example.mephim.service.AccountService;
import com.example.mephim.service.SecurityService;
import com.example.mephim.service.UserService;
import com.example.mephim.template.mail.ConfirmMailTemplate;
import com.example.mephim.ultils.MailSender;
import com.example.mephim.ultils.RandomString;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;

    @Autowired
    private MailSender mailSender;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void createNewAccount(RegisterRequest registerRequest) throws MessagingException, NoSuchAlgorithmException {
        Long unixTime = System.currentTimeMillis() / 1000L;;
        String verificationCode = RandomString.getAlphaNumericString(50);
        Account account = new Account();
        account.setUsername(registerRequest.getUsername());
        account.setPassword(bCryptPasswordEncoder.encode(registerRequest.getPassword()));
        account.setRegisterDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));
        account.setProvider(registerRequest.getProvider());
        account.setIsEnable(true);
        account.setVerificationCode(DigestUtils.md5Hex(unixTime + verificationCode).toUpperCase());
        System.out.println("HEX: "+unixTime + verificationCode);
        Account accountSaved = accountService.createAccount(account);
        if (accountSaved != null) {
            User user = new User();
            user.setUserAddress(registerRequest.getAddress());
            user.setUserMail(registerRequest.getUserMail());
            user.setUserPhone(registerRequest.getUserPhone());
            user.setAccount(accountSaved);
            User userSaved = userService.createNewUser(user);
            if(userSaved != null) {
                requestVerifyAccount(userSaved.getUserMail(), accountSaved.getUsername(), "http://locahost:9090/reset?"+verificationCode);
            }
        }
    }

    @Override
    public void requestResetPassword(String mail, String link) {

    }

    @Override
    public void resetPassword(String username, String newPassword) {

    }

    void requestVerifyAccount(String mail, String username, String verifyLink) throws MessagingException {
        try {
            mailSender.send(mail, Constants.VERIFY_MAIL, ConfirmMailTemplate.build(username, verifyLink));
        } catch (Exception exception) {
            System.out.println("ERROR: "+ exception);
        }
    }
}
