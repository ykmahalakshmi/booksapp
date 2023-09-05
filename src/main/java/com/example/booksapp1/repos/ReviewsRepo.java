package com.example.booksapp1.repos;

import com.example.booksapp1.entities.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepo extends JpaRepository<Reviews, Integer> {
}
