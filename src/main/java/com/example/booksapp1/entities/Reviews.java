package com.example.booksapp1.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;

    @Entity
    @Table(name = "reviews")
    public class Reviews {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int review_id;
        private  int book_id;
        private  int  user_id;
        private  int rating;
        private String comment;

        private LocalDateTime created_at;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "book_id", updatable = false, insertable = false)
        @JsonIgnore
        private Books books;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", updatable = false, insertable = false)
        @JsonIgnore
        private Users users;


        public int getReview_id() {
            return review_id;
        }

        public void setReview_id(int review_id) {
            this.review_id = review_id;
        }

        public int getBook_id() {
            return book_id;
        }

        public void setBook_id(int book_id) {
            this.book_id = book_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
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

        public LocalDateTime getCreated_at() {
            return created_at;
        }

        public void setCreated_at(LocalDateTime created_at) {
            this.created_at = created_at;
        }

        public Books getBooks() {
            return books;
        }

        public void setBooks(Books books) {
            this.books = books;
        }

        public Users getUsers() {
            return users;
        }

        public void setUsers(Users users) {
            this.users = users;
        }
    }
