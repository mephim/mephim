package com.example.mephim.service.impl;

import com.example.mephim.entity.Account;
import com.example.mephim.entity.User;
import com.example.mephim.service.AccountService;
import com.example.mephim.service.UserService;
import com.example.mephim.ultils.MyUserDetailsImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service @Transactional @Slf4j
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    AccountService accountService;
    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if(user == null) {
            log.info("User not found in database");
            throw new UsernameNotFoundException("User not found in database");
        } else {
            log.info("User found in database {}", user.getAccount().getUsername());
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getAccount().getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRole().getRoleName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getAccount().getUsername(), user.getAccount().getPassword(), authorities);
    }
}
