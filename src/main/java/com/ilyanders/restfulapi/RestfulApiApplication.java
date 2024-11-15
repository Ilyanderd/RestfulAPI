package com.ilyanders.restfulapi;

import com.ilyanders.restfulapi.config.RabbitConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(RabbitConfig.class)
public class RestfulApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestfulApiApplication.class, args);
    }
}
