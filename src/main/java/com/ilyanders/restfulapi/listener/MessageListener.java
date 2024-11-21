package com.ilyanders.restfulapi.listener;

import com.ilyanders.restfulapi.entity.Book;
import com.ilyanders.restfulapi.service.WriteBookService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
@AllArgsConstructor
public class MessageListener {
    private final WriteBookService writeBookService;

    @RabbitListener(queues = "addQueue")
    public void addBook(Book book) {
        try {
            writeBookService.addBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "updateQueue")
    public void updateBook(Book book) {
        try {
            writeBookService.updateBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "deleteQueue")
    public void deleteBook(int id) {
        try {
            writeBookService.deleteBook(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
