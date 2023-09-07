package com.example.booksapp1.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

        import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int user_id;
        private  String username;
        private  String phone_number;
        private  int role_id;
        private LocalDateTime created_at;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "role_id", updatable = false, insertable = false)
        @JsonIgnore
        private Role roles;
    @OneToMany(mappedBy = "users")
    @JsonIgnore // ignore the property from serialization
    private List<Review> reviews = new ArrayList<Review>();

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    Set <Book> books;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}

