package com.pearsystem.service;

import com.pearsystem.model.Book;
import com.pearsystem.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public String saveBook( Book book){
        bookRepo.save(book);
    return "Book save with  id"+book.getBookId();
    }
    public  Book getBook(int bookId){
    return bookRepo.findById(bookId).orElseThrow(()->new RuntimeException("this Id is not content"+bookId));

    }
    public List<Book> removeBook(int bookId){
   bookRepo.deleteById(bookId);
   return  bookRepo.findAll();
    }
}
