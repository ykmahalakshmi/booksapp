package com.example.booksapp1.services;

import com.example.booksapp1.entities.Books;
import com.example.booksapp1.entities.Reviews;

import java.io.IOException;
import java.util.List;

public interface ReviewService {


    List<Reviews> getReviews();
    Reviews addReview(Reviews reviews);

    Reviews updateReviews(int review_id, String comment );

    void rempoveReviews(int review_id);




}
