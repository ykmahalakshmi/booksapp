package com.example.booksapp1.services;

import com.example.booksapp1.entities.Book;
import com.example.booksapp1.exception.UserException;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public interface BooksService {


    List<Book> getBooks() throws UserException;
    Book addBook(Book books);

    Book updateBook(int book_id, String title ) throws UserException;

    void rempoveBook(int book_id) throws UserException;
  //  List getbookdata() throws IOException;
    Stream<String> getbookdata(int bookid) throws IOException;
}


