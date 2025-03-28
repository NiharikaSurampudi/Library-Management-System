package com.librarymanagementsystem.service;

import java.util.List;
import java.util.Optional;
import com.librarymanagementsystem.entity.Book;

public interface BookService {
    Book addBook(Book book);
    List<Book> getAllBooks();
    Optional<Book> getBookById(String bookId);
    Optional<Book> getBookByTitle(String title);
    Book updateBook(Long id, Book bookDetails);
    void deleteBook(Long id);
    List<Book> getBooksByTitle(String title);

//	Optional<Book> getBookById(Long id);
	
}

