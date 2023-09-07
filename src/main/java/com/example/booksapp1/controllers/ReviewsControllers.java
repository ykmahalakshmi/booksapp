package com.example.booksapp1.controllers;

import com.example.booksapp1.entities.Review;
import com.example.booksapp1.exception.UserException;
import com.example.booksapp1.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewsControllers {
    @Autowired

    private ReviewService reviewService;

    @GetMapping("/getreviews")
    public List<Review> get() throws UserException {
        return reviewService.getReviews();
    }

    @PostMapping("/addReview")
    public Review addreview(@RequestBody Review reviews) {

        return reviewService.addReview(reviews);
    }


    @PutMapping("/review/{review_id}/comment/{comment}")
    public Review updatereview(@PathVariable("review_id") int review_id, @PathVariable("comment") String comment) throws UserException {
        return reviewService.updateReview(review_id, comment);
    }

    @DeleteMapping("/deletereview/{review_id}")
    public void removereview(@PathVariable("review_id") int review_id) throws UserException {
        reviewService.rempoveReview(review_id);
    }
}




