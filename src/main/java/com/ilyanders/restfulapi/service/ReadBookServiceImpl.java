package com.ilyanders.restfulapi.service;

import com.ilyanders.restfulapi.entity.Book;
import com.ilyanders.restfulapi.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReadBookServiceImpl implements ReadBookService {

    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(int id) {
        return bookRepository.findById(id).orElse(null);
    }
}
