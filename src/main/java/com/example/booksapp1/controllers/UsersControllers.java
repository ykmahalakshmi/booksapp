package com.example.booksapp1.controllers;

import com.example.booksapp1.entities.User;
import com.example.booksapp1.exception.UserException;
import com.example.booksapp1.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersControllers {

    @Autowired
    private UsersService usersService;

    @GetMapping("/getusers")
    public List<User> get() throws UserException {
        return usersService.getUsers();
    }

    @PostMapping("/adduser")
    public User addusers(@RequestBody User users) {

        return usersService.addUser(users);
    }


    @PutMapping("/user/{user_id}/username/{username}")
    public User updateuser(@PathVariable("user_id") int user_id, @PathVariable("username") String username) throws UserException {
        return usersService.updateUser(user_id, username);
    }

    @DeleteMapping("/deleteuser/{user_id}")
    public void removeuser(@PathVariable("user_id") int user_id) throws UserException {
        usersService.rempoveUser(user_id);
    }
}

