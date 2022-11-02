package com.example.mephim.ultils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class MyUserDetailsImpl implements UserDetails {
        private String username;
        private String password;
        private Set<GrantedAuthority> authorities;
        private boolean enable;

        public MyUserDetailsImpl(String username, String password,
                                 Set<GrantedAuthority> authorities, boolean enable) {
            this.username = username;
            this.password = password;
            this.authorities = authorities;
            this.enable = enable;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return this.enable;
        }
    }