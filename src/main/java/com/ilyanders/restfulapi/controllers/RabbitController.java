package com.ilyanders.restfulapi.controllers;

import com.ilyanders.restfulapi.entity.Book;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class RabbitController {

    private final AmqpTemplate amqpTemplate;

    @PostMapping
    public void addBookMessage(@RequestBody Book book) {
        amqpTemplate.convertAndSend("addQueue", book);
    }

    @PutMapping
    public void updateBookMessage(@RequestBody Book book) {
        amqpTemplate.convertAndSend("updateQueue", book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookMessage(@PathVariable("id") int id) {
        amqpTemplate.convertAndSend("deleteQueue", id);
    }
}
