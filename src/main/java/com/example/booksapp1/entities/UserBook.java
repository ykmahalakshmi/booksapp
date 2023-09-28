package com.example.booksapp1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;

import java.io.Serializable;

@Embeddable
@Table(name = "userbook")
public class UserBook implements Serializable {
    @Column(name="user_id")
    private int authourId;

    @Column(name="book_id")
    private int bookId;

    public int getAuthourId() {
        return authourId;
    }

    public void setAuthourId(int authourId) {
        this.authourId = authourId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
       this.bookId = bookId;
   }

}