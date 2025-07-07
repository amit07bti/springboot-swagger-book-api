package com.pearsystem.controller;

import com.pearsystem.model.Book;
import com.pearsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    //   http://localhost:9094/swagger-ui.html
    @Autowired
    private BookService bookService;


    @PostMapping("/save")
    public String saveBook(Book book){
      return   bookService.saveBook(book);

    }
    @GetMapping("/search_book/{bookId}")
    public Book getBook(@PathVariable int bookId){
     return bookService.getBook(bookId);
    }
    @DeleteMapping("/delete/{bookId}")
    public List<Book> deleteBook(@PathVariable int bookId){
      return bookService.removeBook(bookId);
    }

}
