package com.example.booksapp1.services;

import com.example.booksapp1.entities.Books;
import com.example.booksapp1.repos.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class BooksServiceImp implements BooksService{


    @Autowired

    private BooksRepo booksRepo;

    @Override
    public List<Books> getBooks() {

        return booksRepo.findAll();
    }
    @Override
    public Books addBooks(Books books) {

        return booksRepo.save(books);
    }

    @Override
    public Books updateBooks(int book_id, String title) {

        Optional<Books> book1=booksRepo.findById(book_id);
        if (book1.isEmpty())
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"book_id is not found");
        Books books =book1.get();
        books.setTitle(title);
        return booksRepo.save(books);
    }

    @Override
    public void rempoveBooks(int book_id) {
        Optional<Books> books1=booksRepo.findById(book_id);
        if (books1.isEmpty())
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"book_id is not found");
        booksRepo.deleteById(book_id);


    }
//
//    @Override
//    public List getbookdata() throws IOException {
//        String s=booksRepo.getpath();
//        FileReader fr=new FileReader(s);
//        BufferedReader br=new BufferedReader(fr);
//        var line=br.readLine();
//        List<String> a=new ArrayList<>();
//        while (line!=null){
//            a.add(line);
//            line=br.readLine();
//
//        }
//
//        return a;
//    }

    @Override
    public Stream<String> getbookdata1(int bookid) throws IOException {
        String s=booksRepo.getpath1(bookid);
        System.out.println(s);
        FileReader fr=new FileReader(s);

        BufferedReader br=new BufferedReader(fr);
        var line =br.lines();

        return line;

    }
}
