package com.example.booksapp1.controllers;

import com.example.booksapp1.entities.Books;
import com.example.booksapp1.entities.Publishers;
import com.example.booksapp1.entities.Users;
import com.example.booksapp1.repos.BooksRepo;
import com.example.booksapp1.services.BooksService;
import com.example.booksapp1.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class BooksControllers {
    @Autowired
    private BooksService booksService;

    @GetMapping("/getbooks")
    public List<Books> getBooks() {
        return booksService.getBooks();
    }
    @PostMapping("/addbook")
    public Books addbook(@RequestBody Books books) {

        return booksService.addBooks(books);
    }


    @PutMapping("/updatebooks/{book_id}/{title}")
    public Books updatebook(@PathVariable("book_id") int book_id, @PathVariable("title") String title) {
        return booksService.updateBooks(book_id, title);
    }

    @DeleteMapping("/deletebook/{book_id}")
    public void removebook(@PathVariable("book_id") int book_id) {
        booksService.rempoveBooks(book_id);
    }
//    @GetMapping("/getbooksdata")
//    public List getBooksdata() throws IOException {
//        return booksService.getbookdata();
//    }
    @GetMapping("/getbooksdata1/{bookid}")
    public Stream<String> getBooksdata1(@PathVariable("bookid")int id) throws IOException {
        return booksService.getbookdata1(id);
    }

}






