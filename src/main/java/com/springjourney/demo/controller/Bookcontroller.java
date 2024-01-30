package com.springjourney.demo.controller;

import com.springjourney.demo.entity.AuthenticationRequest;
import com.springjourney.demo.entity.AuthenticationResponse;
import com.springjourney.demo.entity.Book;
import com.springjourney.demo.error.BookNotFoundException;
import com.springjourney.demo.service.Bookservice;
import com.springjourney.demo.service.MyUserDetailsService;
import com.springjourney.demo.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Bookcontroller {
    @Autowired
    private Bookservice bookservice;
    private final Logger logger= LoggerFactory.getLogger(Bookcontroller.class);
   @Autowired
    private AuthenticationManager authenticationManager;
   @Autowired
   private MyUserDetailsService userDetailsService;
   @Autowired
   private JwtUtil JwtTokenUtil;
    @RequestMapping(value = "/authentication",method = RequestMethod.POST)
    public ResponseEntity<?>createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)throws  Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new Exception("incorrect username or password",e);
        }

        final UserDetails userDetails= userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt=JwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping(value = "/books")
    public String savebook(@RequestBody Book book){
         bookservice.savebook(book);
         logger.info("we are at save method in controller class");
         return  "booksaved to db";


    }
    @GetMapping(value = "/books/{book_id}")
    public Book getbook(@PathVariable int book_id) throws BookNotFoundException {
        logger.info("we are at getbook method in controller class");
        return bookservice.getbook(book_id);
    }
    @GetMapping(value = "/books")
    public List<Book> getallbooks(){
        logger.info("we are at getallbook method in controller class");
        return bookservice.getallbooks();

    }
    @PutMapping(value = "/books/{book_id}")
    public String updatebook(@PathVariable int book_id,@RequestBody Book book){
        bookservice.updatebook(book);
        logger.info("we are at update method in controller class");
        return "book updated";

    }
    @DeleteMapping(value = "/books/{book_id}")
    public String deletebook(@PathVariable int book_id){
        bookservice.deletebook(book_id);
        logger.info("we are at delete method in controller class");
        return "book deleted from db";
    }

}
