package com.example.booksapp1.controllers;

import com.example.booksapp1.entities.User;
import com.example.booksapp1.exception.UserException;
import com.example.booksapp1.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersControllers {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public List<User> get() throws UserException {
        return usersService.getUsers();
    }

    @PostMapping("/users")
    public User addusers(@RequestBody User users) {

        return usersService.addUser(users);
    }


    @PutMapping("/users/{user-id}/username/{user-name}")
    public User updateuser(@PathVariable("user-id") int id, @PathVariable("user-name") String userName) throws UserException {
        return usersService.updateUser(id, userName);
    }

    @DeleteMapping("/users/{user-id}")
    public void removeuser(@PathVariable("user-id") int userId) throws UserException {
        usersService.rempoveUser(userId);
    }


    @GetMapping("/users-page/pagenum/{page-num}/limit/{limit}")
    public Page<User> getg(@PathVariable("page-num")int num, @PathVariable("limit")int limit) throws UserException {
        return usersService.getUserpage(num,limit);
    }


    @GetMapping("/users-page/pahenum/{page-num}/limit/{limit}/username/{username}")
    public Page<User> get1(@PathVariable("page-num")int num, @PathVariable("limit")int limit,@PathVariable("username")String name) throws UserException {
        return usersService.getUserpagebysort(num,limit,name);
    }
}

