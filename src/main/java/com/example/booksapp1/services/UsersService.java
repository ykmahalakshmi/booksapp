package com.example.booksapp1.services;

import com.example.booksapp1.entities.Roles;
import com.example.booksapp1.entities.Users;

import java.util.List;

public interface UsersService {


    List<Users> getUsers();
    Users addUsers(Users users);

    Users updateUsers(int user_id, String username );

    void rempoveUsers(int user_id);
}


