package com.ilyanders.restfulapi.service;

import com.ilyanders.restfulapi.entity.Book;

public interface WriteBookService {
    void deleteBook(int id);
    void addBook(Book book);
    void updateBook(Book book);
}
