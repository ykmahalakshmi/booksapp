package com.example.booksapp1.repos;

import com.example.booksapp1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer>  {

    Optional<User> findByUsername(String username);
}
