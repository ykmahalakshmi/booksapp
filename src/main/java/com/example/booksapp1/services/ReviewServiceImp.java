package com.example.booksapp1.services;

import com.example.booksapp1.entities.Publishers;
import com.example.booksapp1.entities.Reviews;
import com.example.booksapp1.repos.ReviewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImp implements ReviewService {

    @Autowired
    private ReviewsRepo reviewsRepo;

    @Override
    public List<Reviews> getReviews() {

        return reviewsRepo.findAll();
    }
    @Override
    public Reviews addReview(Reviews reviews) {

        return reviewsRepo.save(reviews);
    }

    @Override
    public Reviews updateReviews(int review_id, String comment) {

        Optional<Reviews> reviews1=reviewsRepo.findById(review_id);
        if (reviews1.isEmpty())
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"review_id is not found");
        Reviews reviews =reviews1.get();
        reviews.setComment(comment);
        return reviewsRepo.save(reviews);
    }

    @Override
    public void rempoveReviews(int review_id) {
        Optional<Reviews> reviews1=reviewsRepo.findById(review_id);
        if (reviews1.isEmpty())
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"review_id is not found");
        reviewsRepo.deleteById(review_id);


    }
}

