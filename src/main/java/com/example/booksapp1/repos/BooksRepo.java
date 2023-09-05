package com.example.booksapp1.repos;

import com.example.booksapp1.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BooksRepo extends JpaRepository<Books, Integer> {
//    @Query("Select b.filepath from Books b where book_id=3000")
//    public String getpath();
    @Query("Select b.filepath from Books b where book_id=:bookId")
    public String getpath1(@Param("bookId")int bookid);
}
