package com.example.booksapp1.services;

import com.example.booksapp1.entities.Publishers;
import com.example.booksapp1.entities.Users;
import com.example.booksapp1.repos.PublishersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImp implements PublisherService{

    @Autowired
    private PublishersRepo publishersRepo;
    @Override
    public List<Publishers> getPublishers() {

            return publishersRepo.findAll();
        }
    @Override
    public Publishers addPublisher(Publishers publishers) {

        return publishersRepo.save(publishers);
    }

    @Override
    public Publishers updatePublishers(int publisher_id, String publisher_name) {

        Optional<Publishers> publishers1=publishersRepo.findById(publisher_id);
        if (publishers1.isEmpty())
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"publisher_id is not found");
        Publishers publishers =publishers1.get();
        publishers.setPublisher_name(publisher_name);
        return publishersRepo.save(publishers);
    }

    @Override
    public void rempovePublisher(int publisher_id) {
        Optional<Publishers> publishers1=publishersRepo.findById(publisher_id);
        if (publishers1.isEmpty())
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"user_id is not found");
        publishersRepo.deleteById(publisher_id);


    }
}
