package com.example.booksapp1.repos;

import com.example.booksapp1.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Integer> {
}
