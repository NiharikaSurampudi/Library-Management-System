package com.librarymanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
	
	
	// ✅ Default constructor (Required by JPA)
    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String bookId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    private String genre;

    @Column(nullable = false)
    private String availabilityStatus;

    public Long getId() { 
    	return id; 
    }
    public void setId(Long id) { 
    	this.id = id;
    }

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

//	public Book(String id, String bookId, String title, String author, String genre, String availabilityStatus) {
//		super();
//		this.id = id;
//		this.bookId = bookId;
//		this.title = title;
//		this.author = author;
//		this.genre = genre;
//		this.availabilityStatus = availabilityStatus;
//	}

	
}
