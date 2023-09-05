package com.example.booksapp1.services;

import com.example.booksapp1.entities.Roles;
import com.example.booksapp1.repos.RolesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImp  implements RolesService{
    @Autowired
    private RolesRepo rolesRepo;
    @Override
    public List<Roles> getRoles() {


        return rolesRepo.findAll();
    }

    @Override
    public Roles addRoles(Roles roles) {
        return rolesRepo.save(roles);
    }

    @Override
    public Roles updateRoles(int role_id, String rolename) {
        Optional<Roles> roles1=rolesRepo.findById(role_id);
        if (roles1.isEmpty())
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"role_id is not found");
        Roles roles=roles1.get();
        roles.setRolename(rolename);
       return rolesRepo.save(roles);
    }

    @Override
    public void rempoveRoles(int role_id) {
        Optional<Roles> roles1=rolesRepo.findById(role_id);
        if (roles1.isEmpty())
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"role_id is not found");
         rolesRepo.deleteById(role_id);


    }
}
