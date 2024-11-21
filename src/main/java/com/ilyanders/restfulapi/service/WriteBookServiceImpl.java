package com.ilyanders.restfulapi.service;

import com.ilyanders.restfulapi.entity.Book;
import com.ilyanders.restfulapi.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WriteBookServiceImpl implements WriteBookService {

    private final BookRepository bookRepository;

    @Override
    public void deleteBook(int id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Книги не существует!");
        }

        bookRepository.deleteById(id);
    }

    @Override
    public void addBook(Book book) {
        if (bookRepository.existsById(book.getId())) {
            throw new RuntimeException("Книга уже существует!");
        }

        bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book) {
        if (!bookRepository.existsById(book.getId())) {
            throw new RuntimeException("Книги не существует!");
        }

        bookRepository.save(book);
    }
}
