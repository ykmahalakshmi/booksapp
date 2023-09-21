package com.example.booksapp1.controllers;

import com.example.booksapp1.entities.Publisher;
import com.example.booksapp1.exception.UserException;
import com.example.booksapp1.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublishersControllers {

    @Autowired
    private PublisherService publisherService;


    @GetMapping("/publishers")
    @PreAuthorize("hasRole('ROLE_USER')||hasRole('ROLE_AUTHOR')")
    public List<Publisher> get() throws UserException {

        return publisherService.getPublishers();
    }

    @PostMapping("/publisher")
    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    public Publisher addrow(@RequestBody Publisher publishers) {

        return publisherService.addPublisher(publishers);
    }


    @PutMapping("/publisher/{publisher-id}/publishername/{publisher-name}")
    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    public Publisher updatepublisher(@PathVariable("publisher-id") int publisher_id, @PathVariable("publisher-name") String publisher_name) throws UserException {
        return publisherService.updatePublisher(publisher_id, publisher_name);
    }

    @DeleteMapping("/publisher/{publisher-id}")
    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    public void removepublisher(@PathVariable("publisher-id") int publisher_id) throws UserException {
        publisherService.rempovePublisher(publisher_id);
    }
}



