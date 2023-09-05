package com.example.booksapp1.controllers;

import com.example.booksapp1.entities.Roles;
import com.example.booksapp1.entities.Users;
import com.example.booksapp1.repos.UsersRepo;
import com.example.booksapp1.services.RolesService;
import com.example.booksapp1.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersControllers {

        @Autowired
        private UsersService usersService;

        @GetMapping("/getusers")
        public List<Users> get() {

            return usersService.getUsers();
        }

        @PostMapping("/adduser")
        public Users addusers(@RequestBody Users users) {

            return usersService.addUsers(users);
        }


        @PutMapping("/updateuser/{user_id}/{username}")
        public Users updateuser(@PathVariable("user_id") int user_id, @PathVariable("username") String username) {
            return usersService.updateUsers(user_id, username);
        }

        @DeleteMapping("/deleteuser/{user_id}")
        public void removeuser(@PathVariable("user_id") int user_id) { usersService.rempoveUsers(user_id);
        }
    }

