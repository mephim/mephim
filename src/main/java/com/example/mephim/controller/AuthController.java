package com.example.mephim.controller;

import com.example.mephim.entity.*;
import com.example.mephim.exception.EmailDuplicateException;
import com.example.mephim.exception.TokenRefreshException;
import com.example.mephim.exception.UserNotFoundException;
import com.example.mephim.exception.UsernameDuplicateException;
import com.example.mephim.payload.request.*;
import com.example.mephim.payload.response.JwtResponse;
import com.example.mephim.payload.response.MessageResponse;
import com.example.mephim.payload.response.TokenRefreshResponse;
import com.example.mephim.repos.RoleRepository;
import com.example.mephim.repos.UserRepository;
import com.example.mephim.response.CustomResponse;
import com.example.mephim.security.jwt.JwtUtils;
import com.example.mephim.security.services.RefreshTokenService;
import com.example.mephim.security.services.UserDetailsImpl;
import com.example.mephim.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    RefreshTokenService refreshTokenService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwt = jwtUtils.generateJwtToken(userDetails);

        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
                .collect(Collectors.toList());

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new CustomResponse<>(200, new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(),
                        userDetails.getUsername(), userDetails.getEmail(), roles)));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        try {
            userService.signUp(signUpRequest);
        } catch (UsernameDuplicateException e) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new CustomResponse<>(4, "Error: Username is already taken!"));
        } catch (EmailDuplicateException e) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new CustomResponse<>(5, "Error: Email is already in use!"));
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new CustomResponse<>(1, "User registered successfully!"));
    }

    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();

        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)

                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtUtils.generateTokenFromUsername(user.getUsername());
                    return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                        "Refresh token is not in database!"));
    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = userDetails.getId();
        refreshTokenService.deleteByUserId(userId);
        return ResponseEntity.ok(new MessageResponse("Log out successful!"));
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verify(@RequestBody VerifyCodeRequest request) throws UserNotFoundException {
        userService.verify(request.getVerifyCode());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new CustomResponse<>(1, "Verify code was sending!"));
    };

    @PostMapping("/request-code")
    public ResponseEntity<?> requestResetPassword(@RequestBody RequestResetPasswordRequest request) throws UserNotFoundException {
            userService.requestVerifyCode(request.getEmail());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new CustomResponse<>(1, "Email reset password was sending!"));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request) throws UserNotFoundException {
        userService.requestVerifyCode(request.getVerifyCode());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new CustomResponse<>(1, "Email reset password was sending!"));
    }
}
