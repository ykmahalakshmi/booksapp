package com.example.booksapp1.repos;

import com.example.booksapp1.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepo extends JpaRepository<Book, Integer> {

    @Query("Select b.filepath from Book b where bookId=:bookId")
    public String getPath(@Param("bookId") int bookid);
}
