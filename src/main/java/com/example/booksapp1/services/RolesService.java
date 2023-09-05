package com.example.booksapp1.services;

import com.example.booksapp1.entities.Roles;

import java.util.List;

public interface RolesService {

    List<Roles> getRoles();
    Roles addRoles(Roles roles);

    Roles updateRoles(int role_id, String rolename );

    void rempoveRoles(int role_id);
}

