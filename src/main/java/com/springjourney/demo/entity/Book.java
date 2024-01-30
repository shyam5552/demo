package com.springjourney.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity


public class Book {
    @Id
    private int book_id;
    @Column
    private String book_name;
    @Column
    private String book_publisher;
    @Column
    private String book_author;

    public Book(int book_id, String book_name, String book_publisher, String book_author) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_publisher = book_publisher;
        this.book_author = book_author;
    }

    public Book() {
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_publisher() {
        return book_publisher;
    }

    public void setBook_publisher(String book_publisher) {
        this.book_publisher = book_publisher;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", book_publisher='" + book_publisher + '\'' +
                ", book_author='" + book_author + '\'' +
                '}';
    }
}
