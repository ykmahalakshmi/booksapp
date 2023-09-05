package com.example.booksapp1.controllers;

import com.example.booksapp1.entities.Publishers;
import com.example.booksapp1.entities.Roles;
import com.example.booksapp1.repos.PublishersRepo;
import com.example.booksapp1.services.PublisherService;
import com.example.booksapp1.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublishersControllers {

    @Autowired
    private PublisherService publisherService;



    @GetMapping("/getpublishers")
    public List<Publishers> get() {

        return publisherService.getPublishers();
    }

    @PostMapping("/addPublisher")
    public Publishers addrow(@RequestBody Publishers publishers) {

        return publisherService.addPublisher(publishers);
    }


    @PutMapping("/updatepublisher/{publisher_id}/{publisher_name}")
    public Publishers updatepublisher(@PathVariable("publisher_id") int publisher_id, @PathVariable("publisher_name") String publisher_name) {
        return publisherService.updatePublishers(publisher_id, publisher_name);
    }

    @DeleteMapping("/deleterow1/{publisher_id}")
    public void removepublisher(@PathVariable("publisher_id") int publisher_id) {
        publisherService.rempovePublisher(publisher_id);
    }
}



