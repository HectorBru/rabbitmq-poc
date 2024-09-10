package com.hectorbru.rabbitmq_poc.publications;

import com.hectorbru.rabbitmq_poc.publications.dtos.PublicationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("publications/")
public class PublicationController {

    @Autowired
    PublicationService publicationService;

    @GetMapping
    public List<Publication> getAllPublications() {
        return publicationService.getAllPublications();
    }

    @PostMapping
    public Publication createPublication(@RequestBody PublicationRequest request) {
        return publicationService.createPublication(request);
    }

    @PutMapping
    public ResponseEntity<Void> giveLike(@RequestParam UUID publicationId) {
        publicationService.giveLike(publicationId);
        return ResponseEntity.accepted().build();
    }
}
