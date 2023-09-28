package com.example.booksapp1.services;

import com.example.booksapp1.entities.Publisher;
import com.example.booksapp1.exception.UserException;

import java.util.List;

public interface PublisherService {


    List<Publisher> getPublishers() throws UserException;
    Publisher addPublisher(Publisher publishers);

    Publisher updatePublisher(int publisher_id, String publisher_name ) throws UserException;

    void removePublisher(int publisher_id) throws UserException;
}

