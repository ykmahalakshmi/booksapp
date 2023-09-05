package com.example.booksapp1.controllers;

import com.example.booksapp1.entities.Roles;
import com.example.booksapp1.repos.RolesRepo;
import com.example.booksapp1.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RolesController {
    @Autowired
    private RolesService rolesService;

    @GetMapping("/getroles")
    public List<Roles> get() {
        return rolesService.getRoles();
    }

    @PostMapping("/addRole")
    public Roles addrow(@RequestBody Roles roles) {

        return rolesService.addRoles(roles);
    }


    @PutMapping("/updaterole/{role_id}/{rolename}")
    public Roles updaterole(@PathVariable("role_id") int role_id, @PathVariable("rolename") String rolename) {
        return rolesService.updateRoles(role_id, rolename);
    }

    @DeleteMapping("/deleterow/{role_id}")
    public void removerole(@PathVariable("role_id") int role_id) {
         rolesService.rempoveRoles(role_id);
    }
}




