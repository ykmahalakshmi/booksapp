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


    @GetMapping("/getpublishers")
    public List<Publisher> get() throws UserException {

        return publisherService.getPublishers();
    }

    @PostMapping("/addPublisher")
    public Publisher addrow(@RequestBody Publisher publishers) {

        return publisherService.addPublisher(publishers);
    }


    @PutMapping("/publisher/{publisher_id}/publishername/{publisher_name}")
    public Publisher updatepublisher(@PathVariable("publisher_id") int publisher_id, @PathVariable("publisher_name") String publisher_name) throws UserException {
        return publisherService.updatePublisher(publisher_id, publisher_name);
    }

    @DeleteMapping("/deletePublisher/{publisher_id}")
    public void removepublisher(@PathVariable("publisher_id") int publisher_id) throws UserException {
        publisherService.rempovePublisher(publisher_id);
    }
}



