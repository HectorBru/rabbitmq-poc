package com.hectorbru.rabbitmq_poc.messaging.rabbitmq;

import com.hectorbru.rabbitmq_poc.messaging.MessagingProducer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer implements MessagingProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("users-actions", "gave-like", message);
    }
}
