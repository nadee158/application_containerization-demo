package com.example.containerizationdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.containerizationdemo.dto.BookDTO;
import com.example.containerizationdemo.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookDTO>> getBookList() {
		List<BookDTO> bookList = bookService.getBookList();
		return new ResponseEntity<>(bookList, HttpStatus.OK);
	}

	@GetMapping(value = "/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDTO> getBookById(@PathVariable("id") long id) {
		BookDTO book = bookService.getBookById(id);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@PostMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
		BookDTO book = bookService.createBook(bookDTO);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@PutMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO bookDTO) {
		BookDTO book = bookService.updateBook(bookDTO);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@DeleteMapping(value = "/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deleteBook(@PathVariable("id") long id) {
		Boolean isDeleted = bookService.deleteBook(id);
		return new ResponseEntity<>(isDeleted, HttpStatus.OK);
	}

}
