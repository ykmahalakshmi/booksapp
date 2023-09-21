package com.example.booksapp1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;

import java.io.Serializable;

@Embeddable
@Table(name = "userbook")
public class UserBooks implements Serializable {
    @Column(name="user_id")
    private int authour_id;

    @Column(name="book_id")
    private int book_id;

    public int getAuthour_id() {
        return authour_id;
    }

    public void setAuthour_id(int authour_id) {
        this.authour_id = authour_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
       this.book_id = book_id;
   }

}