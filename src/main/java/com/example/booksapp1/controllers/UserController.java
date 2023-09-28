package com.example.booksapp1.controllers;

import com.example.booksapp1.entities.AuthRequest;
import com.example.booksapp1.entities.User;
import com.example.booksapp1.exception.UserException;
import com.example.booksapp1.serviceImplementation.JwtService;
import com.example.booksapp1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService usersService;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/users")
    @PreAuthorize("hasRole('ROLE_USER')||hasRole('ROLE_AUTHOR')")
    public List<User> getUsers() throws UserException {
        return usersService.getUsers();
    }

    @PostMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')||hasRole('ROLE_AUTHOR')")
    public User addUser(@RequestBody User users) throws UserException {

        return usersService.addUser(users);
    }


    @PutMapping("/user/{user-id}/username/{user-name}")
    @PreAuthorize("hasRole('ROLE_USER')||hasRole('ROLE_AUTHOR')")
    public User updateUser(@PathVariable("user-id") int id, @PathVariable("user-name") String username) throws UserException {
        return usersService.updateUser(id, username);
    }

    @DeleteMapping("/user/{user-id}")
    @PreAuthorize("hasRole('ROLE_USER')||hasRole('ROLE_AUTHOR')")
    public void removeUser(@PathVariable("user-id") int user_id) throws UserException {
        usersService.removeUser(user_id);
    }


    @GetMapping("/users-page/{page-num}/{limit}")
    @PreAuthorize("hasRole('ROLE_USER')||hasRole('ROLE_AUTHOR')")
    public Page<User> getUserPage(@PathVariable("page-num")int num, @PathVariable("limit")int limit) throws UserException {
        return usersService.getUserpage(num,limit);
    }


    @GetMapping("/users-page/{page-num}/{limit}/{username}")
    @PreAuthorize("hasRole('ROLE_USER')||hasRole('ROLE_AUTHOR')")
    public Page<User> getUserPageByName(@PathVariable("page-num")int num, @PathVariable("limit")int limit, @PathVariable("username")String name) throws UserException {
        return usersService.getUserPageBySort(num,limit,name);
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws UsernameNotFoundException {
        Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(authRequest.getUsername());
        else
            throw new UsernameNotFoundException("Invalid username");
    }
}

