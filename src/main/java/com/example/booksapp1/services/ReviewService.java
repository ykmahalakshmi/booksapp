package com.example.booksapp1.services;

import com.example.booksapp1.entities.Review;
import com.example.booksapp1.exception.UserException;

import java.util.List;

public interface ReviewService {


    List<Review> getReviews() throws UserException;
    Review addReview(Review reviews);

    Review updateReview(int review_id, String comment ) throws UserException;

    void rempoveReview(int review_id) throws UserException;




}
