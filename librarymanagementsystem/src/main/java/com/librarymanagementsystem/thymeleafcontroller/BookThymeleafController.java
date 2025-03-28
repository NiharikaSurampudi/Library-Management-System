package com.librarymanagementsystem.thymeleafcontroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.librarymanagementsystem.entity.Book;
import com.librarymanagementsystem.service.BookService;

import java.util.List;
import java.util.Optional;

@Controller  // ✅ Use @Controller instead of @RestController
@RequestMapping("/books")
public class BookThymeleafController {

    @Autowired
    private BookService bookService;

    // ✅ Show All Books
//    @GetMapping("/list")
//    public String getAllBooks(Model model) {
//        List<Book> books = bookService.getAllBooks();
//        model.addAttribute("books", books);
//        return "index";  // Loads index.html
//    }
    @GetMapping("/list")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books-list";  // ✅ Rename index.html to books-list.html
    }


    // ✅ Show Book Details
    @GetMapping("/details/{bookId}")
    public String getBookById(@PathVariable String bookId, Model model) {
        Optional<Book> book = bookService.getBookById(bookId);
        book.ifPresent(b -> model.addAttribute("book", b));
        return "book-details";  // Loads book-details.html
    }

    // ✅ Add a New Book Form
    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";  // Loads add-book.html
    }

    // ✅ Handle Form Submission for Adding a Book
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/books/list";  // Redirect to book list after adding
    }
    
 // ✅ Show Edit Form
//    @GetMapping("/edit/{id}")
//    public String showEditBookForm(@PathVariable String id, Model model) {
//        System.out.println("Editing Book ID: " + id);
//        
//        Optional<Book> book = bookService.getBookById(id);
//        
//        if (book.isPresent()) {
//            System.out.println("Book Found: " + book.get().getTitle());
//            model.addAttribute("book", book.get());
//            return "edit-book";  // Loads edit-book.html
//        } else {
//            System.out.println("Book Not Found!");
//        }
//        
//        return "redirect:/books/list";
//        // Redirect if book not found
//    }
    
    @GetMapping("/edit/{id}")
    public String showEditBookForm(@PathVariable String id, Model model) {
        System.out.println("Editing Book ID: " + id);

        Optional<Book> book = bookService.getBookById(id);

        if (book.isEmpty()) {  // 🔹 Instead of book.isPresent(), use book.isEmpty() check
            System.out.println("Book Not Found!");
            return "redirect:/books/list";  // Redirect if book not found
        }

        System.out.println("Book Found: " + book.get().getTitle());
        model.addAttribute("book", book.get());
        return "edit-book";  // Loads edit-book.html
    }

    // ✅ Handle Book Update
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book bookDetails) {
        bookService.updateBook(id, bookDetails);
        return "redirect:/books/list";  
    }

    // ✅ Delete Book
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books/list";  
    }
    
    
    @GetMapping("/searchById")
    public String searchBookById(@RequestParam("bookId") String bookId, Model model) {
        Optional<Book> book = bookService.getBookById(bookId);
        book.ifPresent(b -> model.addAttribute("books", List.of(b)));  // Show only found book
        return "books-list";
    }

    @GetMapping("/searchByTitle")
    public String searchBookByTitle(@RequestParam("title") String title, Model model) {
        List<Book> books = bookService.getBooksByTitle(title);
        model.addAttribute("books", books);
        return "books-list";
    }
}

