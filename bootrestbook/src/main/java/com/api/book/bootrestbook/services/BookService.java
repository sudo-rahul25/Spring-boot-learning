package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;

import com.api.book.bootrestbook.entities.Book;

import org.springframework.stereotype.Service;

//ye layer dao layer se interact karti hai..db layer wali methods ko call krri hogi
//@Service or @Component lagao

@Service
public class BookService {
    private static List<Book> list = new ArrayList<>();
    static {
        list.add(new Book(12, "Java", "Rahul"));
        list.add(new Book(13, "Python", "Chandan"));
        list.add(new Book(14, "JavaScript", "Abhinav"));
    }

    // get all books
    public List<Book> getAllBooks() {
        return list;
    }

    // get single book by id
    public Book getBookById(int id) {
        Book book=null;
        for (Book b : list) {
            if(b.getId()==id){
                book=b;
                break;
            }
        }
        return book;
    }

    // adding the book to the list
    public Book addBook(Book b){
        list.add(b);
        return b;
    }

    public void deleteBook(int id) {
        Book book=null;
        for (Book b : list) {
            if(b.getId()==id){
                book=b;
                break;
            }
        }
        list.remove(book);
    }

    //UPDATE THE BOOK
    public void updateBook(Book book, int id) {
        Book bb=null;
        for (Book b : list) {
            if(b.getId()==id){
                bb=b;
                break;
            }
        }
        bb.setTitle(book.getTitle());
        bb.setAuthor(book.getAuthor());
    }

}
