package com.librarymanagementsystem.service;

import com.librarymanagementsystem.entity.Book;
import com.librarymanagementsystem.repository.BookRepository;
//import com.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service  // ✅ Ensure this annotation is present
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(String bookId) {
        return bookRepository.findByBookId(bookId);
    }
//    @Override
//    public Optional<Book> getBookById(Long id) {
//        System.out.println("Fetching Book by ID: " + id);
//        Optional<Book> book = bookRepository.findById(id);
//        
//        if (book.isPresent()) {
//            System.out.println("Book Retrieved: " + book.get().getTitle());
//        } else {
//            System.out.println("Book Not Found in DB!");
//        }
//        
//        return book;
//    }

    @Override
    public Optional<Book> getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public Book updateBook(Long id, Book bookDetails) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setGenre(bookDetails.getGenre());
            book.setAvailabilityStatus(bookDetails.getAvailabilityStatus());
            return bookRepository.save(book);
        }).orElseThrow(() -> new RuntimeException("Book not found"));
    }
//   


    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    
//	@Override
//	public Optional<Book> getBookById(String bookId) {
//		// TODO Auto-generated method stub
//		return Optional.empty();
//	}
}
