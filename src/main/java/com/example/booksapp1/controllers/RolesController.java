package com.example.booksapp1.controllers;

import com.example.booksapp1.Enum.RoleName;
import com.example.booksapp1.entities.Role;
import com.example.booksapp1.exception.UserException;
import com.example.booksapp1.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RolesController {
    @Autowired
    private RolesService rolesService;

    @GetMapping("/roles")
    public List<Role> get() throws UserException {
        return rolesService.getRoles();
    }

    @PostMapping("/role")
    public Role addrow(@RequestBody Role roles) throws UserException {

        return rolesService.addRole(roles);
    }


    @PutMapping("/role/{role-id}/rolename/{role-name}")
    public Role updaterole(@PathVariable("role-id") int role_id, @PathVariable("role-name") RoleName rolename) throws UserException {
        return rolesService.updateRole(role_id, rolename);
    }

    @DeleteMapping("/role/{role-id}")
    public void removerole(@PathVariable("role-id") int role_id) throws UserException {
        rolesService.rempoveRole(role_id);
    }
}




