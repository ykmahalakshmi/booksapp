package com.example.booksapp1.services;

import com.example.booksapp1.entities.User;
import com.example.booksapp1.exception.UserException;

import java.util.List;

public interface UsersService {


    List<User> getUsers() throws UserException;
    User addUser(User users);

    User updateUser(int user_id, String username ) throws UserException;

    void rempoveUser(int user_id) throws UserException;

}


