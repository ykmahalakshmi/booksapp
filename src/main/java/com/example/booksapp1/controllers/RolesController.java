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

    @GetMapping("/getroles")
    public List<Role> get() throws UserException {
        return rolesService.getRoles();
    }

    @PostMapping("/addRole")
    public Role addrow(@RequestBody Role roles) throws UserException {

        return rolesService.addRole(roles);
    }


    @PutMapping("/role/{role_id}/rolename/{rolename}")
    public Role updaterole(@PathVariable("role_id") int role_id, @PathVariable("rolename") RoleName rolename) throws UserException {
        return rolesService.updateRole(role_id, rolename);
    }

    @DeleteMapping("/deleterow/{role_id}")
    public void removerole(@PathVariable("role_id") int role_id) throws UserException {
        rolesService.rempoveRole(role_id);
    }
}




