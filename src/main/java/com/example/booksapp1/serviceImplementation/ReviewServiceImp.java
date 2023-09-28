package com.example.booksapp1.serviceImplementation;

import com.example.booksapp1.entities.Review;
import com.example.booksapp1.exception.UserException;
import com.example.booksapp1.repos.ReviewRepo;
import com.example.booksapp1.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImp implements ReviewService {

    @Autowired
    private ReviewRepo reviewsRepo;

    @Override
    public List<Review> getReviews() throws UserException {
        List<Review> reviews = reviewsRepo.findAll();
        if (reviews.isEmpty())
            throw new UserException("data is not found");

        return reviewsRepo.findAll();
    }

    @Override
    public Review addReview(Review reviews) {

        return reviewsRepo.save(reviews);
    }

    @Override
    public Review updateReview(int review_id, String comment) throws UserException {

        Optional<Review> reviews1 = reviewsRepo.findById(review_id);
        if (reviews1.isEmpty())
            throw new UserException("review id not found");

        Review reviews = reviews1.get();
        reviews.setComment(comment);
        return reviewsRepo.save(reviews);
    }

    @Override
    public void removeReview(int review_id) throws UserException {
        Optional<Review> reviews1 = reviewsRepo.findById(review_id);
        if (reviews1.isEmpty())
            throw new UserException("review id not found");

        reviewsRepo.deleteById(review_id);


    }
}

