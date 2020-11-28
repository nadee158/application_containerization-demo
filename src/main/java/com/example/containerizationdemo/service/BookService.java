package com.example.containerizationdemo.service;

import java.util.List;

import com.example.containerizationdemo.dto.BookDTO;

public interface BookService {

	public BookDTO getBookById(final long id);

	public List<BookDTO> getBookList();

	public BookDTO createBook(BookDTO bookDTO);

	public BookDTO updateBook(BookDTO bookDTO);

	public Boolean deleteBook(long id);

}
