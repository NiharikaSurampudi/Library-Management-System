package com.librarymanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")  // Ensure this maps to home.html
    public String home(Model model) {
        System.out.println("✅ Redirecting to home.html");
        model.addAttribute("message", "Welcome to the Library Management System!");
        return "home";  // Returns home.html instead of index.html
    }

//    @GetMapping("/books/list")  // This will load index.html when viewing books
//    public String getAllBooks(Model model) {
//        return "index";  // Loads index.html
//    }
}
