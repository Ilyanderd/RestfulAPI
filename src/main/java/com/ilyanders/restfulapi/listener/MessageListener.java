package com.ilyanders.restfulapi.listener;

import com.ilyanders.restfulapi.entity.Book;
import com.ilyanders.restfulapi.repository.BookRepository;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class MessageListener {

    private final BookRepository bookRepository;

    @Autowired
    public MessageListener(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RabbitListener(queues = "addQueue")
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @RabbitListener(queues = "updateQueue")
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @RabbitListener(queues = "deleteQueue")
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}
