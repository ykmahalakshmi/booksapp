package com.example.booksapp1.controllers;

import com.example.booksapp1.entities.Book;
import com.example.booksapp1.exception.UserException;
import com.example.booksapp1.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class BookController {
    @Autowired
    private BookService booksService;

    @GetMapping("/books")
   // @PreAuthorize("hasRole('ROLE_USER')||hasRole('ROLE_AUTHOR')")
    public List<Book> getBooks() throws UserException {
        return booksService.getBooks();
    }

    @PostMapping("/book")
    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    public Book addBook(@RequestBody Book books) {

        return booksService.addBook(books);
    }


    @PutMapping("/books/{book-id}/title/{title}")
    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    public Book updateBook(@PathVariable("book-id") int book_id, @PathVariable("title") String title) throws UserException {
        return booksService.updateBook(book_id, title);
    }

    @DeleteMapping("/book/{book-id}")
    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    public void removeBook(@PathVariable("book-id") int book_id) throws UserException {
        booksService.removeBook(book_id);
    }


    @GetMapping("/books-data/{book-id}")
    @PreAuthorize("hasRole('ROLE_USER')||hasRole('ROLE_AUTHOR')")
    public Stream<String> getBookData(@PathVariable("book-id") int id) throws IOException {
        return booksService.getBookData(id);
    }
    @PutMapping("/books/{book-id}/filepath/{filepath}")
        @PreAuthorize("hasRole('ROLE_AUTHOR')")
        public Book updateFilePath ( @PathVariable("book-id") int book_id, @PathVariable("filepath") String path) throws
        UserException {
            return booksService.updateFilePath(book_id, path);
        }

}






