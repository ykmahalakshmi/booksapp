package com.example.booksapp1.serviceImplementation;


import com.example.booksapp1.security.UserInfoUserDetails;
import com.example.booksapp1.entities.User;
import com.example.booksapp1.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
    public class UsersService implements UserDetailsService {

        @Autowired
        private UserRepo userRepo;

        @Autowired
        private PasswordEncoder passwordEncoder;

        public String addUsers(User users){
            users.setPassword(passwordEncoder.encode(users.getPassword()));
            userRepo.save(users);
            return "User added successfully";
        }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = userRepo.findByUsername(username);

        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("user not found"));
    }
}

