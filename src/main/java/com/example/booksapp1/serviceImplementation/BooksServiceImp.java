package com.example.booksapp1.serviceImplementation;

import com.example.booksapp1.entities.Book;
import com.example.booksapp1.exception.UserException;
import com.example.booksapp1.repos.BookRepo;
import com.example.booksapp1.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class BooksServiceImp implements BooksService {


    @Autowired

    private BookRepo booksRepo;

    @Override
    public List<Book> getBooks() throws UserException {
        List<Book> books = booksRepo.findAll();
        if (books.isEmpty())
            throw new UserException("data not found");
        return books;
    }

    @Override
    public Book addBook(Book books) {
        return booksRepo.save(books);
    }

    @Override
    public Book updateBook(int book_id, String title) throws UserException {

        Optional<Book> book1 = booksRepo.findById(book_id);
        if (book1.isEmpty())
            throw new UserException("bppk id not found");

        Book books = book1.get();
        books.setTitle(title);
        return booksRepo.save(books);
    }

    @Override
    public void rempoveBook(int book_id) throws UserException {
        Optional<Book> books1 = booksRepo.findById(book_id);
        if (books1.isEmpty())
            throw new UserException("book id is not found");

        booksRepo.deleteById(book_id);
    }


    @Override
    public Stream<String> getbookdata(int bookid) throws IOException {
        String s = booksRepo.getpath1(bookid);
        System.out.println(s);
        FileReader fr = new FileReader(s);

        BufferedReader br = new BufferedReader(fr);
        var line = br.lines();

        return line;

    }
}
