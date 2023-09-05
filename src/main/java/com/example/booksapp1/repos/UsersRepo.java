package com.example.booksapp1.repos;

import com.example.booksapp1.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Integer>  {
}
