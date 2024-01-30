package com.springjourney.demo.Repository;

import com.springjourney.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface Bookrepository extends JpaRepository<Book, Integer> {
}
