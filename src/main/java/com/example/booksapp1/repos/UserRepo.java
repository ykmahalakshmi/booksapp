package com.example.booksapp1.repos;

import com.example.booksapp1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer>  {
}
