package com.ilyanders.restfulapi.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public RabbitAdmin rabbitAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public Queue addQueue() {
        return new Queue("addQueue");
    }

    @Bean
    public Queue updateQueue() {
        return new Queue("updateQueue");
    }

    @Bean
    public Queue deleteQueue() {
        return new Queue("deleteQueue");
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("exchange");
    }

    @Bean
    public Binding addBinding() {
        return BindingBuilder.bind(addQueue()).to(exchange()).with("add");
    }

    @Bean
    public Binding updateBinding() {
        return BindingBuilder.bind(addQueue()).to(exchange()).with("update");
    }

    @Bean
    public Binding deleteBinding() {
        return BindingBuilder.bind(addQueue()).to(exchange()).with("delete");
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
