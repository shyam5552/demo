package com.springjourney.demo.service;

import com.springjourney.demo.Repository.Bookrepository;
import com.springjourney.demo.entity.Book;

import com.springjourney.demo.error.BookNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Bookservice {
    @Autowired
    private Bookrepository bookrepository;
    private final Logger logger= LoggerFactory.getLogger(Bookservice.class);



    public void savebook(Book book) {
        logger.info("we are at  save method in bookservice class");
         bookrepository.save(book);


    }


    public Book getbook(int bookId) throws BookNotFoundException {
        logger.info("we are are at  getbook method  in bookservice class");
        Optional<Book>book= bookrepository.findById(bookId);
        if (!book.isPresent()){
            throw new BookNotFoundException("book not available");
        }
        return book.get();


    }

    public List<Book> getallbooks() {
        logger.info("we are are at  getall method  in bookservice class");
        return bookrepository.findAll();
    }

    public void updatebook(Book book) {
        logger.info("we are at update method in bookservice class");
        bookrepository.save(book);
    }

    public void deletebook(int bookId) {
        logger.info("we are are at  delete method  in bookservice class");
        bookrepository.deleteById(bookId);
    }
}
