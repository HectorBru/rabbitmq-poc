package com.hectorbru.rabbitmq_poc.messaging.rabbitmq;

import com.hectorbru.rabbitmq_poc.publications.PublicationRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RabbitMQConsumer {

    @Autowired
    PublicationRepository publicationRepository;

    @RabbitListener(queues = "likes")
    public void receiveLike(String message) {
        publicationRepository.increasePublicationLikes(UUID.fromString(message));
        System.out.println(message);
    }
}
