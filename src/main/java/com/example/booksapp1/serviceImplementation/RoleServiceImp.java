package com.example.booksapp1.serviceImplementation;

import com.example.booksapp1.Enum.RoleName;
import com.example.booksapp1.entities.Role;
import com.example.booksapp1.exception.UserException;
import com.example.booksapp1.repos.RoleRepo;
import com.example.booksapp1.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImp implements RolesService {
    @Autowired
    private RoleRepo rolesRepo;

    @Override
    public List<Role> getRoles() throws UserException {
        List<Role> roles = rolesRepo.findAll();
        if (roles.isEmpty())
            throw new UserException("data not found");

        return rolesRepo.findAll();
    }

    @Override
    public Role addRole(Role roles) throws UserException {
        Role role=new Role();
       
        if(roles.getRolename().equals(RoleName.author)||roles.getRolename().equals(RoleName.generaluser))
            role.setRolename(roles.getRolename());

       // else
         //  throw new UserException("role id not found");


        return rolesRepo.save(role);
    }

    @Override
    public Role updateRole(int role_id, RoleName rolename) throws UserException {
        Optional<Role> roles1 = rolesRepo.findById(role_id);
        if (roles1.isEmpty())
            throw new UserException("role id not found");

        Role roles = roles1.get();
        roles.setRolename(rolename);
        return rolesRepo.save(roles);
    }

    @Override
    public void rempoveRole(int role_id) throws UserException {
        Optional<Role> roles1 = rolesRepo.findById(role_id);
        if (roles1.isEmpty())
            throw new UserException("role id not found");

        rolesRepo.deleteById(role_id);


    }
}
