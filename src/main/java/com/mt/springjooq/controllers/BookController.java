package com.mt.springjooq.controllers;

import com.mt.springjooq.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping(value = "/all")
	public List<models.tables.pojos.Book> getAllBooks() {
		return this.bookService.getBooks();
	}

	@PostMapping(value = "/create")
	public void createBook(@RequestBody models.tables.pojos.Book book) {
		this.bookService.insertBook(book);
	}
}
