package com.hectorbru.rabbitmq_poc.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue queue() {
        return new Queue("likes", true);
    }

    @Bean
    public Exchange exchange() {
        return new DirectExchange("users-actions");
    }

    @Bean
    public Binding binding(Queue queue, Exchange exchange) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("gave-like")
                .noargs();
    }
}
