package com.example.booksapp1.controllers;

import com.example.booksapp1.entities.Review;
import com.example.booksapp1.exception.UserException;
import com.example.booksapp1.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired

    private ReviewService reviewService;

    @GetMapping("/reviews")
    @PreAuthorize("hasRole('ROLE_USER')||hasRole('ROLE_AUTHOR')")
    public List<Review> getReviews() throws UserException {
        return reviewService.getReviews();
    }

    @PostMapping("/review")
    @PreAuthorize("hasRole('ROLE_USER')||hasRole('ROLE_AUTHOR')")
    public Review addReview(@RequestBody Review reviews) {

        return reviewService.addReview(reviews);
    }


    @PutMapping("/review/{review-id}/comment/{comment}")
    @PreAuthorize("hasRole('ROLE_USER')||hasRole('ROLE_AUTHOR')")
    public Review updateReview(@PathVariable("review-id") int review_id, @PathVariable("comment") String comment) throws UserException {
        return reviewService.updateReview(review_id, comment);
    }

    @DeleteMapping("/review/{review-id}")
    @PreAuthorize("hasRole('ROLE_USER')||hasRole('ROLE_AUTHOR')")
    public void removeReview(@PathVariable("review-id") int id) throws UserException {
        reviewService.removeReview(id);
    }
}




