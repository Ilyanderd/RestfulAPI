package com.ilyanders.restfulapi.service;

import com.ilyanders.restfulapi.entity.Book;

import java.util.List;

public interface ReadBookService {
    List<Book> getAllBooks();
    Book getBook(int id);
}
