package com.example.mephim.service.impl;

import com.example.mephim.entity.Account;
import com.example.mephim.service.AccountService;
import com.example.mephim.ultils.MyUserDetailsImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service @Transactional
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    AccountService accountService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findByUsername(username);
        System.out.println("---account: " + account.getUsername() + " "+ account.getPassword());

        Set<GrantedAuthority> authorities = account.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole().getRoleName()))
                .collect(Collectors.toSet());
        System.out.println("---authorities: "+ authorities);
        return new MyUserDetailsImpl(
                account.getUsername(),
                account.getPassword(),
                authorities,
                account.getIsEnable());
    }
}
