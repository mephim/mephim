package com.example.mephim.security.services;

import com.example.mephim.entity.EProvider;
import com.example.mephim.entity.ERole;
import com.example.mephim.entity.Role;
import com.example.mephim.entity.User;
import com.example.mephim.exception.EmailDuplicateException;
import com.example.mephim.exception.UsernameDuplicateException;
import com.example.mephim.payload.request.SignupRequest;
import com.example.mephim.repos.RoleRepository;
import com.example.mephim.repos.UserRepository;
import com.example.mephim.template.mail.ConfirmMailTemplate;
import com.example.mephim.ultils.MailSender;
import com.example.mephim.ultils.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import static com.example.mephim.constants.Constants.VERIFY_MAIL;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    MailSender mailSender;

    @Override
    public void signUp(SignupRequest signUpRequest) throws UsernameDuplicateException, EmailDuplicateException {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new UsernameDuplicateException();
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new EmailDuplicateException();
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()), Instant.now(), EProvider.REGISTER.toString(), false);

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        // create verify code by random string
        String verifyCode = RandomString.generateString(50);

        user.setRoles(roles);
        user.setVerificationCode(verifyCode);
//        userRepository.save(user);

        // send verify code to the mail user to verify account
        sendCodeVerifyAccount(user.getEmail(),user.getUsername(), verifyCode);
    }

    @Override
    public User findByVerifyCode(String verifyCode) {
        return null;
    }

    public void sendCodeVerifyAccount(String email, String username, String code) {
        try {
            mailSender.send(email, VERIFY_MAIL, ConfirmMailTemplate.build(username, "http://172.25.240.1:9090/api/auth/verify-account/" + code));
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
