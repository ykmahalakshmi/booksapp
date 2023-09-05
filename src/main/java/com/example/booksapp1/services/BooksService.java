package com.example.booksapp1.services;

import com.example.booksapp1.entities.Books;
import com.example.booksapp1.entities.Users;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public interface BooksService {


    List<Books> getBooks();
    Books addBooks(Books books);

    Books updateBooks(int book_id, String title );

    void rempoveBooks(int book_id);
  //  List getbookdata() throws IOException;
    Stream<String> getbookdata1(int bookid) throws IOException;
}


