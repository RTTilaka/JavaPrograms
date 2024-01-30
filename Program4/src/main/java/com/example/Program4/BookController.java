package com.example.Program4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
	 private final List<Book> books = new ArrayList<Book>();

	    @GetMapping
	    public List<Book> getAllBooks() {
	        return books;
	    }


	    @GetMapping("/{id}")
	    public Book getBookById(@PathVariable Long id) {
	        return findBookById(id);
	    }


	    @PostMapping
	    public Book addBook(@RequestBody Book book) {
	        books.add(book);
	        return book;
	    }


	    @PutMapping("/{id}")
	    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
	        Book existingBook = findBookById(id);

	        if (existingBook != null) {
	            existingBook.setTitle(updatedBook.getTitle());
	            existingBook.setAuthor(updatedBook.getAuthor());
	            existingBook.setPublicationYear(updatedBook.getPublicationYear());
	        }
	        return existingBook;
	    }


	    @DeleteMapping("/{id}")
	    public void deleteBook(@PathVariable Long id) {
	        Book bookToRemove = findBookById(id);
	        if (bookToRemove != null) {
	            books.remove(bookToRemove);
	        }
	    }


	    // Helper method to find a book by ID
	    private Book findBookById(Long id) {
	        for (Book book : books) {
	            if (book.getId().equals(id)) {
	                return book;
	            }
	        }
	        return null;
	    }

}
