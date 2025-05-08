package com.example.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Queue;

@Configuration
@EnableRabbit
public class RabbitmqConfig {
    @Bean
    public Queue lionGoGoQueue() {
        return new Queue("liongogo.test.queue");
    }
}
