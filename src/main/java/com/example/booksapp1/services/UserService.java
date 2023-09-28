package com.example.booksapp1.services;

import com.example.booksapp1.entities.User;
import com.example.booksapp1.exception.UserException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {


    List<User> getUsers() throws UserException;
    User addUser(User users) throws UserException;

    User updateUser(int user_id, String username ) throws UserException;

    void removeUser(int user_id) throws UserException;

    Page<User> getUserpage(int pagenum, int limit);


    Page<User> getUserPageBySort(int pagenum, int limit, String username);

}


