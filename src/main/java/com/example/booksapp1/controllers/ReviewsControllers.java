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

    @GetMapping("/reviews")
    public List<Review> get() throws UserException {
        return reviewService.getReviews();
    }

    @PostMapping("/reviews")
    public Review addreview(@RequestBody Review reviews) {

        return reviewService.addReview(reviews);
    }


    @PutMapping("/reviews/{review-id}/comment/{comment}")
    public Review updatereview(@PathVariable("review-id") int reviewId, @PathVariable("comment") String comment) throws UserException {
        return reviewService.updateReview(reviewId, comment);
    }

    @DeleteMapping("/reviews/{review-id}")
    public void removereview(@PathVariable("review-id") int id) throws UserException {
        reviewService.rempoveReview(id);
    }
}




