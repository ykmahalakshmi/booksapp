package com.example.booksapp1.controllers;

import com.example.booksapp1.entities.User;
import com.example.booksapp1.exception.UserException;
import com.example.booksapp1.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersControllers {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    @PreAuthorize("hasRole('ROLE_USER')||hasRole('ROLE_AUTHOR')")
    public List<User> get() throws UserException {
        return usersService.getUsers();
    }

    @PostMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')||hasRole('ROLE_AUTHOR')")
    public User addusers(@RequestBody User users) throws UserException {

        return usersService.addUser(users);
    }


    @PutMapping("/user/{user-id}/username/{user-name}")
    @PreAuthorize("hasRole('ROLE_USER')||hasRole('ROLE_AUTHOR')")
    public User updateuser(@PathVariable("user-id") int id, @PathVariable("user-name") String username) throws UserException {
        return usersService.updateUser(id, username);
    }

    @DeleteMapping("/user/{user-id}")
    @PreAuthorize("hasRole('ROLE_USER')||hasRole('ROLE_AUTHOR')")
    public void removeuser(@PathVariable("user-id") int user_id) throws UserException {
        usersService.rempoveUser(user_id);
    }


    @GetMapping("/users-page/{page-num}/{limit}")
    @PreAuthorize("hasRole('ROLE_USER')||hasRole('ROLE_AUTHOR')")
    public Page<User> getg(@PathVariable("page-num")int num, @PathVariable("limit")int limit) throws UserException {
        return usersService.getUserpage(num,limit);
    }


    @GetMapping("/users-page/{page-num}/{limit}/{username}")
    @PreAuthorize("hasRole('ROLE_USER')||hasRole('ROLE_AUTHOR')")
    public Page<User> get1(@PathVariable("page-num")int num, @PathVariable("limit")int limit,@PathVariable("username")String name) throws UserException {
        return usersService.getUserpagebysort(num,limit,name);
    }
}

