package com.springjourney.demo.service;

import com.springjourney.demo.Repository.Bookrepository;
import com.springjourney.demo.entity.Book;
import com.springjourney.demo.error.BookNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class BookserviceTest {
    @Autowired
    private Bookservice bookservice;
    @MockBean
    private Bookrepository bookrepository;


    @BeforeEach
    void setUp() {
        Book book = new Book();
        book.setBook_id(1);
        book.setBook_name("java");
        book.setBook_author("syam");
        book.setBook_publisher("gang");
        Mockito.when(bookrepository.findById(1)).thenReturn(Optional.of(book));

    }
    @Test
    @DisplayName("get data based on the valid bookid")
    //@Disabled
    public void getbookTest() throws BookNotFoundException {
        int book_id=1;
        Book book=bookservice.getbook(book_id);
        assertEquals(book_id,book.getBook_id());
    }
}