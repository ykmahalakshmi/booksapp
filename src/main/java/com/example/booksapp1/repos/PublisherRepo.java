package com.example.booksapp1.repos;

import com.example.booksapp1.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<Publisher, Integer> {
}
