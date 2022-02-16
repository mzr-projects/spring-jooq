package com.mt.springjooq.services;

import lombok.extern.slf4j.Slf4j;
import models.Tables;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookService {

	private final DSLContext context;

	public BookService(DSLContext dslContext) {
		this.context = dslContext;
	}

	public List<models.tables.pojos.Book> getBooks() {
		log.info("Fetching all books");
		return context
				.selectFrom(models.Tables.BOOK)
				.fetchInto(models.tables.pojos.Book.class);
	}

	public void insertBook(models.tables.pojos.Book book) {
		log.info("Creating new Book : {}", book);
		context.insertInto(models.Tables.BOOK, Tables.BOOK.TITLE, models.Tables.BOOK.AUTHOR)
				.values(book.getTitle(), book.getAuthor())
				.execute();
	}
}
