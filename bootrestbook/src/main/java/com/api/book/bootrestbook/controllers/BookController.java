package com.api.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        return book;
    }


    //self made method - Rahul
    @PostMapping("/books/{id}/{title}/{author}")
    public Book addBook(@PathVariable("id") int id, @PathVariable("title") String title, @PathVariable("author") String author){
        
        Book b=new Book(id,title,author);
        bookService.addBook(b);
        return b;
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        Book b= this.bookService.addBook(book);
        return b;
    }

    // @DeleteMapping("/books/{id}")
    // public void deleteBook(@PathVariable("id") int id){

    //      this.bookService.deleteBook(id); 
    // }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") int id){
        
        try {
            this.bookService.deleteBook(id); 
            return ResponseEntity.ok().body("The requested resource has been deleted !!");
            //return ResponseEntity.of(Optional.of("hello")); it returns a code of 200
            //return ResponseEntity.internalServerError().body("deleted...");
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
         
    }

    @PutMapping("/books/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable("id") int id){
        this.bookService.updateBook(book,id);


    }

         
}
