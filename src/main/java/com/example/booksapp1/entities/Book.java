package com.example.booksapp1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
    @Table(name = "books")
    public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int book_id;
        private  int publisher_id;
        private  int author_id;
        private  String title;
        private String filepath;
        private LocalDateTime created_at;

        @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", updatable = false, insertable = false)
    @JsonIgnore
    private Publisher publishers;

        @OneToMany(mappedBy = "books")
        @JsonIgnore
       private List<Review> reviews=new ArrayList<Review>();

    @ManyToMany
    @JoinTable(
            name = "userbook",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
   @JsonIgnore
    Set<User> users;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public Publisher getPublishers() {
        return publishers;
    }

    public void setPublishers(Publisher publishers) {
        this.publishers = publishers;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}



