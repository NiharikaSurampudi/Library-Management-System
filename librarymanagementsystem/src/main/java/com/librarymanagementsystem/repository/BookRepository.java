package com.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.librarymanagementsystem.entity.Book;

import java.util.List;
//import com.library.management.model.Book;
import java.util.Optional;
@Repository

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByBookId(String bookId);
    Optional<Book> findByTitle(String title);
        List<Book> findByTitleContainingIgnoreCase(String title);
    }


