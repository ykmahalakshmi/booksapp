package com.example.booksapp1.controllers;

import com.example.booksapp1.entities.Books;
import com.example.booksapp1.entities.Reviews;
import com.example.booksapp1.entities.Roles;
import com.example.booksapp1.repos.ReviewsRepo;
import com.example.booksapp1.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewsControllers {
    @Autowired

    private ReviewService reviewService ;

    @GetMapping("/getreviews")
    public List<Reviews> get() {
        return reviewService.getReviews();
    }

    @PostMapping("/addReview")
    public Reviews addreview(@RequestBody Reviews reviews) {

        return reviewService.addReview(reviews);
    }


    @PutMapping("/updatereview/{review_id}/{comment}")
    public Reviews updatereview(@PathVariable("review_id") int review_id, @PathVariable("comment") String comment) {
        return reviewService.updateReviews(review_id, comment);
    }

    @DeleteMapping("/deletereview/{review_id}")
    public void removereview(@PathVariable("review_id") int review_id) {
        reviewService.rempoveReviews(review_id);
    }
}



//    @GetMapping("/reviewss")
//    public List<Reviews> getReviews(){
//        return reviewsRepo.findall();


