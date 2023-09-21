package com.example.booksapp1.security;


import com.example.booksapp1.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfoUserDetails implements UserDetails {



        private String name;
        private String password;
        private List<GrantedAuthority> authorities;

        public UserInfoUserDetails(User users){
            name=users.getUsername();
            password=users.getPassword();
            authorities= Arrays.stream(users.getRoles().split(",")).map(SimpleGrantedAuthority::new)
               .collect(Collectors.toList());
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
        return name;
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
        return true;
    }

    }

