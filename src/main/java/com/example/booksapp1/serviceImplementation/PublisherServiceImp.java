package com.example.booksapp1.serviceImplementation;

import com.example.booksapp1.entities.Publisher;
import com.example.booksapp1.exception.UserException;
import com.example.booksapp1.repos.PublisherRepo;
import com.example.booksapp1.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImp implements PublisherService {

    @Autowired
    private PublisherRepo publishersRepo;

    @Override
    public List<Publisher> getPublishers() throws UserException {
        List<Publisher> publishers = publishersRepo.findAll();
        if (publishers.isEmpty())
            throw new UserException("data is not found");

        return publishers;
    }

    @Override
    public Publisher addPublisher(Publisher publishers) {

        return publishersRepo.save(publishers);
    }

    @Override
    public Publisher updatePublisher(int publisher_id, String publisher_name) throws UserException {

        Optional<Publisher> publishers1 = publishersRepo.findById(publisher_id);
        if (publishers1.isEmpty())
            throw new UserException("publisher id is not found");

        Publisher publishers = publishers1.get();
        publishers.setPublisher_name(publisher_name);
        return publishersRepo.save(publishers);
    }

    @Override
    public void rempovePublisher(int publisher_id) throws UserException {
        Optional<Publisher> publishers1 = publishersRepo.findById(publisher_id);
        if (publishers1.isEmpty())
            throw new UserException("user id is not found");

        publishersRepo.deleteById(publisher_id);


    }
}
