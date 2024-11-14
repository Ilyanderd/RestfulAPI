package com.ilyanders.restfulapi.controller;

import com.ilyanders.restfulapi.entity.Book;
import com.ilyanders.restfulapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getOneBook(@PathVariable(name = "id") int id) {
        Book book = bookRepository.findById(id).orElse(null);

        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        if (bookRepository.existsById(book.getId())) {
            bookRepository.save(book);

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(name = "id") int id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
