package com.example.booksapp1.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

        import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
    @Table(name = "users")
    public class Users {
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
        private Roles roles;
    @OneToMany(mappedBy = "users")
    @JsonIgnore // ignore the property from serialization
    private List<Reviews> reviews = new ArrayList<Reviews>();

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    Set <Books> books;


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

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }
}

