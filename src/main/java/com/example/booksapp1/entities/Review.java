package com.example.booksapp1.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;

    @Entity
    @Table(name = "reviews")
    public class Review {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="review_id")
        private int reviewId;
        @Column(name="book_id")
        private  int bookId;
        @Column(name="user_id")
        private  int userId;
        private  int rating;
        private String comment;

        private LocalDateTime createdAt;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "book_id", updatable = false, insertable = false)
        @JsonIgnore
        private Book books;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", updatable = false, insertable = false)
        @JsonIgnore
        private User users;


        public int getReviewId() {
            return reviewId;
        }

        public void setReviewId(int reviewId) {
            this.reviewId = reviewId;
        }

        public int getBookId() {
            return bookId;
        }

        public void setBookId(int bookId) {
            this.bookId = bookId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public Book getBooks() {
            return books;
        }

        public void setBooks(Book books) {
            this.books = books;
        }

        public User getUsers() {
            return users;
        }

        public void setUsers(User users) {
            this.users = users;
        }
    }
