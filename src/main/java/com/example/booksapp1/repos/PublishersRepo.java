package com.example.booksapp1.repos;

import com.example.booksapp1.entities.Publishers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.concurrent.Flow;

public interface PublishersRepo extends JpaRepository<Publishers, Integer> {
}
