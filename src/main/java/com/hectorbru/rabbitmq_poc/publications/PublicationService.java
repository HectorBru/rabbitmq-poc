package com.hectorbru.rabbitmq_poc.publications;

import com.hectorbru.rabbitmq_poc.messaging.MessagingProducer;
import com.hectorbru.rabbitmq_poc.publications.dtos.PublicationRequest;
import com.hectorbru.rabbitmq_poc.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PublicationService {

    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MessagingProducer messagingProducer;

    public List<Publication> getAllPublications() {
        return publicationRepository.findAll();
    }

    public Publication createPublication(PublicationRequest request) {
        Publication publication = new Publication(UUID.randomUUID(), request.title(), 0, userRepository.findById(request.userId()).get());
        return publicationRepository.save(publication);
    }

    public void giveLike(UUID publicationId) {
        messagingProducer.sendMessage(publicationId.toString());
    }
}
