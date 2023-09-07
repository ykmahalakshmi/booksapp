package com.example.booksapp1.services;

import com.example.booksapp1.Enum.RoleName;
import com.example.booksapp1.entities.Role;
import com.example.booksapp1.exception.UserException;

import java.util.List;

public interface RolesService {

    List<Role> getRoles() throws UserException;
    Role addRole(Role roles) throws UserException;

    Role updateRole(int role_id, RoleName rolename ) throws UserException;

    void rempoveRole(int role_id) throws UserException;
}

