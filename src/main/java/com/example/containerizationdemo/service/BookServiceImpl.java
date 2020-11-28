package com.example.containerizationdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.containerizationdemo.dao.BookRepository;
import com.example.containerizationdemo.domain.Book;
import com.example.containerizationdemo.dto.BookDTO;
import com.example.containerizationdemo.exception.ItemNotFoundException;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookDTO getBookById(long id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException("Book was not found - " + id));
		return this.convertBookToBookDTO(book);
	}

	@Override
	public List<BookDTO> getBookList() {
		List<Book> books = bookRepository.findAll();
		List<BookDTO> dtoList = new ArrayList<>();
		books.forEach(book -> {
			dtoList.add(this.convertBookToBookDTO(book));
		});
		return dtoList;
	}

	@Override
	public BookDTO createBook(BookDTO bookDTO) {
		Book book = this.convertBookDTOToBook(bookDTO);
		book = bookRepository.save(book);
		return this.convertBookToBookDTO(book);
	}

	@Override
	public BookDTO updateBook(BookDTO bookDTO) {
		Book book = bookRepository.getOne(bookDTO.getId());
		book.setAuthors((List<String>) ((ArrayList<String>) book.getAuthors()).clone());
		book.setDescription(book.getDescription());
		book.setIsbn(book.getIsbn());
		book.setName(book.getName());
		book = bookRepository.save(book);
		return this.convertBookToBookDTO(book);
	}

	@Override
	public Boolean deleteBook(long id) {
		bookRepository.deleteById(id);
		return true;
	}

	private BookDTO convertBookToBookDTO(Book book) {
		if (book != null) {
			BookDTO dto = new BookDTO();
			if (!(book.getAuthors() == null || book.getAuthors().isEmpty())) {
				dto.setAuthors((List<String>) ((ArrayList<String>) book.getAuthors()).clone());
			}
			dto.setDescription(book.getDescription());
			dto.setId(book.getId());
			dto.setIsbn(book.getIsbn());
			dto.setName(book.getName());
			return dto;
		}
		return null;
	}

	private Book convertBookDTOToBook(BookDTO bookDTO) {
		if (bookDTO != null) {
			Book book = new Book();
			if (!(bookDTO.getAuthors() == null || bookDTO.getAuthors().isEmpty())) {
				book.setAuthors((List<String>) ((ArrayList<String>) bookDTO.getAuthors()).clone());
			}
			book.setDescription(bookDTO.getDescription());
			book.setId(bookDTO.getId());
			book.setIsbn(bookDTO.getIsbn());
			book.setName(bookDTO.getName());
			return book;
		}
		return null;
	}

}
