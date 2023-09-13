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

    @PostMapping("/roles")
    public Role addrow(@RequestBody Role roles) throws UserException {

        return rolesService.addRole(roles);
    }


    @PutMapping("/roles/{role-id}/rolename/{role-name}")
    public Role updaterole(@PathVariable("role-id") int roleId, @PathVariable("role-name") RoleName rolename) throws UserException {
        return rolesService.updateRole(roleId, rolename);
    }

    @DeleteMapping("/roles/{role-id}")
    public void removerole(@PathVariable("role-id") int roleId) throws UserException {
        rolesService.rempoveRole(roleId);
    }
}




