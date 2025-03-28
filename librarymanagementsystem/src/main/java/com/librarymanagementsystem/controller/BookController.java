package com.librarymanagementsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.librarymanagementsystem.entity.Book;
import com.librarymanagementsystem.service.BookService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService; // Now uses interface
    
    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @GetMapping("/harika/{bookId}")
    public Optional<Book> getBookById(@PathVariable String bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("/niha/{title}")
    public Optional<Book> getBookByTitle(@PathVariable String title) {
        return bookService.getBookByTitle(title);
    }
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return bookService.updateBook(id, bookDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Book deleted successfully!";
    }
}

