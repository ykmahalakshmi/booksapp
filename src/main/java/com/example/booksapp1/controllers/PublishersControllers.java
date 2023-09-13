package com.example.booksapp1.controllers;

import com.example.booksapp1.entities.Publisher;
import com.example.booksapp1.exception.UserException;
import com.example.booksapp1.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublishersControllers {

    @Autowired
    private PublisherService publisherService;


    @GetMapping("/publishers")
    public List<Publisher> get() throws UserException {

        return publisherService.getPublishers();
    }

    @PostMapping("/publishers")
    public Publisher addrow(@RequestBody Publisher publishers) {

        return publisherService.addPublisher(publishers);
    }


    @PutMapping("/publishers/{publisher-id}/publishername/{publisher-name}")
    public Publisher updatepublisher(@PathVariable("publisher-id") int publisherId, @PathVariable("publisher-name") String publisherName) throws UserException {
        return publisherService.updatePublisher(publisherId, publisherName);
    }

    @DeleteMapping("/publisher/{publisher-id}")
    public void removepublisher(@PathVariable("publisher-id") int publisherId) throws UserException {
        publisherService.rempovePublisher(publisherId);
    }
}



