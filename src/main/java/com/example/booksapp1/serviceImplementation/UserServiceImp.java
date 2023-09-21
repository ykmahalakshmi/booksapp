package com.example.booksapp1.serviceImplementation;

import com.example.booksapp1.entities.User;
import com.example.booksapp1.exception.UserException;
import com.example.booksapp1.repos.UserRepo;
import com.example.booksapp1.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImp implements UsersService {
    @Autowired
    private UserRepo usersRepo;


    @Override
    public List<User> getUsers() throws UserException {
        List<User> users = usersRepo.findAll();
        if (users.isEmpty())
            throw new UserException("data is not there");

        return usersRepo.findAll();
    }

    @Override
    public User addUser(User users) throws UserException{
        Pattern pattern = Pattern.compile("[6-9][0-9]{9}");
        Matcher matcher = pattern.matcher(users.getPhone_number());
        User user1 = new User();
        if (matcher.matches()){
            user1.setPhone_number(users.getPhone_number());
        }
        else{
            throw new UserException("please enter a valid phone no");
        }
            user1.setUsername(users.getUsername());
            user1.setRoles(users.getRoles());
           // user1.setPassword(encoder.encode(users.getPassword()));
            user1.setCreated_at(LocalDateTime.now());

        return usersRepo.save(user1);
    }

    @Override
    public User updateUser(int user_id, String username) throws UserException {
        Optional<User> users1 = usersRepo.findById(user_id);
        if (users1.isEmpty())
            throw new UserException("user_id is not found");
        User users = users1.get();
        users.setUsername(username);
        return usersRepo.save(users);
    }

    @Override
    public void rempoveUser(int user_id) throws UserException {
        Optional<User> users1 = usersRepo.findById(user_id);
        if (users1.isEmpty())

            throw new UserException("user is not there");
        usersRepo.deleteById(user_id);

    }

    @Override
    public Page<User> getUserpage(int pagenum, int limit) {
        return usersRepo.findAll(PageRequest.of(pagenum, limit));
    }

    @Override
    public Page<User> getUserpagebysort(int pagenum, int limit, String username) {
        return usersRepo.findAll(PageRequest.of(pagenum, limit, Sort.by(username).descending()));
    }
}
