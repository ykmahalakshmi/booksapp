package com.example.booksapp1.services;

import com.example.booksapp1.entities.Roles;
import com.example.booksapp1.entities.Users;
import com.example.booksapp1.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UsersService{
    @Autowired
    private UsersRepo usersRepo;
    @Override
    public List<Users> getUsers() {

        return usersRepo.findAll();
        }
        @Override
    public Users addUsers(Users users) {


            return usersRepo.save(users);
        }
        @Override
    public Users updateUsers(int user_id, String username) {
            Optional<Users> users1=usersRepo.findById(user_id);
            if (users1.isEmpty())
                throw new ResponseStatusException(HttpStatus.NO_CONTENT,"user_id is not found");
            Users users=users1.get();
            users.setUsername(username);
            return usersRepo.save(users);
        }
        @Override
    public void rempoveUsers(int user_id) {
            Optional<Users> users1=usersRepo.findById(user_id);
            if (users1.isEmpty())
                throw new ResponseStatusException(HttpStatus.NO_CONTENT,"user_id is not found");
            usersRepo.deleteById(user_id);

    }
}
