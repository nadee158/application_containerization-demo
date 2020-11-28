package com.example.containerizationdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.containerizationdemo.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
