package com.example.booksapp1.services;

import com.example.booksapp1.entities.Publishers;
import com.example.booksapp1.entities.Users;

import java.util.List;

public interface PublisherService {


    List<Publishers> getPublishers();
    Publishers addPublisher(Publishers publishers);

    Publishers updatePublishers(int publisher_id, String publisher_name );

    void rempovePublisher(int publisher_id);
}

