package com.example.booksapp1.controllers;

import com.example.booksapp1.entities.Book;
import com.example.booksapp1.exception.UserException;
import com.example.booksapp1.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class BooksControllers {
    @Autowired
    private BooksService booksService;

    @GetMapping("/books")
    public List<Book> getBooks() throws UserException {
        return booksService.getBooks();
    }

    @PostMapping("/book")
    public Book addbook(@RequestBody Book books) {

        return booksService.addBook(books);
    }


    @PutMapping("/books/{book-id}/title/{title}")
    public Book updatebook(@PathVariable("book-id") int book_id, @PathVariable("title") String title) throws UserException {
        return booksService.updateBook(book_id, title);
    }

    @DeleteMapping("/book/{book-id}")
    public void removebook(@PathVariable("book-id") int book_id) throws UserException {
        booksService.rempoveBook(book_id);
    }


    @GetMapping("/books-data/{book-id}")
    public Stream<String> getBooksdata1(@PathVariable("book-id") int id) throws IOException {
        return booksService.getbookdata(id);
    }

}






